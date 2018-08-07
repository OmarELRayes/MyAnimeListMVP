package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Presenter;

import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.arch.paging.PagedList.Config.Builder;

import com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model.AnimeSearchDataSourceFactory;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;

public class SearchPresenterImp {
    private static final int PAGE_SIZE = 50;
    private AnimeSearchDataSourceFactory factory;
    private LiveData<PagedList<Anime>> result;

    public LiveData<PagedList<Anime>> getResult(String query) {

        factory = new AnimeSearchDataSourceFactory(query);

        PagedList.Config config = new Builder()
                .setInitialLoadSizeHint(PAGE_SIZE)
                .setEnablePlaceholders(true)
                .setPageSize(PAGE_SIZE)
                .build();

        result = new LivePagedListBuilder<>(factory, config).build();
        return result;
    }
}
