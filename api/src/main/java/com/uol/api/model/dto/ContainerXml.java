package com.uol.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ContainerXml {
    @JsonProperty("codinomes")
    private List<String> codNames;
}
