package com.example.medi3.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentDonateBinding;

import java.util.ArrayList;


public class DonateFragment extends Fragment {


    public DonateFragment() {
        // Required empty public constructor
    }


    FragmentDonateBinding binding;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<RequestList> list = new ArrayList<>();
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));
        list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));list.add(new RequestList("Aditya Rungta","B+", "Indore", "Madhya Pradesh"));
        list.add(new RequestList("Shubham Sagar","B+", "Patna", "Bihar"));
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
}