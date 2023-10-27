package com.weatherapi.controller;

import com.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    @Autowired
    private final WeatherService weatherService;

    @GetMapping("/get-forecast-hourly-by-location/{locationName}")
   public ResponseEntity<?> getForecastHourlyByLocation(@PathVariable String locationName){
       return ResponseEntity.ok( weatherService.getForeCastHourlyByLocation());
   }

    @GetMapping("/get-forecast-summary-by-location/{locationName}")
    public ResponseEntity<?> getForecastSummaryByLocation(@PathVariable String locationName){
        return ResponseEntity.ok( weatherService.getForeCastSummaryByLocation());
    }













}
