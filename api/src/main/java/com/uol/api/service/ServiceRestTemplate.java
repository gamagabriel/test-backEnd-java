package com.uol.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.uol.api.client.container.ContainerLigaDaJustica;
import com.uol.api.client.container.ContainerVingadores;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ServiceRestTemplate {

    private static RestTemplate restTemplate = new RestTemplate();
    private static String baseUrlJson = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
    private static String baseUrlXml = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";

    public static void exchangeJsonVingadores(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrlJson, HttpMethod.GET, requestHttpEntity, String.class);
        ContainerVingadores container;
        try {
            container = new ObjectMapper().readValue(responseEntity.getBody(), ContainerVingadores.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exchangeXmlLigaDaJustica() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrlXml, HttpMethod.GET, requestHttpEntity, String.class);
        ContainerLigaDaJustica containerLigaDaJustica;

            try {
                containerLigaDaJustica = new XmlMapper().readValue(responseEntity.getBody(), ContainerLigaDaJustica.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
    }

}
