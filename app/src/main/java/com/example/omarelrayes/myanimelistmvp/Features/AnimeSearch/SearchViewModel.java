package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Presenter.SearchPresenterImp;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;

public class SearchViewModel extends ViewModel {

    private SearchPresenterImp presenterImp;

    public LiveData<PagedList<Anime>> getData(String query) {
        if (presenterImp == null)
            presenterImp = new SearchPresenterImp();
        return presenterImp.getResult(query);
    }

}
