package com.example.tourisminukraine.ui.comments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourisminukraine.model.CommentModel;
import com.example.tourisminukraine.model.PlaceModel;

import java.util.List;


public class CommentViewModel extends ViewModel {
    private MutableLiveData<List<CommentModel>> mutableLiveDataPlaceList;

    public CommentViewModel() {
        mutableLiveDataPlaceList = new MutableLiveData<>();
    }

    public MutableLiveData<List<CommentModel>> getMutableLiveDataPlaceList() {
        return mutableLiveDataPlaceList;
    }

    public void setCommentList (List<CommentModel> commentList)
    {
        mutableLiveDataPlaceList.setValue(commentList);
    }
}
