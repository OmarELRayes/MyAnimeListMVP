package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;

import java.io.IOException;
import java.util.List;

public class AnimeSearchDataSource extends PageKeyedDataSource<Integer, Anime> {

    private int currentPageNumber;
    private ApiSearchInteractor interactor;
    private String query;


    // adding a limit manual
    private int maxPages;

    public AnimeSearchDataSource(String query) {
        currentPageNumber = 1;
        interactor = new ApiSearchInteractor();
        this.query = query;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Anime> callback) {

        List<Anime> data = null;
        try {
            data = interactor.getDataSync(query, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        callback.onResult(data, null, currentPageNumber++);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Anime> callback) {
        // Do nothing, since data is loaded from our initial load itself
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Anime> callback) {

        List<Anime> data = null;
        try {
            data = interactor.getDataSync(query, params.key + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        callback.onResult(data, currentPageNumber++);
    }
}