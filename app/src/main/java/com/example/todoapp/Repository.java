package com.example.todoapp;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Repository {

    private  static Repository sInstance;

    private LiveData<List<Todo>> todos;

    private AppDatabase database;


    private  Repository(Context context) {
        database = AppDatabase.getInstance(context);
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                todos = database.todoDao().getAllTodos();
            }
        });


    }

    public static Repository getInstance(Context context){
        if(sInstance == null){
            sInstance = new Repository(context);
        }
            return sInstance;
    }

    public LiveData<List<Todo>> getAllTodos(){
        return todos;
    }

    public Todo getTodoById(UUID id){
//        for (int i = 0; i < todos.size(); i++) {
//            Todo todo = todos.get(i);
//            if(todo.getId().equals(id)){
//                return todo;
//            }
//        }
        return null;
    }

    public void delete(UUID id){
//       Todo todo = getTodoById(id);
//       if(todo != null)
//        todos.remove(todo);
    }

    public void addTodo(Todo todo){

        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                database.todoDao().insert(todo);
            }
        });

    }

    public Todo update(Todo todo){
//        Todo newTodo = getTodoById(todo.getId());
//        newTodo.setTitle(todo.getTitle());
//        newTodo.setDescription(todo.getDescription());
//        newTodo.setPriority(todo.getPriority());
//        newTodo.setUpdatedAt(new Date());
        return null;
    }


}
