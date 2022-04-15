package com.sticker.operaSales.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sticker.operaSales.objects.Theatre;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class OperaDto {

    @JsonProperty
    private Theatre theatre;

    @JsonProperty
    private String name;

    @JsonProperty
    private String definition;

    @JsonProperty
    private int ageCategory;

    @JsonProperty
    private boolean[] places;
}
