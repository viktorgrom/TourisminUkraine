package com.example.tourisminukraine.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asksira.loopingviewpager.LoopingPagerAdapter;

import com.bumptech.glide.Glide;

import com.example.tourisminukraine.EventBus.BestPlaceItemClick;
import com.example.tourisminukraine.R;
import com.example.tourisminukraine.model.BestPlaceModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyBestPlaceAdapter extends LoopingPagerAdapter<BestPlaceModel> {

    @BindView(R.id.img_best_place)
    ImageView img_best_place;
    @BindView(R.id.txt_best_place)
    TextView txt_best_place;

    Unbinder unbinder;


    public MyBestPlaceAdapter(Context context, List<BestPlaceModel> itemList, boolean isInfinite) {
        super(context, itemList, isInfinite);
    }

    @Override
    protected View inflateView(int viewType, ViewGroup container, int listPosition) {
        return LayoutInflater.from(context).inflate(R.layout.layout_best_place_item, container,false);
    }

    @Override
    protected void bindView(View convertView, int listPosition, int viewType) {
        unbinder = ButterKnife.bind(this,convertView);
        //Set Data
        Glide.with(convertView).load(itemList.get(listPosition).getImage()).into(img_best_place);
        txt_best_place.setText(itemList.get(listPosition).getName());

        convertView.setOnClickListener(v -> {
            EventBus.getDefault().postSticky(new BestPlaceItemClick(itemList.get(listPosition)));
        });

    }
}
