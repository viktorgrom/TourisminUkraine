package com.example.tourisminukraine.EventBus;

import com.example.tourisminukraine.model.PlaceModel;

public class PlaceItemClick {
    private boolean success;
    private PlaceModel placeModel;

    public PlaceItemClick(boolean success, PlaceModel placeModel) {
        this.success = success;
        this.placeModel = placeModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public PlaceModel getPlaceModel() {
        return placeModel;
    }

    public void setPlaceModel(PlaceModel placeModel) {
        this.placeModel = placeModel;
    }
}
