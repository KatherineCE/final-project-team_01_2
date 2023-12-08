package com.example.final_project_team_01_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    Context context;
    List<Folder> items;

    public MainAdapter(Context context, List<Folder> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.folder_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.titleView.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
