package com.example.medi3.APIs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetPatientListRV {

    private static final String url = "http://192.168.50.111:8080/patient_list/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
