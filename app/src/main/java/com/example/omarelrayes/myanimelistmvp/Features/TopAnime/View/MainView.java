package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.View;

public interface MainView {

    void showProgress();
    void hideProgress();
    void toasting(String message);
    boolean getNetworkState();

}
