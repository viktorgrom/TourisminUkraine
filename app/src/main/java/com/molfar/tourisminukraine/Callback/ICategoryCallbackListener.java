package com.molfar.tourisminukraine.Callback;

import com.molfar.tourisminukraine.model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryFailed (String message);
}
