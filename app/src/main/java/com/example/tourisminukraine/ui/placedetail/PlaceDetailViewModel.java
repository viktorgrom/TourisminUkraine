package com.example.tourisminukraine.ui.placedetail;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.model.PlaceModel;

public class PlaceDetailViewModel extends ViewModel {

    private MutableLiveData<PlaceModel> mutableLiveDataPlace;

    public PlaceDetailViewModel () {

    }

    public MutableLiveData<PlaceModel> getMutableLiveDataPlace() {
        if (mutableLiveDataPlace == null)
            mutableLiveDataPlace = new MutableLiveData<>();
        mutableLiveDataPlace.setValue(Common.selectedPlace);
        return mutableLiveDataPlace;
    }
}
