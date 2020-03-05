package com.example.icp;

import com.example.icp.model.hydra.consent.HydraAcceptConsentBody;
import com.example.icp.model.hydra.consent.HydraAcceptConsentResponse;
import com.example.icp.model.hydra.consent.HydraGetConsentResponse;
import com.example.icp.model.hydra.login.HydraAcceptLoginBody;
import com.example.icp.model.hydra.login.HydraAcceptLoginResponse;
import com.example.icp.model.hydra.login.HydraGetLoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface HydraInterface {
    @GET("/oauth2/auth/requests/login")
    Call<HydraGetLoginResponse> getLogin(@Query("login_challenge") String loginChallenge);

    @PUT("/oauth2/auth/requests/login/accept")
    Call<HydraAcceptLoginResponse> acceptLogin(@Query("login_challenge") String loginChallenge, @Body HydraAcceptLoginBody body);

    @GET("/oauth2/auth/requests/consent")
    Call<HydraGetConsentResponse> getConsent(@Query("consent_challenge") String consentChallenge);

    @PUT("/oauth2/auth/requests/consent/accept")
    Call<HydraAcceptConsentResponse> acceptConsent(@Query("consent_challenge") String consentChallenge, @Body HydraAcceptConsentBody body);
}
