package com.molfar.tourisminukraine.Callback;

import com.molfar.tourisminukraine.model.PopularCategoryModel;

import java.util.List;

public interface IPopularCallbackListener {
    void onPopularLoadSuccess(List <PopularCategoryModel> popularCategoryModels);
    void onPopularLoadFailed (String message);
}
