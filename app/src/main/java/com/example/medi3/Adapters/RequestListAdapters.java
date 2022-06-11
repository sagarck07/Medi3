package com.example.medi3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medi3.MainActivity2;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;

import java.util.ArrayList;

public class RequestListAdapters extends  RecyclerView.Adapter<RequestListAdapters.ViewHolder>{

    ArrayList<RequestList> list;

    public RequestListAdapters(ArrayList<RequestList> list ) {
        this.list = list;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_donate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestList model = list.get(position);
        holder.name.setText(model.getName());
        holder.bloodgroup.setText(model.getBloodgroup());
        holder.city.setText(model.getCity());
        holder.state.setText(model.getState());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Please register for donating blood", Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, bloodgroup, state, city;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.patientName);
            bloodgroup = itemView.findViewById(R.id.bloodName);
            city = itemView.findViewById(R.id.locationName);
            state = itemView.findViewById(R.id.additionalName);



        }
    }

}
