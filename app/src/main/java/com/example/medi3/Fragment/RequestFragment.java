package com.example.medi3.Fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.medi3.Adapters.LatestReqAdapter;
import com.example.medi3.Models.LatestReqModel;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentRequestBinding;

import java.util.ArrayList;

public class RequestFragment extends Fragment {

    FragmentRequestBinding binding;
    Activity context;

    String[] items = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};



    AutoCompleteTextView autoCompleteTextView, autoCompleteTextViewState;
    ArrayAdapter<String> adapterItems, adapterItemsState;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_request, container, false);

        ArrayList<LatestReqModel> list = new ArrayList<>();
        list.add(new LatestReqModel("Aman Raj Sharma", "O","8383725486","Jharkhand"));
        list.add(new LatestReqModel("Kumar Aditya", "A+","9038362648","Bihar"));
        list.add(new LatestReqModel("Ayush Dubey", "B+","7635383525","Jharkhand"));
        list.add(new LatestReqModel("Aman Raj Sharma", "O","8383725486","Jharkhand"));
        list.add(new LatestReqModel("Kumar Aditya", "A+","9038362648","Bihar"));
        list.add(new LatestReqModel("Ayush Dubey", "B+","7635383525","Jharkhand"));
        list.add(new LatestReqModel("Aman Raj Sharma", "O","8383725486","Jharkhand"));
        list.add(new LatestReqModel("Kumar Aditya", "A+","9038362648","Bihar"));
        list.add(new LatestReqModel("Ayush Dubey", "B+","7635383525","Jharkhand"));

        binding = FragmentRequestBinding.inflate(inflater, container, false);

        LatestReqAdapter adapter = new LatestReqAdapter(list, getContext());
        binding.requestRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.requestRecyclerView.setLayoutManager(layoutManager);

        return binding.getRoot();
    }

    public void onStart() {
        super.onStart();


        autoCompleteTextViewState = (AutoCompleteTextView) context.findViewById(R.id.etStateReq);
        adapterItemsState = new ArrayAdapter<String>(context,R.layout.list_blood_name, states);
        autoCompleteTextViewState.setAdapter(adapterItemsState);


        autoCompleteTextView = (AutoCompleteTextView) context.findViewById(R.id.etbloodNameReq);
        adapterItems = new ArrayAdapter<String>(context,R.layout.list_blood_name, items);
        autoCompleteTextView.setAdapter(adapterItems);

        Button ReqBtn = context.findViewById(R.id.btnRequest);
        ReqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}