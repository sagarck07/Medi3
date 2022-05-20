package com.example.medi3.APIs;

import com.example.medi3.Models.GoogleApiPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleMapAPI {
    @GET("place/queryautocomplete/json")
    Call<GoogleApiPojo>getPlace(@Query("input")String text,
                                @Query("key") String key);
}
