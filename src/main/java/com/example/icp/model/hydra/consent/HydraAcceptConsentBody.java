package com.example.icp.model.hydra.consent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HydraAcceptConsentBody {
    private Boolean remember = true;

    @JsonProperty("remember_for")
    private int rememberFor = 0;

    @JsonProperty("grant_scope")
    List<String> grantScope;
}
