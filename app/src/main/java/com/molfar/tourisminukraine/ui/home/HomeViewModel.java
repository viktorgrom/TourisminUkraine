package com.molfar.tourisminukraine.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.molfar.tourisminukraine.Callback.IBestPlaceCallbackListener;
import com.molfar.tourisminukraine.Callback.ICategoryCallbackListener;
import com.molfar.tourisminukraine.Common.Common;
import com.molfar.tourisminukraine.model.BestPlaceModel;
import com.molfar.tourisminukraine.model.CategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements ICategoryCallbackListener, IBestPlaceCallbackListener {

    private MutableLiveData <List<BestPlaceModel>> bestPlaceList;
    private IBestPlaceCallbackListener bestPlaceCallbackListener;
    private MutableLiveData<List<CategoryModel>> categoryListMultable;
    private MutableLiveData<String > messageError = new MutableLiveData<>();
    private ICategoryCallbackListener categoryCallbackListener;

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

    public MutableLiveData<List<CategoryModel>> getCategoryListMultable() {
        if (categoryListMultable == null)
        {
            categoryListMultable = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadCategories();
        }
        return categoryListMultable;
    }

    public void loadCategories() {
        List<CategoryModel> tempList = new ArrayList<>();
        DatabaseReference categoryRef = FirebaseDatabase.getInstance().getReference(Common.CATEGORY_REF);
        categoryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot itemSnapShot:snapshot.getChildren())
                {
                    CategoryModel categoryModel = itemSnapShot.getValue(CategoryModel.class);
                    categoryModel.setMenu_id(itemSnapShot.getKey());
                    tempList.add(categoryModel);
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
    public void onCategoryLoadSuccess(List<CategoryModel> categoryModelList) {
        categoryListMultable.setValue(categoryModelList);
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