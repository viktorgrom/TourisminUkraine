package com.example.tourisminukraine.ui.placelist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.model.PlaceModel;

import java.util.List;

public class PlaceListViewModel extends ViewModel {

    private MutableLiveData<List<PlaceModel>> mutableLiveDataPlaceList;

    public PlaceListViewModel() {

    }

    public MutableLiveData<List<PlaceModel>> getMutableLiveDataPlaceList() {
        if (mutableLiveDataPlaceList == null)
            mutableLiveDataPlaceList = new MutableLiveData<>();
        mutableLiveDataPlaceList.setValue(Common.categorySelected.getFoods());

        return mutableLiveDataPlaceList;
    }
}