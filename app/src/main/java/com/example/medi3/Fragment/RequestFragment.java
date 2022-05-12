package com.example.medi3.Fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medi3.Adapters.LatestReqAdapter;
import com.example.medi3.Models.LatestReqModel;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentRequestBinding;

import java.util.ArrayList;

public class RequestFragment extends Fragment {

    FragmentRequestBinding binding;
    Activity context;

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
}