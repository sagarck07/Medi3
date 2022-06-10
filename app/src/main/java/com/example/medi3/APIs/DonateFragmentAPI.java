package com.example.medi3.APIs;

import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestPatient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DonateFragmentAPI {

    @POST("/add_donor")
    Call<RegisterDoner> getRegister(@Body RegisterDoner registerDoner);




}
