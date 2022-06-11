package com.example.medi3.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medi3.APIs.ApiInterface;
import com.example.medi3.APIs.GetDonorName;
import com.example.medi3.APIs.GetPatientListRV;
import com.example.medi3.APIs.GetPatientListRV_state;
import com.example.medi3.Adapters.BtnDonateAdapter;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.DonationHistoryActivity;
import com.example.medi3.MobileActivity;
import com.example.medi3.Models.BtnDonateModel;
import com.example.medi3.Models.EditRegisterUserModel;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentEditRegisterUserBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditRegisterUserFragment extends Fragment {

    MobileActivity a = new MobileActivity();
    String mb = "565656565";



    public static EditRegisterUserFragment newInstance(){
        EditRegisterUserFragment f = new EditRegisterUserFragment();
        return f;
    }

    FragmentEditRegisterUserBinding binding;
    Button popupBtn;
    Dialog mDialog;
    Activity context;
    public TextInputEditText txt;
    RecyclerView recyclerView;
    String mobileno;

    TextView name, blood_group, state, city, age;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_edit_register_user, container, false);

        Intent intent = context.getIntent();
        mobileno = intent.getStringExtra("message_key");

        recyclerView = rootView.findViewById(R.id.btn_donateRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        RvAPI1();


        name = rootView.findViewById(R.id.txtNameR);
        blood_group = rootView.findViewById(R.id.tBlood);
        state = rootView.findViewById(R.id.txtStateR);
        city = rootView.findViewById(R.id.txtCityR);
        age = rootView.findViewById(R.id.tAge);





        Button donateHistory = (Button) rootView.findViewById(R.id.donationHistoryBtn);
        donateHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DonationHistoryActivity.class);
                startActivity(intent);
            }
        });




        Button popupBtn = (Button) rootView.findViewById(R.id.btnEdit);
        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new DialogFragment();
                dialog.show(getChildFragmentManager(),"DialogFragment");
            }
        });

        ApiInterface apiInterface = GetDonorName.getRetrofit().create(ApiInterface.class);
        apiInterface.getdonor(mb).enqueue(new Callback<EditRegisterUserModel>() {
            @Override
            public void onResponse(Call<EditRegisterUserModel> call, Response<EditRegisterUserModel> response) {

                EditRegisterUserModel adlist = response.body();

                String nameA = adlist.getName();
                String ageA = adlist.getAge();
                String blood_groupA = adlist.getBlood_group();
                String stateA = adlist.getState();
                String cityA = adlist.getCity();

                name.setText(nameA);
                age.setText(ageA);
                blood_group.setText(blood_groupA);
                state.setText(stateA);
                city.setText(cityA);


            }

            @Override
            public void onFailure(Call<EditRegisterUserModel> call, Throwable t) {

                Toast.makeText(context,"Something Went Wrong",Toast.LENGTH_SHORT).show();

            }
        });




        return rootView;

    }

    public void RvAPI1(){
        ApiInterface apiInterface = GetPatientListRV_state.getRetrofit().create(ApiInterface.class);
        apiInterface.getPatientRV_state().enqueue(new Callback<ArrayList<BtnDonateModel>>() {
            @Override
            public void onResponse(Call<ArrayList<BtnDonateModel>> call, Response<ArrayList<BtnDonateModel>> response) {

                ArrayList<BtnDonateModel> list = response.body();
                BtnDonateAdapter adapters = new BtnDonateAdapter(list);

                recyclerView.setAdapter(adapters);


            }

            @Override
            public void onFailure(Call<ArrayList<BtnDonateModel>> call, Throwable t) {
                Toast.makeText(context,"Something Went Wrong",Toast.LENGTH_SHORT).show();


            }
        });

    }


    public void onStart() {
        super.onStart();

    }

}