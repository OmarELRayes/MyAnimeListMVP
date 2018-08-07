package com.example.omarelrayes.myanimelistmvp.Features.TopAnime;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Presenter.MainPresenter;

import java.util.List;

public class MainViewModel extends ViewModel {


    private MainPresenter presenter;
    private LiveData<List<Anime>> animeList;

    public void init(MainPresenter presenter) {
        this.presenter = presenter;

        if (animeList != null)
            return;
        animeList = presenter.getData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Anime>> getAnimeList() {
        return animeList;
    }

}
