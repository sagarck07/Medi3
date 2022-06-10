package com.example.medi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.medi3.Fragment.DonateFragment;
import com.google.android.material.textfield.TextInputEditText;

public class MobileActivity extends AppCompatActivity {

    Button btn;
    ProgressBar pr;
    TextInputEditText mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);

        btn = findViewById(R.id.GetStart);
        pr = findViewById(R.id.Progressbar);
        mb = findViewById(R.id.EnterMobile);

        final DonateFragment donateFragment = new DonateFragment();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileActivity.this, MainActivity.class);
                pr.setVisibility(View.VISIBLE);

                Bundle st = new Bundle();
                st.putString("message", mb.getText().toString());
                donateFragment.setArguments(st);
                startActivity(intent);


            }

        });
    }

}