package com.uol.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.uol.api.model.dto.ContainerJson;
import com.uol.api.model.dto.ContainerXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpService {

    @Autowired
    private ObjectMapper mapper;

    private final RestTemplate restTemplate = new RestTemplate();
    private final XmlMapper xmlMapper = new XmlMapper();
    @Value("${url.json}")
    private String baseUrlJson;
    @Value("${url.xml}")
    private String baseUrlXml;

    public ContainerJson getVingadores(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrlJson, HttpMethod.GET, requestHttpEntity, String.class);
        try {
            return mapper.readValue(responseEntity.getBody(), ContainerJson.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ContainerXml getLiga() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(this.baseUrlXml, HttpMethod.GET, requestHttpEntity, String.class);
            try {
                return xmlMapper.readValue(responseEntity.getBody(), ContainerXml.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
    }


}
