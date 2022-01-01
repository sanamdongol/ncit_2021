package com.ncit.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Cook.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract CookDao cookDao();
}
