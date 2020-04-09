package edu.pam.tugas_rancang.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPoints {
//    @POST("register")
//    Call<Object> register(String username, String password, String email, String phone);

    @POST("/login")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);
//
//    @POST("add_tour")
//    Call<Object> addTour(String username, String tour_name, String tour_desc);
//
//    @POST("edit_tour")
//    Call<Object> editTour(int tour_id, String tour_name, String tour_desc);
//
//    @POST("delete_tour")
//    Call<Object> deleteTour(int tour_id);
//
//    @POST("add_trip")
//    Call<Object> addTrip(int tour_id, String trip_name, String trip_desc);
//
//    @POST("edit_trip")
//    Call<Object> editTrip(int trip_id, String trip_name, String trip_desc);
//
//    @POST("delete_trip")
//    Call<Object> deleteTrip(int trip_id);
//
//    @POST("add_budget")
//    Call<Object> addBudget(int trip_id, String budget_name, String budget_desc, double budget_budget, int budget_type_id);
//
//    @POST("edit_budget")
//    Call<Object> editBudget(int budget_id, String budget_name, String budget_desc, double budget_budget, int budget_type_id);
//
//    @POST("delete_budget")
//    Call<Object> deleteBudget(int budget_id);
}
