package com.example.omarelrayes.myanimelistmvp.Model.Api;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.example.omarelrayes.myanimelistmvp.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Model.BaseInteractor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiInteractor implements BaseInteractor{

    ApiInterface apiInterface;

    @Override
    public MutableLiveData<ArrayList<Anime>> getData(){

        final MutableLiveData<ArrayList<Anime>> animeList = new MutableLiveData<>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiInterface.getTopAnimeList();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d("ApiInteractor", "onResponse: Request Successful");
                animeList.setValue(response.body().getTop());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("ApiInteractor", "onFailure: " + t.getMessage());
            }
        });
        return animeList;
    }
}
