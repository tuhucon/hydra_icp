package com.example.icp.model.hydra.consent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraAcceptConsentResponse {
    @JsonProperty("redirect_to")
    private String redirectTo;
}
