package com.example.omarelrayes.myanimelistmvp.Model;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.omarelrayes.myanimelistmvp.Model.Api.ApiInteractor;
import com.example.omarelrayes.myanimelistmvp.Model.Local.DatabaseInteractor;

import java.util.List;

public class DataRepository {
    private static DataRepository repository;
    private ApiInteractor remoteInteractor;
    private DatabaseInteractor localInteractor;
    private LiveData<List<Anime>> list;

    private DataRepository(Context context) {
        this.remoteInteractor = new ApiInteractor();
        this.localInteractor = new DatabaseInteractor(context);
    }

    public static DataRepository getInstance(Context context) {
        if (repository == null) {

            repository = new DataRepository(context);

        }
        return repository;
    }

    public LiveData<List<Anime>> getData(boolean isNetworkAvailable) {
        if (isNetworkAvailable) {
            return remoteInteractor.getData();
        }
        else
            return localInteractor.getData();
    }

    public void cashData(List<Anime> animeList) {
        //NOTE : Clear DB excutes after cashing , should we use a workmanger ?

        //localInteractor.clearDatabase();
        localInteractor.cashData(animeList);
    }
}