package com.example.tourisminukraine.ui.placedetail;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.andremion.counterfab.CounterFab;
import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.R;
import com.example.tourisminukraine.model.CommentModel;
import com.example.tourisminukraine.model.PlaceModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dmax.dialog.SpotsDialog;

public class PlaceDetailFragment extends Fragment {

    private PlaceDetailViewModel placeDetailViewModel;
    private Unbinder unbinder;
    private android.app.AlertDialog waitingDialog;

    @BindView(R.id.img_place)
    ImageView img_place;
    @BindView(R.id.btnCart)
    CounterFab btnCard;
    @BindView(R.id.btn_rating)
    FloatingActionButton btn_rating;
    @BindView(R.id.place_name)
    TextView place_name;
    @BindView(R.id.place_descriptions)
    TextView place_descriptions;
    @BindView(R.id.food_price)
    TextView food_price;
    @BindView(R.id.number_button)
    ElegantNumberButton numberButton;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.btnShowComment)
    Button btnShowComment;

    @OnClick(R.id.btn_rating)
    void onRatingButtonClick()
    {
        showDialogRating();
    }

    //Діалог комент і рейтинг

    private void showDialogRating() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Рейтинг місця");
        builder.setMessage("Будь ласка опишіть Ваші враження");

        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_rating, null);

        RatingBar ratingBar = (RatingBar) itemView.findViewById(R.id.rating_bar);
        EditText edt_comment = (EditText) itemView.findViewById(R.id.edt_comment);

        builder.setView(itemView);

        builder.setNegativeButton("CANCEL", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.setPositiveButton("OK", (dialog, which) -> {
            CommentModel commentModel = new CommentModel();
            //commentModel.setName(Common.currenrUser.getName());

            //потрібно повернутись в реєстрацію і розібратись що це нижче
            //commentModel.setUid(Common.currenrUser.getUid());
            commentModel.setComment(edt_comment.getText().toString());
            commentModel.setRatingValue(ratingBar.getRating());
            Map<String ,Object> serverTimeStamp = new HashMap<>();
            serverTimeStamp.put ("timeStamp", ServerValue.TIMESTAMP );
            commentModel.setCommentTimeStamp(serverTimeStamp);

            placeDetailViewModel.setCommentModel(commentModel);


        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        placeDetailViewModel=
                new ViewModelProvider(this).get(PlaceDetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_place_detail, container,false);
        unbinder = ButterKnife.bind(this, root);
        initView();
        placeDetailViewModel.getMutableLiveDataPlace().observe(getViewLifecycleOwner(), new Observer<PlaceModel>() {
            @Override
            public void onChanged(PlaceModel placeModel) {
                PlaceDetailFragment.this.displayInfo(placeModel);
            }
        });
        placeDetailViewModel.getMutableLiveDataComment().observe(getViewLifecycleOwner(), commentModel -> {
            submitRatingToFirebase(commentModel);
        });


        return root;
    }
     //діалог
    private void initView() {
        waitingDialog = new SpotsDialog.Builder().setCancelable(false).setContext(getContext()).build();
    }

    //комент додається в базу
    private void submitRatingToFirebase(CommentModel commentModel) {
        waitingDialog.show();
        //в базу
        FirebaseDatabase.getInstance()
                .getReference(Common.COMMENT_REF)
                .child(Common.selectedPlace.getId())
                .push()
                .setValue(commentModel)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful())
                    {
                        //після додавання коменту до бази, оновлюємо місце
                        addRatingToPlace(commentModel.getRatingValue());
                    }
                    waitingDialog.dismiss();
                });

    }
    //оновлюємо рейтинг місця
    private void addRatingToPlace(float ratingValue) {
        FirebaseDatabase.getInstance()
                .getReference(Common.CATEGORY_REF)
                .child(Common.categorySelected.getMenu_id()) //обираєм категорію
                .child("foods") //обираємо масив
                .child(Common.selectedPlace.getKey()) //оскільки плейс це масив, тому ключем є інтекс масиву
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists())
                        {
                            PlaceModel placeModel = snapshot.getValue(PlaceModel.class);
                            placeModel.setKey(Common.selectedPlace.getKey()); //Важливо

                            //Додаємо рейтинг
                            if (placeModel.getRatingValue() == null)
                                placeModel.setRatingValue(0d); // d = lower case
                            if (placeModel.getRatingCount() == null)
                                placeModel.setRatingCount(0L); // 1 = L lower case, not 1
                            double sumRaiting = placeModel.getRatingValue() + ratingValue;
                            long ratingCount = placeModel.getRatingCount()+1;
                            double result = sumRaiting/ratingCount;

                            Map<String , Object> updateData = new HashMap<>();
                            updateData.put("ratingValue", result);
                            updateData.put("ratingCount", ratingCount);

                            //оновлено змінні з бази
                            placeModel.setRatingValue(result);
                            placeModel.setRatingCount(ratingCount);

                            snapshot.getRef()
                                    .updateChildren(updateData)
                                    .addOnCompleteListener(task -> {
                                        waitingDialog.dismiss();
                                        if (task.isSuccessful())
                                        {
                                            Toast.makeText(getContext(), "Дякуємо, Ваш відгук важливий !", Toast.LENGTH_SHORT).show();
                                            Common.selectedPlace = placeModel;
                                            placeDetailViewModel.setPlaceModel(placeModel); //Метод оновлення
                                        }
                                    });


                        }
                        else
                            waitingDialog.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        waitingDialog.dismiss();
                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }

    private void displayInfo(PlaceModel placeModel) {
        Glide.with(getContext()).load(placeModel.getImage()).into(img_place);
        place_name.setText(new StringBuilder(placeModel.getName()));
        place_descriptions.setText(new StringBuilder(placeModel.getDescription()));
        food_price.setText(new StringBuilder(placeModel.getPrice().toString()));

        if (placeModel.getRatingValue() != null)
        ratingBar.setRating(placeModel.getRatingValue().floatValue());

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.selectedPlace.getName());
    }


}
