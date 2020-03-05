package com.example.icp.model.hydra.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraAcceptLoginResponse {
    @JsonProperty("redirect_to")
    private String redirectTo;
}

