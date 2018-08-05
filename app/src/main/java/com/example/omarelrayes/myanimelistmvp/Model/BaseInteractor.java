package com.example.omarelrayes.myanimelistmvp.Model;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;

public interface BaseInteractor {

    MutableLiveData<ArrayList<Anime>> getData();

}
