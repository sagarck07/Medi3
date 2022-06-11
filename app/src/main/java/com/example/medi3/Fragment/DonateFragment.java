package com.example.medi3.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.medi3.APIs.ApiInterface;
import com.example.medi3.APIs.DonateFragmentController;
import com.example.medi3.APIs.GetPatientListRV;
import com.example.medi3.APIs.GoogleMapAPI;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentDonateBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DonateFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CheckBox checkBoxVisibility;
    GoogleMapAPI googleMapAPI;

    AutoCompleteTextView state;
    TextInputEditText name;
    TextInputEditText city;
    TextInputEditText age;
    String mobileno;
    AutoCompleteTextView blood_group;
    String url="http://192.168.50.172:8080/add_donor/";

    int number = 0;

    public static DonateFragment newInstance(){
        DonateFragment f = new DonateFragment();
        return f;
    }

    FragmentDonateBinding binding;
    Button BtnRegister;
    RecyclerView recyclerView;
    Activity context;


    AutoCompleteTextView autoCompleteTextView, autoCompleteTextViewState;
    ArrayAdapter<String> adapterItems, adapterItemsState;

    String[] items = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_donate, container, false);

        Intent intent = context.getIntent();
        mobileno = intent.getStringExtra("message_key");

        recyclerView = rootView.findViewById(R.id.donateRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RvAPI();

        name = rootView.findViewById(R.id.etNameR);
        state = rootView.findViewById(R.id.etStateR);
        city = rootView.findViewById(R.id.etCityR);
        age = rootView.findViewById(R.id.etAgeR);
        blood_group = rootView.findViewById(R.id.etbloodNameR);


        CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.checkbox);
        ProgressBar pr = (ProgressBar) rootView.findViewById(R.id.Progressbar2);
        Button btn = (Button) rootView.findViewById(R.id.btnRegister);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            processdata();

                        }
                    });

                }else{
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            }
        });




        return rootView;
    }


    public void RvAPI(){

        ApiInterface apiInterface = GetPatientListRV.getRetrofit().create(ApiInterface.class);
        apiInterface.getPatientRV().enqueue(new Callback<ArrayList<RequestList>>() {
            @Override
            public void onResponse(Call<ArrayList<RequestList>> call, Response<ArrayList<RequestList>> response) {

                ArrayList<RequestList> list = response.body();
                RequestListAdapters adapters = new RequestListAdapters(list);

                recyclerView.setAdapter(adapters);


            }

            @Override
            public void onFailure(Call<ArrayList<RequestList>> call, Throwable t) {
                Toast.makeText(context,"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        });

        }



    public void processdata(){


        ApiInterface apiInterface = DonateFragmentController.getRetrofit().create(ApiInterface.class);
        final RegisterDoner registerDoner = new RegisterDoner(
                mobileno,
                age.getText().toString(),
                blood_group.getText().toString(),
                city.getText().toString(),
                name.getText().toString(),
                state.getText().toString()
                );

        Call<RegisterDoner> call = apiInterface.getRegister(registerDoner);

        call.enqueue(new Callback<RegisterDoner>() {
            @Override
            public void onResponse(Call<RegisterDoner> call, Response<RegisterDoner> response) {

                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.Swipe, new EditRegisterUserFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.commit();


            }

            @Override
            public void onFailure(Call<RegisterDoner> call, Throwable t) {
                Toast.makeText(context,"Something Went Wrong",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void onStart(){
        super.onStart();

        autoCompleteTextView = (AutoCompleteTextView) context.findViewById(R.id.etbloodNameR);
        adapterItems = new ArrayAdapter<String>(context,R.layout.list_blood_name, items);
        autoCompleteTextView.setAdapter(adapterItems);


        autoCompleteTextViewState = (AutoCompleteTextView) context.findViewById(R.id.etStateR);
        adapterItemsState = new ArrayAdapter<String>(context,R.layout.list_blood_name, states);
        autoCompleteTextViewState.setAdapter(adapterItemsState);

    }




    @Override
    public void onRefresh() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) context.findViewById(R.id.SwipeRef);

        Toast.makeText(mSwipeRefreshLayout.getContext(), "Refresh", Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 10);

    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}