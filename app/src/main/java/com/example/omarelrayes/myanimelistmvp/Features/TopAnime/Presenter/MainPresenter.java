package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Presenter;

import android.arch.lifecycle.LiveData;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;

import java.util.List;

public interface MainPresenter {

    LiveData<List<Anime>> getData();

}
