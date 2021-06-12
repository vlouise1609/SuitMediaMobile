package com.example.suitmediamobile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/596dec7f0f000023032b8017")
    Call<Guest> getGuest();
}
