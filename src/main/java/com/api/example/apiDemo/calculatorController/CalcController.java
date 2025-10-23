package com.api.example.apiDemo.calculatorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    private double b;
    private double a;

    @GetMapping("/add")
    public String add(@RequestParam double a, @RequestParam double b) {
        this.b = b;
        return "Result: " + (a + b);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam double a, @RequestParam double b) {
        return "Result: " + (a - b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double a, @RequestParam double b) {
        return "Result: " + (a * b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return "Error: Division by zero is not allowed.";
        }
        return "Result: " + (a / b);
    }

    @GetMapping("/test")
    public String test() {
        return "CalculatorController is running!";
    }
}
