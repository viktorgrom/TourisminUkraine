package com.molfar.tourisminukraine.Callback;

import com.molfar.tourisminukraine.model.BestPlaceModel;

import java.util.List;

public interface IBestPlaceCallbackListener {
    void onBestPlaceLoadSuccess(List<BestPlaceModel> bestPlaceModels);
    void onBestPlaceFailed (String message);

}
