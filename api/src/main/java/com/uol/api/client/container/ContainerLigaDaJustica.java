package com.uol.api.client.container;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.uol.api.client.LigaDaJustica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerLigaDaJustica {

    @JacksonXmlProperty(localName = "codinomes")
    List<LigaDaJustica> ligaDaJustica;
}
