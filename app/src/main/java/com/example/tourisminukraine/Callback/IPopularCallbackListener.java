package com.example.tourisminukraine.Callback;

import com.example.tourisminukraine.model.PopularCategoryModel;

import java.util.List;

public interface IPopularCallbackListener {
    void onPopularLoadSuccess(List <PopularCategoryModel> popularCategoryModels);
    void onPopularLoadFailed (String message);
}
