package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model;

import android.arch.lifecycle.LiveData;

import java.util.List;

public interface BaseInteractor {

    LiveData<List<Anime>> getData();

}
