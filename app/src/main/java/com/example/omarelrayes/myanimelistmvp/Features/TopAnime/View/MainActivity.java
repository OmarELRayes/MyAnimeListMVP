package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.MainViewModel;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.AnimeAdapter;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Presenter.MainPresenter;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Presenter.MainPresenterImp;
import com.example.omarelrayes.myanimelistmvp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter = new MainPresenterImp(this, getApplicationContext());
    RecyclerView recyclerView;
    AnimeAdapter adapter;
    LinearLayoutManager layoutManager;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        presenter = new MainPresenterImp(this, getApplicationContext());

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.init(presenter);
        viewModel.getAnimeList().observe(this, new Observer<List<Anime>>() {
            @Override
            public void onChanged(@Nullable List<Anime> animes) {
                adapter.updateItems(animes);
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.main_recylcer);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimeAdapter(this, new ArrayList<Anime>());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void toasting(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean getNetworkState() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}