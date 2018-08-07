package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.BaseInteractor;
import com.example.omarelrayes.myanimelistmvp.Retrofit.ApiClient;
import com.example.omarelrayes.myanimelistmvp.Retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiInteractor implements BaseInteractor{

    ApiInterface apiInterface;

    @Override
    public LiveData<List<Anime>> getData() {

        final MutableLiveData<List<Anime>> animeList = new MutableLiveData<>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TopAnimeResponse> call = apiInterface.getTopAnimeList();
        call.enqueue(new Callback<TopAnimeResponse>() {
            @Override
            public void onResponse(Call<TopAnimeResponse> call, Response<TopAnimeResponse> response) {
                Log.d("ApiInteractor", "onResponse: Request Successful");
                animeList.setValue(response.body().getTop());
            }

            @Override
            public void onFailure(Call<TopAnimeResponse> call, Throwable t) {
                Log.d("ApiInteractor", "onFailure: " + t.getMessage());
            }
        });
        return animeList;
    }
}
