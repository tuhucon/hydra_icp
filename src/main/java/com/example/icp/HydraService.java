package com.example.icp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Map;

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

}
