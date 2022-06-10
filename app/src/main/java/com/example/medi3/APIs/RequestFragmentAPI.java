package com.example.medi3.APIs;

import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestPatient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestFragmentAPI {

    @POST("/add_patient")
    Call<RequestPatient> getPatient(@Body RequestPatient requestPatient);


}
