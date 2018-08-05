package com.example.omarelrayes.myanimelistmvp.Model.Api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/top/anime")
    Call<ApiResponse> getTopAnimeList();
}
