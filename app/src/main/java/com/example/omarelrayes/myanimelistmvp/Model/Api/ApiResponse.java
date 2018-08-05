package com.example.omarelrayes.myanimelistmvp.Model.Api;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;

import java.util.ArrayList;

public class ApiResponse {

    private ArrayList<Anime> top;

    public ArrayList<Anime> getTop() {
        return top;
    }

    public void setTop(ArrayList<Anime> top) {
        this.top = top;
    }
}
