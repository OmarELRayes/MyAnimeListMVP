package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;


public class AnimeSearchDataSourceFactory extends DataSource.Factory<Integer, Anime> {


    private MutableLiveData<AnimeSearchDataSource> dataSource = new MutableLiveData<>();
    private String query;

    public AnimeSearchDataSourceFactory(String query) {
        this.query = query;
    }


    @Override
    public DataSource<Integer, Anime> create() {
        AnimeSearchDataSource source = new AnimeSearchDataSource(query);
        dataSource.postValue(source);
        return source;
    }

}
