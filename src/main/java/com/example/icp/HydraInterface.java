package com.example.icp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

import java.util.Map;

public interface HydraInterface {
    @GET("/oauth2/auth/requests/login")
    Call<HydraGetLoginResponse> getLogin(@Query("login_challenge") String loginChallenge);

    @PUT("/oauth2/auth/requests/login/accept")
    Call<HydraAcceptLoginResponse> acceptLogin(@Query("login_challenge") String loginChallenge, @Body HydraAcceptLoginBody body);
}
