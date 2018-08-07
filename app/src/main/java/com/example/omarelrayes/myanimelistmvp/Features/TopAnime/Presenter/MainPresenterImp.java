package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Presenter;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.DataRepository;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.View.MainView;

import java.util.List;

public class MainPresenterImp implements MainPresenter {

    private DataRepository repository;
    private MainView view;

    public MainPresenterImp(MainView view, Context context) {
        this.view = view;
        this.repository = DataRepository.getInstance(context);
    }

    public LiveData<List<Anime>> getData() {
        return repository.getData(view.getNetworkState());
    }
}
