package com.example.medi3.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medi3.MainActivity3;
import com.example.medi3.Models.LatestReqModel;
import com.example.medi3.R;

import java.util.ArrayList;

public class LatestReqAdapter extends RecyclerView.Adapter<LatestReqAdapter.ViewHolder> {

    ArrayList<LatestReqModel> list;


    public LatestReqAdapter(ArrayList<LatestReqModel> list){
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_request, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LatestReqModel model1 = list.get(position);
        holder.name.setText(model1.getName());
        holder.bloodgroup.setText(model1.getBloodgroup());
        holder.mobileno.setText(model1.getMobileno());
        holder.state.setText(model1.getState());

        holder.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity3.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return  list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, bloodgroup,mobileno, state;
        Button status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.patientNameReqkk);
            bloodgroup = itemView.findViewById(R.id.bloodNameReqkk);
            mobileno = itemView.findViewById(R.id.mobileReq);
            state = itemView.findViewById(R.id.locationNameReq);
            status = itemView.findViewById(R.id.btnDonorStatus);

        }
    }
}
