package edu.pam.tugas_rancang.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.1.4:5000";

    public static Retrofit getRetrofitclient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static EndPoints getEndPoints(){
        return RetrofitClient.getRetrofitclient().create(EndPoints.class);
    }
}
