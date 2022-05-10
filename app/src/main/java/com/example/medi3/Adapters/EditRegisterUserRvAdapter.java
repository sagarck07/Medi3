package com.example.medi3.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medi3.Models.RequestList;
import com.example.medi3.R;

import java.util.ArrayList;

public class EditRegisterUserRvAdapter extends RecyclerView.Adapter<EditRegisterUserRvAdapter.ViewHolder> {

    ArrayList<RequestList> list;
    Context context;

    public EditRegisterUserRvAdapter(ArrayList<RequestList> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_donate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView patient, blood, location, additional;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
