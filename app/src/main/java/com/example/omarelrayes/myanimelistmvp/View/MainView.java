package com.example.omarelrayes.myanimelistmvp.View;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;

import java.util.ArrayList;

public interface MainView {

    void showProgress();
    void hideProgress();
    void updateList(ArrayList<Anime> animeList);
    void toasting(String message);
    boolean getNetworkState();

}
