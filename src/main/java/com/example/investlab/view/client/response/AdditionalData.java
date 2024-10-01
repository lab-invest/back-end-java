package com.example.investlab.view.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdditionalData {

    @JsonProperty("Open")
    private double open;
    @JsonProperty("High")
    private double high;
    @JsonProperty("Close")
    private double close;
    @JsonProperty("Low")
    private double low;
    @JsonProperty("Volume")
    private double volume;
}
