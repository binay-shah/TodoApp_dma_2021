package com.example.todoapp;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

    @Query("select * from todo order by priority")
    public LiveData<List<Todo>> getAllTodos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Todo todo);

}
