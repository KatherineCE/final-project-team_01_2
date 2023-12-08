package com.example.final_project_team_01_2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    TextView titleView;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.titleview);
    }
}
