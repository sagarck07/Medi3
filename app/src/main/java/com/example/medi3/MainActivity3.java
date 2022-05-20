package com.example.medi3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.medi3.Adapters.DonorRequestStatusAdapter;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.Models.DonorRequestStatusModel;
import com.example.medi3.Models.RequestList;
import com.example.medi3.databinding.ActivityMain3Binding;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ArrayList<DonorRequestStatusModel> list = new ArrayList<>();
        list.add(new DonorRequestStatusModel("Aditya Rungta","B+", "784876387", "Madhya Pradesh"));
        list.add(new DonorRequestStatusModel("Shubham Sagar","B+", "784876387", "Bihar"));
        list.add(new DonorRequestStatusModel("Kumar Aditya","B+", "784876387", "Bihar"));
        list.add(new DonorRequestStatusModel("Adarsh Kumar","B+", "784876387", "Bihar"));
        list.add(new DonorRequestStatusModel("Aditya Rungta","B+", "784876387", "Madhya Pradesh"));
        list.add(new DonorRequestStatusModel("Nikhil Kumar","B+", "784876387", "Bihar"));
        list.add(new DonorRequestStatusModel("Aditya Rungta","B+", "784876387", "Madhya Pradesh"));
        list.add(new DonorRequestStatusModel("Shubham Sagar","B+", "784876387", "Bihar"));
        list.add(new DonorRequestStatusModel("Aditya Rungta","B+", "784876387", "Madhya Pradesh"));



        RecyclerView recyclerView = findViewById(R.id.DonorsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DonorRequestStatusAdapter(list));




    }
}