package com.example.omarelrayes.myanimelistmvp.Presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Model.Api.ApiInteractor;
import com.example.omarelrayes.myanimelistmvp.Model.DataRepository;
import com.example.omarelrayes.myanimelistmvp.Model.Local.DatabaseInteractor;
import com.example.omarelrayes.myanimelistmvp.View.MainView;

import java.util.List;

public class MainPresenterImp implements MainPresenter, LifecycleOwner {

    DataRepository repository;
    ApiInteractor remoteInteractor;
    DatabaseInteractor localInteractor;
    Lifecycle lifecycle;
    MainView view;
    Context context;

    public MainPresenterImp(Lifecycle lifecycle, MainView view, Context context) {
        this.lifecycle = lifecycle;
        this.view = view;
        remoteInteractor = new ApiInteractor();
        localInteractor = new DatabaseInteractor(context);
        this.repository = DataRepository.getInstance(remoteInteractor,localInteractor);
    }

    @Override
    public void onResume() {
        repository.getData(view.getNetworkState())
                .observe(this, new Observer<List<Anime>>() {
            @Override
            public void onChanged(@Nullable List<Anime> animes) {
                //TODO update ui
                if(animes != null)
                view.updateList(animes);

                //when data is loaded from network , cache it
                if (view.getNetworkState() && animes != null)
                    repository.cashData(animes);
            }
        });

    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycle;
    }
}
