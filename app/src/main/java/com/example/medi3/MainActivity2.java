package com.example.medi3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.medi3.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {


    TextView pat, bld, loc, inf;
    ActivityMain2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }
}