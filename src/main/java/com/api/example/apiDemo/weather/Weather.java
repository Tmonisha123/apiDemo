package com.api.example.apiDemo.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Weather {
    @GetMapping("/london")
    public String london() {
        return "Temperature: 18 " +
                "Condition: cloudy";
    }

    @GetMapping("/paris")
    public String paris() {
        return "Temperature: 27 " +
                "Condition: sunny";
    }

    @GetMapping("/newyork")
    public String newyork() {
        return  "Temperature: 20 " +
                "Condition: rainy";
    }
}
