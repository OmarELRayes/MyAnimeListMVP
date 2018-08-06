package com.example.omarelrayes.myanimelistmvp.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.omarelrayes.myanimelistmvp.MainViewModel;
import com.example.omarelrayes.myanimelistmvp.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Model.AnimeAdapter;
import com.example.omarelrayes.myanimelistmvp.Presenter.MainPresenter;
import com.example.omarelrayes.myanimelistmvp.Presenter.MainPresenterImp;
import com.example.omarelrayes.myanimelistmvp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter;
    RecyclerView recyclerView;
    AnimeAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<Anime> animeList;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        if (viewModel.getPresenter() != null) {
            presenter = new MainPresenterImp(getLifecycle(), this, getApplicationContext());
            viewModel.setPresenter(presenter);
        }

        //presenter = new MainPresenterImp(getLifecycle(), this, getApplicationContext());
        animeList = new ArrayList<>();
        recyclerView = findViewById(R.id.recylcerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimeAdapter(this,animeList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void updateList(List<Anime> animeList) {
        this.animeList.clear();
        this.animeList.addAll(animeList);
        adapter.notifyDataSetChanged();
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
