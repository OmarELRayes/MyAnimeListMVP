package com.example.omarelrayes.myanimelistmvp.Retrofit;

import com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model.SearchResponse;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Api.TopAnimeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/top/anime")
    Call<TopAnimeResponse> getTopAnimeList();

    @GET("/search/anime/{query}/{page_number}")
    Call<SearchResponse> search(@Path("query") String animeName, @Path("page_number") int pageNumber);
}
