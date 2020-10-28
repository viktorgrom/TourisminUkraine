package com.example.tourisminukraine.Callback;

import com.example.tourisminukraine.model.BestPlaceModel;

import java.util.List;

public interface IBestPlaceCallbackListener {
    void onBestPlaceLoadSuccess(List<BestPlaceModel> bestPlaceModels);
    void onBestPlaceFailed (String message);

}
