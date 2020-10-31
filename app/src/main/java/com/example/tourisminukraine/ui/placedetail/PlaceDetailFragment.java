package com.example.tourisminukraine.ui.placedetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.andremion.counterfab.CounterFab;
import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.R;
import com.example.tourisminukraine.model.PlaceModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PlaceDetailFragment extends Fragment {

    private PlaceDetailViewModel placeDetailViewModel;
    private Unbinder unbinder;

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


    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState){
        placeDetailViewModel=
                new ViewModelProvider(this).get(PlaceDetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_place_detail, container,false);
        unbinder = ButterKnife.bind(this, root);
        placeDetailViewModel.getMutableLiveDataPlace().observe(getViewLifecycleOwner(), new Observer<PlaceModel>() {
            @Override
            public void onChanged(PlaceModel placeModel) {
                PlaceDetailFragment.this.displayInfo(placeModel);
            }
        });


        return root;
    }

    private void displayInfo(PlaceModel placeModel) {
        Glide.with(getContext()).load(placeModel.getImage()).into(img_place);
        place_name.setText(new StringBuilder(placeModel.getName()));
        place_descriptions.setText(new StringBuilder(placeModel.getDescription()));
        food_price.setText(new StringBuilder(placeModel.getPrice().toString()));

        ((AppCompatActivity)getActivity())
                .getSupportActionBar()
                .setTitle(Common.selectedPlace.getName());
    }


}
