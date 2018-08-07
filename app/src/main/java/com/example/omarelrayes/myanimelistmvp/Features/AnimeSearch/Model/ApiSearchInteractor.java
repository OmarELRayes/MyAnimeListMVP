package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model;

import android.util.Log;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Retrofit.ApiClient;
import com.example.omarelrayes.myanimelistmvp.Retrofit.ApiInterface;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiSearchInteractor {

    private ApiInterface apiInterface;
    private List<Anime> result;

    public List<Anime> getDataAsync(String query, int pageNumber) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<SearchResponse> call = apiInterface.search(query, pageNumber);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                Log.d("ApiInteractor", "onResponse: Request Successful");
                result = response.body().getResult();
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d("ApiInteractor", "onFailure: " + t.getMessage());
            }
        });
        return result;
    }

    public List<Anime> getDataSync(String query, int pageNumber) throws IOException {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<SearchResponse> call = apiInterface.search(query, pageNumber);
        return call.execute().body().getResult();
    }
}
