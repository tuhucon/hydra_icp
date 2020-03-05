package com.example.icp.model.hydra.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraGetLoginResponse {
    private Boolean skip;

    @JsonProperty("subject")
    private String userId;
}
