package com.molfar.tourisminukraine.ui.home;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.molfar.tourisminukraine.Adapter.MyBestPlaceAdapter;
import com.molfar.tourisminukraine.Adapter.MyCategoriesAdapter;
import com.molfar.tourisminukraine.Common.Common;
import com.molfar.tourisminukraine.Common.SpacesItemDecoration;
import com.molfar.tourisminukraine.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dmax.dialog.SpotsDialog;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    Unbinder unbinder;

    @BindView(R.id.recycler_popular)
    RecyclerView recycler_popular;
    @BindView(R.id.viewpager)
    LoopingViewPager viewPager;
    AlertDialog dialog;
    MyCategoriesAdapter adapter;

    LayoutAnimationController layoutAnimationController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, root);
        initViews();

        homeViewModel.getMessageError().observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(getContext(), "" +s, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        homeViewModel.getBestPlaceList().observe(getViewLifecycleOwner(), bestPlaceModels ->{
            MyBestPlaceAdapter adapter = new MyBestPlaceAdapter(getContext(),bestPlaceModels,true);
            viewPager.setAdapter(adapter);
        } );
        homeViewModel.getCategoryListMultable().observe(getViewLifecycleOwner(), categoryModelList ->{
            dialog.dismiss();
            adapter = new MyCategoriesAdapter(getContext(), categoryModelList);
            recycler_popular.setAdapter(adapter);
            recycler_popular.setLayoutAnimation(layoutAnimationController);
        });
        return root;
    }

    private void initViews() {

        setHasOptionsMenu(true);


        dialog = new SpotsDialog.Builder().setContext(getContext()).setCancelable(false).build();
        dialog.show();
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_item_from_left);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter != null)
                {
                    switch (adapter.getItemViewType(position))
                    {
                        case Common.DEFAULT_COLUMN_COUNT: return 1;
                        case Common.FULL_WIDTH_COLUMN: return 2;
                        default:return -1;

                    }
                }
                return -1;
            }
        });
        recycler_popular.setLayoutManager(layoutManager);
        recycler_popular.addItemDecoration(new SpacesItemDecoration(8));
    }

    @Override
    public void onResume() {
        super.onResume();
        viewPager.resumeAutoScroll();
    }

    @Override
    public void onPause() {
        viewPager.pauseAutoScroll();
        super.onPause();
    }
}