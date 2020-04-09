package edu.pam.tugas_rancang.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPoints {
    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("phone") String phone);

    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password);

    @POST("get_tour_all")
    Call<GetTourAllResponse> getTourAll();

    @POST("add_tour")
    @FormUrlEncoded
    Call<TourResponse> addTour(
            @Field("username") String username,
            @Field("tour_name") String tour_name,
            @Field("tour_desc") String tour_desc);

    @POST("edit_tour")
    Call<TourResponse> editTour(
            int tour_id,
            String tour_name,
            String tour_desc);

    @POST("delete_tour")
    Call<TourResponse> deleteTour(int tour_id);

    @POST("add_trip")
    Call<TripResponse> addTrip(
            @Field("tour_id") int tour_id,
            @Field("trip_name") String trip_name,
            @Field("trip_desc") String trip_desc);

    @POST("edit_trip")
    Call<TripResponse> editTrip(
            @Field("trip_id") int trip_id,
            @Field("trip_name") String trip_name,
            @Field("trip_desc") String trip_desc);

    @POST("delete_trip")
    Call<TripResponse> deleteTrip(
            @Field("trip_id") int trip_id);

    @POST("add_budget")
    Call<BudgetResponse> addBudget(
            @Field("trip_id") int trip_id,
            @Field("budget_name") String budget_name,
            @Field("budget_desc") String budget_desc,
            @Field("budget_budget") double budget_budget,
            @Field("budget_type_id") int budget_type_id);

    @POST("edit_budget")
    Call<BudgetResponse> editBudget(
            @Field("budget_id") int budget_id,
            @Field("budget_name") String budget_name,
            @Field("budget_desc") String budget_desc,
            @Field("budget_budget") double budget_budget,
            @Field("budget_type_id") int budget_type_id);

    @POST("delete_budget")
    Call<BudgetResponse> deleteBudget(
            @Field("budget_id") int budget_id);
}
