package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder>{

    List<Todo> data;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    public void setData(List<Todo> todos){
        data = todos;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = data.get(position);
        holder.titleTextView.setText(todo.getTitle());

    }

    @Override
    public int getItemCount() {
        if(data == null)
            return 0;

        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_tv);
        }
    }
}
