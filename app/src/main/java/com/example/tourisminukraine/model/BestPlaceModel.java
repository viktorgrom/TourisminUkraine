package com.example.tourisminukraine.model;

public class BestPlaceModel {
    private String category_id, place_id, name, image;

    public BestPlaceModel() {
    }

    public BestPlaceModel(String category_id, String place_id, String name, String image) {
        this.category_id = category_id;
        this.place_id = place_id;
        this.name = name;
        this.image = image;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
