package com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.Model.AnimeSearchAdapter;
import com.example.omarelrayes.myanimelistmvp.Features.AnimeSearch.SearchViewModel;
import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.R;


public class SearchActivity extends AppCompatActivity {

    SearchViewModel viewModel;
    RecyclerView recyclerView;
    AnimeSearchAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initRecyclerView();

        viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        viewModel.getData("kkk").observe(this, new Observer<PagedList<Anime>>() {
            @Override
            public void onChanged(@Nullable PagedList<Anime> animes) {
                adapter.submitList(animes);
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.search_recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimeSearchAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
