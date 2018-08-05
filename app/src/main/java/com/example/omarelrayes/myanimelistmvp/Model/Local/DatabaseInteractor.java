package com.example.omarelrayes.myanimelistmvp.Model.Local;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;
import com.example.omarelrayes.myanimelistmvp.Model.BaseInteractor;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseInteractor implements BaseInteractor {

    AppDatabase database;
    Context context;
    AnimeDAO dao;

    public DatabaseInteractor(Context context) {
        this.context = context;
        database = AppDatabase.getInstance(context);
        dao = database.animeDAO();
    }

    @Override
    public LiveData<List<Anime>> getData() {
        return dao.getTopAnime();
    }

    public void cashData(final List<Anime> animes) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.cashData(animes);
            }
        });
    }

    public void clearDatabase() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteAll();
            }
        });
    }

}
