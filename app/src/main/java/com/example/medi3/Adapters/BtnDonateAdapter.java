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

    public BtnDonateAdapter(ArrayList<BtnDonateModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_btn_donate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BtnDonateModel model = list.get(position);
        holder.btn_donate_patient.setText(model.getBtn_Donate_patient());
        holder.btn_donate_blood.setText(model.getBtn_Donate_blood());
        holder.btn_donate_location.setText(model.getBtn_Donate_location());
        holder.btn_donate_additional.setText(model.getBtn_Donate_aditional());

        holder.donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity2.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView btn_donate_patient, btn_donate_blood, btn_donate_location, btn_donate_additional;
        Button donateBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            donateBtn = itemView.findViewById(R.id.donateBtn);
            btn_donate_patient = itemView.findViewById(R.id.btn_donate_patientName);
            btn_donate_blood = itemView.findViewById(R.id.btn_donate_bloodName);
            btn_donate_location = itemView.findViewById(R.id.btn_donate_locationName);
            btn_donate_additional = itemView.findViewById(R.id.btn_donate_additionalName);


        }
    }
}
