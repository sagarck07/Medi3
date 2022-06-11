package com.example.medi3.APIs;

import android.content.Context;
import android.content.Intent;

import com.example.medi3.MobileActivity;
import com.example.medi3.Models.BtnDonateModel;
import com.example.medi3.Models.EditRegisterUserModel;
import com.example.medi3.Models.LatestReqModel;
import com.example.medi3.Models.RegisterDoner;
import com.example.medi3.Models.RequestList;
import com.example.medi3.Models.RequestPatient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiInterface{

    @POST("/add_donor")
    Call<RegisterDoner> getRegister(@Body RegisterDoner registerDoner);

    @POST("/add_patient")
    Call<RequestPatient> getPatient(@Body RequestPatient requestPatient);

    @GET("/get_donor/{id}")
    Call<EditRegisterUserModel> getdonor(@Path("id") String id);

    @GET("/patient_list")
    Call<ArrayList<RequestList>> getPatientRV();

    ///sorted_patient_list_state/{id}
    @GET("/patient_list/")
    Call<ArrayList<BtnDonateModel>> getPatientRV_state( );

    @GET("/patient_request/{id}")
    Call<ArrayList<LatestReqModel>> getLatestPatient(@Path("id") String id);

}
