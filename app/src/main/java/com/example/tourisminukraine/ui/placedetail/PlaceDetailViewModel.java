package com.example.tourisminukraine.ui.placedetail;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.model.CommentModel;
import com.example.tourisminukraine.model.PlaceModel;

public class PlaceDetailViewModel extends ViewModel {

    private MutableLiveData<PlaceModel> mutableLiveDataPlace;
    private MutableLiveData<CommentModel> mutableLiveDataComment;

    public void setCommentModel (CommentModel commentModel)
    {
        if (mutableLiveDataComment != null)
            mutableLiveDataComment.setValue(commentModel);
    }

    public MutableLiveData<CommentModel> getMutableLiveDataComment() {
        return mutableLiveDataComment;
    }

    public PlaceDetailViewModel () {
        mutableLiveDataComment = new MutableLiveData<>();

    }

    public MutableLiveData<PlaceModel> getMutableLiveDataPlace() {
        if (mutableLiveDataPlace == null)
            mutableLiveDataPlace = new MutableLiveData<>();
        mutableLiveDataPlace.setValue(Common.selectedPlace);
        return mutableLiveDataPlace;
    }

    public void setPlaceModel(PlaceModel placeModel) {
        if (mutableLiveDataPlace != null)
            mutableLiveDataPlace.setValue(placeModel);
    }
}
