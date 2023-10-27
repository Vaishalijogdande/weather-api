package com.weatherapi.service;

import com.sun.net.httpserver.Headers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class WeatherService {

    @Value("${forecastHourly.url}")
    private String forecastHourly;
    @Value("${forecastSummary.url}")
    private String forecastSummary;
    @Value("${key}")
    private String key;
    @Value("${host}")
    private String host;

    @Autowired
    private RestTemplate restTemplate;


    public Object getForeCastHourlyByLocation(){
        try {

            HttpHeaders headers = new HttpHeaders(  );
            headers.set("X-RapidAPI-Key", key);
            headers.set("X-RapidAPI-Host", host);

            ResponseEntity<String> response= restTemplate.exchange(forecastHourly, HttpMethod.GET,new HttpEntity<>(headers), String.class);
            log.info("Response from rapid api {} :", response.getBody());
            return response.getBody();

        }catch (Exception e){
            log.error("Something went wrong", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint", e
            );

        }
    }

    public Object getForeCastSummaryByLocation(){
        try {

            HttpHeaders headers = new HttpHeaders(  );
            headers.set("X-RapidAPI-Key", key);
            headers.set("X-RapidAPI-Host", host);

            ResponseEntity<String> response= restTemplate.exchange(forecastSummary, HttpMethod.GET,new HttpEntity<>(headers), String.class);
            log.info("Response from rapid api {} :", response.getBody());
            return response.getBody();

        }catch (Exception e){
            log.error("Something went wrong", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint", e
            );

        }
    }
}
