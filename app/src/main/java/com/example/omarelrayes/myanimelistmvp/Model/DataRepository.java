package com.example.omarelrayes.myanimelistmvp.Model;

import android.arch.lifecycle.LiveData;

import com.example.omarelrayes.myanimelistmvp.Model.Api.ApiInteractor;
import com.example.omarelrayes.myanimelistmvp.Model.Local.DatabaseInteractor;

import java.util.List;

public class DataRepository {
    private static DataRepository repository;
    private ApiInteractor remoteInteractor;
    private DatabaseInteractor localInteractor;
    private LiveData<List<Anime>> list;

    private DataRepository(ApiInteractor remoteInteractor, DatabaseInteractor localInteractor) {
        this.remoteInteractor = remoteInteractor;
        this.localInteractor = localInteractor;
    }

    public static DataRepository getInstance(ApiInteractor remoteInteractor, DatabaseInteractor localInteractor) {
        if(repository == null)
            repository = new DataRepository(remoteInteractor,localInteractor);
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