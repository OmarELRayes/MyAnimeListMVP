package com.example.omarelrayes.myanimelistmvp.View;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;

import java.util.List;

public interface MainView {

    void showProgress();
    void hideProgress();

    void updateList(List<Anime> animeList);
    void toasting(String message);
    boolean getNetworkState();

}
