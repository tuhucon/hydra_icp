package com.example.icp.model.hydra.consent;

import com.example.icp.HydraClient;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraGetConsentResponse {
    private Boolean skip;

    @JsonProperty("subject")
    private String userId;

    @JsonProperty("request_scope")
    private String requestScope;

    private HydraClient client;
}
