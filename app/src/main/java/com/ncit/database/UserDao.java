package com.ncit.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addUser(User user);

    @Query("Select * from user_info")
    List<User> getAllUser();

    @Update
    void updateUser(User user);

    @Query("Delete from user_info where id=:id")
    void deleteUser(int id);

    @Query("Select * from user_info order by id Desc")
    List<User> getAllUserOrderAsc();

}
