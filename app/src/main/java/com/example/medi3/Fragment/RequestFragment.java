package com.example.medi3.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentDonateBinding;
import com.example.medi3.databinding.FragmentRequestBinding;

import java.util.ArrayList;

public class RequestFragment extends Fragment {


    public RequestFragment() {
        // Required empty public constructor
    }


    FragmentRequestBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayList<RequestList> list = new ArrayList<>();



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request, container, false);
    }
}