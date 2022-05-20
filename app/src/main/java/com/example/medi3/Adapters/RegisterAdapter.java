package com.example.medi3.Adapters;

import android.content.Context;
import android.graphics.ColorSpace;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class RegisterAdapter extends  RecyclerView.Adapter<RegisterAdapter.ViewHolder>{

    ArrayList<RegisterDoner> registerList;
    Context registerContext;

    public RegisterAdapter(ArrayList<RegisterDoner> registerList, Context registerContext) {
        this.registerList = registerList;
        this.registerContext = registerContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(registerContext).inflate(R.layout.fragment_donate, parent, false);
        return new RegisterAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegisterDoner model = registerList.get(position);



        model.setName(holder.etName.getText().toString());
        model.setState(holder.etState.getText().toString());
        model.setCity(holder.etCity.getText().toString());
        model.setAge(holder.etAge.getText().toString());


    }

    @Override
    public int getItemCount() {
        return registerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView patientName, BloodGroup, Location, unitRequired, additionalName;
        TextInputEditText etName, etBloodGroup, etState, etCity, etAge;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            etName = itemView.findViewById(R.id.etNameR);
            etState = itemView.findViewById(R.id.etStateR);
            etCity = itemView.findViewById(R.id.etCityR);
            etAge = itemView.findViewById(R.id.etAgeR);


        }
    }
}
