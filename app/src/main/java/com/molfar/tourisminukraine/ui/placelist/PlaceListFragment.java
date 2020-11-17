package com.molfar.tourisminukraine.ui.placelist;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.molfar.tourisminukraine.Adapter.MyPlaceListAdapter;
import com.molfar.tourisminukraine.Common.Common;
import com.molfar.tourisminukraine.R;
import com.molfar.tourisminukraine.model.PlaceModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PlaceListFragment extends Fragment {

    private PlaceListViewModel placeListViewModel;

    Unbinder unbinder;
    @BindView(R.id.recycler_place_list)
    RecyclerView recycler_place_list;

    LayoutAnimationController layoutAnimationController;
    MyPlaceListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        placeListViewModel =
                new ViewModelProvider(this).get(PlaceListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_place_list, container, false);

        unbinder = ButterKnife.bind(this, root);
        initViews();
        placeListViewModel.getMutableLiveDataPlaceList().observe(getViewLifecycleOwner(), placeModels -> {
            if (placeModels != null)
            {
                adapter = new MyPlaceListAdapter(getContext(),placeModels);
                recycler_place_list.setAdapter(adapter);
                recycler_place_list.setLayoutAnimation(layoutAnimationController);
            }
        });
        return root;
    }

    private void initViews() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(Common.categorySelected.getName());

        setHasOptionsMenu(true);

        recycler_place_list.setHasFixedSize(true);
        recycler_place_list.setLayoutManager(new LinearLayoutManager(getContext()));
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_item_from_left);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager)getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

        //Event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                startSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //Clear list when click to clear button on Search View
        ImageView closeButton = (ImageView)searchView.findViewById(R.id.search_close_btn);
        closeButton.setOnClickListener(v -> {
            EditText ed = (EditText)searchView.findViewById(R.id.search_src_text);
            //Clear text
            ed.setText("");
            //Clear query
            searchView.setQuery("", false);
            //Collapse the action view
            searchView.onActionViewCollapsed();
            //Collapse the search widget
            menuItem.collapseActionView();
            //Restore result to original
            placeListViewModel.getMutableLiveDataPlaceList();
        });
    }

    private void startSearch(String query) {
        List<PlaceModel> resultList = new ArrayList<>();
        for (int i=0; i<Common.categorySelected.getFoods().size(); i++)
        {
            PlaceModel placeModel = Common.categorySelected.getFoods().get(i);
            if (placeModel.getName().toLowerCase().contains(query))
                resultList.add(placeModel);

        }
        placeListViewModel.getMutableLiveDataPlaceList().setValue(resultList);
    }
}