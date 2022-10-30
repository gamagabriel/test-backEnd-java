package com.uol.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.uol.api.model.dto.ContainerLeague;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestHttpLeague {

    private final RestTemplate restTemplate = new RestTemplate();
    private final XmlMapper xmlMapper = new XmlMapper();
    @Value("${url.xml}")
    private String baseUrlXml;

    public ContainerLeague getLiga()  {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> requestHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(this.baseUrlXml, HttpMethod.GET, requestHttpEntity, String.class);
            try {
                return xmlMapper.readValue(responseEntity.getBody(), ContainerLeague.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
    }


}
