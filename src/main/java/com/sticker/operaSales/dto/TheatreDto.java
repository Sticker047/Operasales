package com.sticker.operaSales.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sticker.operaSales.objects.Opera;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class TheatreDto {

    @JsonProperty
    private String name;

    @JsonProperty
    private Map<Integer, Opera> operaStorage = new HashMap<>();

}
