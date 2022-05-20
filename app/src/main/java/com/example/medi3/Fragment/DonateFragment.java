package com.example.medi3.Fragment;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medi3.APIs.GoogleMapAPI;
import com.example.medi3.Adapters.FragmentsAdapter;
import com.example.medi3.Adapters.GoogleMapAPIAdapter;
import com.example.medi3.Adapters.RegisterAdapter;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.MainActivity2;
import com.example.medi3.Models.GoogleApiPojo;
import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentDonateBinding;

import java.util.ArrayList;

import io.reactivex.android.plugins.RxAndroidPlugins;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class DonateFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CheckBox checkBoxVisibility;
    GoogleMapAPI googleMapAPI;

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

        ArrayList<RequestList> list = new ArrayList<>();
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Kumar Aditya","B+", "Patna", "Bihar"));
        list.add(new RequestList("Adarsh Kumar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Nikhil Kumar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));






        // Inflate the layout for this fragment
        binding = FragmentDonateBinding.inflate(inflater, container, false);

        RequestListAdapters adapters = new RequestListAdapters(list, getContext());
        binding.donateRecyclerView.setAdapter(adapters);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.donateRecyclerView.setLayoutManager(layoutManager);

        return binding.getRoot();
    }

    public void onStart(){
        super.onStart();

        autoCompleteTextView = (AutoCompleteTextView) context.findViewById(R.id.etbloodNameR);
        adapterItems = new ArrayAdapter<String>(context,R.layout.list_blood_name, items);
        autoCompleteTextView.setAdapter(adapterItems);


        autoCompleteTextViewState = (AutoCompleteTextView) context.findViewById(R.id.etStateR);
        adapterItemsState = new ArrayAdapter<String>(context,R.layout.list_blood_name, states);
        autoCompleteTextViewState.setAdapter(adapterItemsState);




        CheckBox checkBox = (CheckBox) context.findViewById(R.id.checkbox);
        Button btn = (Button) context.findViewById(R.id.btnRegister);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FragmentTransaction trans = getFragmentManager().beginTransaction();
                            trans.replace(R.id.Swipe, new EditRegisterUserFragment());
                            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                            trans.commit();

                        }
                    });
                }else{
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(context, "Please accept terms and conditions", Toast.LENGTH_SHORT).show();

                        }
                    });
                    return;
                }
            }
        });

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



}