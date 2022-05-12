package com.example.medi3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medi3.Models.LatestReqModel;
import com.example.medi3.R;

import java.util.ArrayList;

public class LatestReqAdapter extends RecyclerView.Adapter<LatestReqAdapter.ViewHolder> {

    ArrayList<LatestReqModel> list;
    Context LatestContext;

    public LatestReqAdapter(ArrayList<LatestReqModel> list, Context LatestContext){
        this.list = list;
        this.LatestContext = LatestContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(LatestContext).inflate(R.layout.recyclerview_request, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LatestReqModel model1 = list.get(position);
        holder.NameReq.setText(model1.getNameReq());
        holder.BloodGroupReq.setText(model1.getBloodGroupReq());
        holder.MobileReq.setText(model1.getMobileReq());
        holder.LocationReq.setText(model1.getLocationReq());

    }

    @Override
    public int getItemCount() {

        return  list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView NameReq, BloodGroupReq, MobileReq, LocationReq;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NameReq = itemView.findViewById(R.id.patientNameReqkk);
            BloodGroupReq = itemView.findViewById(R.id.bloodNameReqkk);
            MobileReq = itemView.findViewById(R.id.mobileReq);
            LocationReq = itemView.findViewById(R.id.locationNameReq);
        }
    }
}
