package com.example.tourisminukraine.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourisminukraine.Callback.IBestPlaceCallbackListener;
import com.example.tourisminukraine.Callback.IPopularCallbackListener;
import com.example.tourisminukraine.Common.Common;
import com.example.tourisminukraine.model.BestPlaceModel;
import com.example.tourisminukraine.model.PopularCategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements IPopularCallbackListener, IBestPlaceCallbackListener {

    private MutableLiveData <List<PopularCategoryModel>> popularList;
    private MutableLiveData <List<BestPlaceModel>> bestPlaceList;
    private MutableLiveData <String> messageError;
    private IPopularCallbackListener popularCallbackListener;
    private IBestPlaceCallbackListener bestPlaceCallbackListener;

    public HomeViewModel() {
       popularCallbackListener = this;
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

    public MutableLiveData<List<PopularCategoryModel>> getPopularList() {
        if (popularList == null)
        {
            popularList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadPopularList();
        }
        return popularList;
    }

    private void loadPopularList() {
        List <PopularCategoryModel> tempList = new ArrayList<>();
        DatabaseReference popularRef = FirebaseDatabase.getInstance().getReference(Common.POPULAR_CATEGORY_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot itemSnapshot: snapshot.getChildren())
                {
                    PopularCategoryModel model = itemSnapshot.getValue(PopularCategoryModel.class);
                    tempList.add(model);
                }
                popularCallbackListener.onPopularLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                popularCallbackListener.onPopularLoadFailed(error.getMessage());

            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onPopularLoadSuccess(List<PopularCategoryModel> popularCategoryModels) {
        popularList.setValue(popularCategoryModels);
    }

    @Override
    public void onPopularLoadFailed(String message) {
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