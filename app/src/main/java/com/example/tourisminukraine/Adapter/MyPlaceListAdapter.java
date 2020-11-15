package com.example.tourisminukraine.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tourisminukraine.Callback.IRecyclerClickListener;
import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.EventBus.PlaceItemClick;
import com.example.tourisminukraine.R;
import com.example.tourisminukraine.model.PlaceModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyPlaceListAdapter extends RecyclerView.Adapter<MyPlaceListAdapter.MyViewHolder> {

    private final Context context;
    private final List<PlaceModel> placeModelList;

    public MyPlaceListAdapter(Context context, List<PlaceModel> placeModelList) {
        this.context = context;
        this.placeModelList = placeModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_place_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(placeModelList.get(position).getImage()).into(holder.img_place_image);
        //holder.txt_place_price.setText(new StringBuilder("$").append(placeModelList.get(position).getPrice()));
        holder.txt_place_name.setText(new StringBuilder("").append(placeModelList.get(position).getName()));

        //Event
        holder.setListener(new IRecyclerClickListener() {
            @Override
            public void onItemClickListener(View view, int pos) {
                Common.selectedPlace = placeModelList.get(pos);
                Common.selectedPlace.setKey(String.valueOf(pos));
                EventBus.getDefault().postSticky(new PlaceItemClick(true, placeModelList.get(pos)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return placeModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Unbinder unbinder;

        @BindView(R.id.txt_place_name)
        TextView txt_place_name;
        /*@BindView(R.id.txt_place_price)
        TextView txt_place_price;*/
        @BindView(R.id.img_place_image)
        ImageView img_place_image;
        @BindView(R.id.img_fav)
        ImageView img_fav;
        /*@BindView(R.id.img_quick_cart)
        ImageView img_cart;*/

        IRecyclerClickListener listener;

        public void setListener(IRecyclerClickListener listener) {
            this.listener = listener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClickListener(v, getAdapterPosition());
        }
    }
}
