package com.example.icp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HydraAcceptLoginBody {
    private Boolean remember = true;
    private int remember_for = 0;

    @JsonProperty("subject")
    private String userId;
}
