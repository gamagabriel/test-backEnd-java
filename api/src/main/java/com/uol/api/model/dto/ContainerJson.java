package com.uol.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ContainerJson {

    @JsonProperty("vingadores")
    private List<Map<String, String>> vingadores = new ArrayList<>();
}
