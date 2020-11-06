package com.example.tourisminukraine.EventBus;

import com.example.tourisminukraine.model.BestPlaceModel;

public class BestPlaceItemClick {
    private BestPlaceModel bestPlaceModel;

    public BestPlaceItemClick(BestPlaceModel bestPlaceModel) {
        this.bestPlaceModel = bestPlaceModel;
    }

    public BestPlaceModel getBestPlaceModel() {
        return bestPlaceModel;
    }

    public void setBestPlaceModel(BestPlaceModel bestPlaceModel) {
        this.bestPlaceModel = bestPlaceModel;
    }
}
