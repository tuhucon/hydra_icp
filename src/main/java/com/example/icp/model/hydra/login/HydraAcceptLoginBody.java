package com.example.icp.model.hydra.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraAcceptLoginBody {
    private Boolean remember = true;

    @JsonProperty("remember_for")
    private int rememberFor = 0;

    @JsonProperty("subject")
    private String userId;
}
