package com.example.omarelrayes.myanimelistmvp.Model;

import android.arch.lifecycle.MutableLiveData;

import com.example.omarelrayes.myanimelistmvp.Model.Api.ApiInteractor;
import com.example.omarelrayes.myanimelistmvp.Model.Local.DatabaseInteractor;

import java.util.ArrayList;

public class DataRepository {
    private static DataRepository repository;
    private ApiInteractor remoteInteractor;
    private DatabaseInteractor localInteractor;

    private DataRepository(ApiInteractor remoteInteractor, DatabaseInteractor localInteractor) {
        this.remoteInteractor = remoteInteractor;
        this.localInteractor = localInteractor;
    }

    public static DataRepository getInstance(ApiInteractor remoteInteractor, DatabaseInteractor localInteractor) {
        if(repository == null)
            repository = new DataRepository(remoteInteractor,localInteractor);
        return repository;
    }

    public MutableLiveData<ArrayList<Anime>> getData(boolean isNetworkAvailable){
        if(isNetworkAvailable)
            return remoteInteractor.getData();
        //todo save data in database
        else
            return localInteractor.getData();
    }

    public void cashData(ArrayList<Anime> animeList){
        // todo
    }


}
