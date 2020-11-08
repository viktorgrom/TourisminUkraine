package com.example.tourisminukraine.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourisminukraine.Callback.IBestPlaceCallbackListener;
import com.example.tourisminukraine.Callback.ICategoryCallbackListener;
import com.example.tourisminukraine.Callback.IPopularCallbackListener;
import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.model.BestPlaceModel;
import com.example.tourisminukraine.model.CategoryModel;
import com.example.tourisminukraine.model.PopularCategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements ICategoryCallbackListener, IBestPlaceCallbackListener {

    private MutableLiveData <List<CategoryModel>> categoryList;
    private MutableLiveData <List<BestPlaceModel>> bestPlaceList;
    private MutableLiveData <String> messageError;
    private ICategoryCallbackListener categoryCallbackListener;
    private IBestPlaceCallbackListener bestPlaceCallbackListener;

    public HomeViewModel() {
        categoryCallbackListener = this;
       bestPlaceCallbackListener = this;
    }

    public MutableLiveData<List<BestPlaceModel>> getBestPlaceList() {
        if (bestPlaceList == null)
        {
            bestPlaceList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadBestPlaceList();
        }
        return bestPlaceList;
    }

    private void loadBestPlaceList() {
        List <BestPlaceModel> tempList = new ArrayList<>();
        DatabaseReference bestPlaceRef = FirebaseDatabase.getInstance().getReference(Common.BEST_PLACE_REF);
        bestPlaceRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot itemSnapshot: snapshot.getChildren())
                {
                    BestPlaceModel model = itemSnapshot.getValue(BestPlaceModel.class);
                    tempList.add(model);
                }
                bestPlaceCallbackListener.onBestPlaceLoadSuccess(tempList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                bestPlaceCallbackListener.onBestPlaceFailed(error.getMessage());

            }
        });
    }

    public MutableLiveData<List<CategoryModel>> getPopularList() {
        if (categoryList == null)
        {
            categoryList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadCategoryList();
        }
        return categoryList;
    }

    private void loadCategoryList() {
        List <CategoryModel> tempList = new ArrayList<>();
        DatabaseReference categoryRef = FirebaseDatabase.getInstance().getReference(Common.CATEGORY_REF);
        categoryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot itemSnapshot: snapshot.getChildren())
                {
                    CategoryModel model = itemSnapshot.getValue(CategoryModel.class);
                    tempList.add(model);
                }
                categoryCallbackListener.onCategoryLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                categoryCallbackListener.onCategoryFailed(error.getMessage());

            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onCategoryLoadSuccess(List<CategoryModel> categoryModels) {
        categoryList.setValue(categoryModels);
    }

    @Override
    public void onCategoryFailed(String message) {
        messageError.setValue(message);

    }

    @Override
    public void onBestPlaceLoadSuccess(List<BestPlaceModel> bestPlaceModels) {
        bestPlaceList.setValue(bestPlaceModels);
    }

    @Override
    public void onBestPlaceFailed(String message) {
        messageError.setValue(message);

    }
}