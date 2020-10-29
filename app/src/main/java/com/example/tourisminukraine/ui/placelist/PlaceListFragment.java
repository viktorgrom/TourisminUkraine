package com.example.tourisminukraine.ui.placelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourisminukraine.Adapter.MyPlaceListAdapter;
import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.R;
import com.example.tourisminukraine.model.PlaceModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PlaceListFragment extends Fragment {

    private PlaceListViewModel slideshowViewModel;

    Unbinder unbinder;
    @BindView(R.id.recycler_place_list)
    RecyclerView recycler_place_list;

    LayoutAnimationController layoutAnimationController;
    MyPlaceListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(PlaceListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_place_list, container, false);

        unbinder = ButterKnife.bind(this, root);
        initViews();
        slideshowViewModel.getMutableLiveDataPlaceList().observe(getViewLifecycleOwner(), new Observer<List<PlaceModel>>() {
            @Override
            public void onChanged(List<PlaceModel> placeModels) {
                adapter = new MyPlaceListAdapter(getContext(),placeModels);
                recycler_place_list.setAdapter(adapter);
                recycler_place_list.setLayoutAnimation(layoutAnimationController);
            }
        });
        return root;
    }

    private void initViews() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(Common.categorySelected.getName());

        recycler_place_list.setHasFixedSize(true);
        recycler_place_list.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_item_from_left);
    }
}