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

import com.example.medi3.MainActivity2;
import com.example.medi3.Models.BtnDonateModel;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;

import java.util.ArrayList;

public class BtnDonateAdapter extends RecyclerView.Adapter<BtnDonateAdapter.ViewHolder> {

    ArrayList<BtnDonateModel> list;
    Context context;

    public BtnDonateAdapter(ArrayList<BtnDonateModel> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_btn_donate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BtnDonateModel model = list.get(position);
        holder.name.setText(model.getName());
        holder.bloodgroup.setText(model.getBloodgroup());
        holder.state.setText(model.getState());
        holder.city.setText(model.getCity());

        holder.donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);

                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, bloodgroup, state, city;
        Button donateBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            donateBtn = itemView.findViewById(R.id.donateBtn);
            name = itemView.findViewById(R.id.btn_donate_patientName);
            bloodgroup = itemView.findViewById(R.id.btn_donate_bloodName);
            city = itemView.findViewById(R.id.btn_donate_locationName);
            state = itemView.findViewById(R.id.btn_donate_additionalName);


        }
    }
}
