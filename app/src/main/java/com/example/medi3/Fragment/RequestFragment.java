package com.example.medi3.Fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.medi3.APIs.DonateFragmentAPI;
import com.example.medi3.APIs.DonateFragmentController;
import com.example.medi3.APIs.RequestFragmentAPI;
import com.example.medi3.APIs.RequestFragmentController;
import com.example.medi3.Adapters.LatestReqAdapter;
import com.example.medi3.Adapters.RequestListAdapters;
import com.example.medi3.Models.LatestReqModel;
import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestPatient;
import com.example.medi3.R;
import com.example.medi3.databinding.FragmentRequestBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestFragment extends Fragment {

    Activity context;

    String mobileno;
    TextInputEditText number_of_units, name, city, additional_info;
    AutoCompleteTextView bloodgroup, state;
    RadioGroup radioGroup;
    RadioButton yes, no;
    String transportprovide;


    String[] items = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String[] states = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};



    AutoCompleteTextView autoCompleteTextView, autoCompleteTextViewState;
    ArrayAdapter<String> adapterItems, adapterItemsState;

    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_request, container, false);

        yes = rootView.findViewById(R.id.r1);
        no = rootView.findViewById(R.id.r2);

        recyclerView = rootView.findViewById(R.id.requestRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



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


        LatestReqAdapter adapters = new LatestReqAdapter(list,context);
        recyclerView.setAdapter(adapters);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);


        radioGroup = (RadioGroup) rootView.findViewById(R.id.rG);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);


                if (yes.isChecked()){
                    transportprovide = "Yes";
                }else {
                    transportprovide="no";
                }

            }
        });



        name = rootView.findViewById(R.id.etNameReq);
        number_of_units = rootView.findViewById(R.id.etUnitReqReq);
        bloodgroup = rootView.findViewById(R.id.etbloodNameReq);
        state = rootView.findViewById(R.id.etStateReq);
        additional_info = rootView.findViewById(R.id.etAdditionalReq);
        city = rootView.findViewById(R.id.etCityReq);

        Button ReqBtn = rootView.findViewById(R.id.btnRequest);
        ReqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                mobileno = "11111111111";

                RequestFragmentAPI requestFragmentAPI = RequestFragmentController.getRetrofit().create(RequestFragmentAPI.class);
                final RequestPatient requestPatient = new RequestPatient(
                        additional_info.getText().toString(),
                        bloodgroup.getText().toString(),
                        city.getText().toString(),
                        mobileno,
                        name.getText().toString(),
                        number_of_units.getText().toString(),
                        state.getText().toString(),
                        transportprovide
                );

                Call<RequestPatient> call = requestFragmentAPI.getPatient(requestPatient);

                call.enqueue(new Callback<RequestPatient>() {
                    @Override
                    public void onResponse(Call<RequestPatient> call, Response<RequestPatient> response) {


                    }

                    @Override
                    public void onFailure(Call<RequestPatient> call, Throwable t) {
                        Toast.makeText(context,"Something Went Wrong",Toast.LENGTH_SHORT).show();

                    }
                });













            }
        });






        return rootView;
    }

    public void processdata() {

    }

    public void onStart() {
        super.onStart();


        autoCompleteTextViewState = (AutoCompleteTextView) context.findViewById(R.id.etStateReq);
        adapterItemsState = new ArrayAdapter<String>(context, R.layout.list_blood_name, states);
        autoCompleteTextViewState.setAdapter(adapterItemsState);


        autoCompleteTextView = (AutoCompleteTextView) context.findViewById(R.id.etbloodNameReq);
        adapterItems = new ArrayAdapter<String>(context, R.layout.list_blood_name, items);
        autoCompleteTextView.setAdapter(adapterItems);

    }

}