package com.example.medi3.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.medi3.Adapters.FragmentsAdapter;
import com.example.medi3.Adapters.RegisterAdapter;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.MainActivity2;
import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestList;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentDonateBinding;

import java.util.ArrayList;


public class DonateFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CheckBox checkBoxVisibility;


    public static DonateFragment newInstance(){
        DonateFragment f = new DonateFragment();
        return f;
    }




    FragmentDonateBinding binding;
    Button BtnRegister;
    RecyclerView recyclerView;
    Activity context;


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
                            trans.replace(R.id.donate_frameID, new EditRegisterUserFragment());
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

        Toast.makeText(mSwipeRefreshLayout.getContext(), "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);

    }
}