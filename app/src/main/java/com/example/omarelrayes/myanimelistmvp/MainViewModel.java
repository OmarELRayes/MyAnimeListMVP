package com.example.omarelrayes.myanimelistmvp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Presenter.MainPresenter;

import java.util.List;

public class MainViewModel extends ViewModel {


    private MainPresenter presenter;
    private MutableLiveData<List<Anime>> animeList;

    public MainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(MainPresenter presenter) {
        if (presenter == null)
            this.presenter = presenter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        presenter = null;
    }

    void init() {
    }

}
