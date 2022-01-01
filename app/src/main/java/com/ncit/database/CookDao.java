package com.ncit.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface CookDao {

    @Insert
    void createCook(Cook cook);
}
