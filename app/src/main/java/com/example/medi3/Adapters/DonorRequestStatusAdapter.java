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

import com.example.medi3.Models.DonorRequestStatusModel;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;

import java.util.ArrayList;

public class DonorRequestStatusAdapter extends RecyclerView.Adapter<DonorRequestStatusAdapter.ViewHolder>{

    ArrayList<DonorRequestStatusModel> list;
    Context context;



    public DonorRequestStatusAdapter(ArrayList<DonorRequestStatusModel> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_request_status, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonorRequestStatusModel model = list.get(position);
        holder.DonorReqpatient.setText(model.getNameDonorStatus());
        holder.DonorReqblood.setText(model.getBloodGroupDonorStatus());
        holder.DonorReqlocation.setText(model.getLocationDonorStatus());
        holder.DonorReqMobile.setText(model.getMobileDonorStatus());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView DonorReqpatient, DonorReqblood, DonorReqlocation, DonorReqMobile;
        Button status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            DonorReqpatient = itemView.findViewById(R.id.DonorName);
            DonorReqblood = itemView.findViewById(R.id.DonorbloodName);
            DonorReqlocation = itemView.findViewById(R.id.DonorlocationName);
            DonorReqMobile = itemView.findViewById(R.id.DonorMobileNo);

        }
    }
}
