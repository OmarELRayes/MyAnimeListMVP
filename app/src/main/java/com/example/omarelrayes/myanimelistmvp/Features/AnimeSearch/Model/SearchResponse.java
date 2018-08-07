package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.squareup.moshi.Json;

import java.util.List;

public class SearchResponse {

    @Json(name = "result_last_page")
    private int pageCount;

    private List<Anime> result;

    public int getPageCount() {
        return pageCount;
    }

    public List<Anime> getResult() {
        return result;
    }
}
