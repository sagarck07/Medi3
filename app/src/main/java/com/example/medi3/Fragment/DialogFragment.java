package com.example.medi3.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.medi3.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class DialogFragment extends androidx.fragment.app.DialogFragment {


    FragmentListner listner;

    TextInputEditText name, blood, state, city, age;
    Button save;

    public interface FragmentListner{
        void onInputASent(CharSequence input);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_register_save, container, false);

        save = view.findViewById(R.id.SAVEbtn);
        name = view.findViewById(R.id.SAetNameR);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getDialog().dismiss();

            }

        });

        return view;
    }


}
