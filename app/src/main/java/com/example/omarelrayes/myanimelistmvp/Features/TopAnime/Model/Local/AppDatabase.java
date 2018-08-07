package com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.omarelrayes.myanimelistmvp.Features.TopAnime.Model.Anime;

@Database(entities = {Anime.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class,
                    "anime-list").build();

        return INSTANCE;
    }

    public abstract AnimeDAO animeDAO();
}