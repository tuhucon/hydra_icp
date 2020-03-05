package com.example.icp;

import com.example.icp.model.hydra.consent.HydraAcceptConsentBody;
import com.example.icp.model.hydra.consent.HydraAcceptConsentResponse;
import com.example.icp.model.hydra.consent.HydraGetConsentResponse;
import com.example.icp.model.hydra.login.HydraAcceptLoginBody;
import com.example.icp.model.hydra.login.HydraAcceptLoginResponse;
import com.example.icp.model.hydra.login.HydraGetLoginResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class HydraService {
    private HydraInterface hydra;

    public HydraService() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:4445/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        hydra = retrofit.create(HydraInterface.class);
    }

    public HydraGetLoginResponse getLogin(String loginChallenge) throws IOException {
        return hydra.getLogin(loginChallenge).execute().body();
    }

    public HydraAcceptLoginResponse acceptLogin(String loginChallenge, String userId) throws IOException {
        HydraAcceptLoginBody body = new HydraAcceptLoginBody();
        body.setUserId(userId);
        return hydra.acceptLogin(loginChallenge, body).execute().body();
    }

    public HydraGetConsentResponse getConsent(String consentChallenge) throws IOException {
        return hydra.getConsent(consentChallenge).execute().body();
    }

    public HydraAcceptConsentResponse acceptConsent(String consentChallenge, List<String> grantScopes) throws IOException {
        HydraAcceptConsentBody body = new HydraAcceptConsentBody();
        body.setGrantScope(grantScopes);
        return hydra.acceptConsent(consentChallenge, body).execute().body();
    }

}
