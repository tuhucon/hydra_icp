package com.example.icp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraClient {
    @JsonProperty("client_name")
    private String clientName;
}
