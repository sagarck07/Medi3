package com.example.medi3.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.medi3.Adapters.BtnDonateAdapter;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.Models.BtnDonateModel;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentDonateBinding;
import com.example.medi3.databinding.FragmentEditRegisterUserBinding;

import java.util.ArrayList;

public class EditRegisterUserFragment extends Fragment {



    public static EditRegisterUserFragment newInstance(){
        EditRegisterUserFragment f = new EditRegisterUserFragment();
        return f;
    }

    FragmentEditRegisterUserBinding binding;
    Button popupBtn;
    Dialog mDialog;
    Activity context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_edit_register_user, container, false);

        ArrayList<BtnDonateModel> list = new ArrayList<>();
        list.add(new BtnDonateModel("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new BtnDonateModel("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Kumar Aditya","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Adarsh Kumar","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new BtnDonateModel("Nikhil Kumar","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new BtnDonateModel("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new BtnDonateModel("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new BtnDonateModel("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new BtnDonateModel("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new BtnDonateModel("Shubham Sagar","B+", "Patna", "Bihar"));



        binding = FragmentEditRegisterUserBinding.inflate(inflater, container, false);



        // Inflate the layout for this fragment


        BtnDonateAdapter adapters = new BtnDonateAdapter(list, getContext());
        binding.btnDonateRecyclerView.setAdapter(adapters);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.btnDonateRecyclerView.setLayoutManager(layoutManager);


        return binding.getRoot();



    }
    public void onStart() {
        super.onStart();

        Button popupBtn = (Button) context.findViewById(R.id.btnEdit);
        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

            }
        });
    }

}