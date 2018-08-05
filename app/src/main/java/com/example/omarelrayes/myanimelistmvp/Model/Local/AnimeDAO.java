package com.example.omarelrayes.myanimelistmvp.Model.Local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.omarelrayes.myanimelistmvp.Model.Anime;

import java.util.List;

@Dao
public interface AnimeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void cashData(List<Anime> animes);

    @Query("SELECT * FROM Anime")
    LiveData<List<Anime>> getTopAnime();

    @Query("DELETE FROM Anime")
    void deleteAll();

}
