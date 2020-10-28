package com.example.tourisminukraine.Callback;

import com.example.tourisminukraine.model.BestPlaceModel;
import com.example.tourisminukraine.model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryFailed (String message);
}
