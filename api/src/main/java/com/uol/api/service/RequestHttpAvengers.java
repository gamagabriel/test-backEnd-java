package com.uol.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uol.api.exceptions.FailRequestHttpException;
import com.uol.api.model.dto.ContainerAvengers;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestHttpAvengers {

    @Autowired
    private ObjectMapper mapper;
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${url.json}")
    private String baseUrlJson;


    @SneakyThrows
    public ContainerAvengers getVingadores() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(baseUrlJson, HttpMethod.GET, requestHttpEntity, String.class);
        try {
            return mapper.readValue(responseEntity.getBody(), ContainerAvengers.class);
        } catch (JsonProcessingException e) {
            throw new FailRequestHttpException();
        }
    }

}
