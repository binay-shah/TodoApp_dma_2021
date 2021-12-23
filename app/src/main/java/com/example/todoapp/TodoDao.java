package com.example.todoapp;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

    @Query("select * from todo order by priority")
    public List<Todo> getAllTodos();
}
