package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BMI {
    private String name;
    private Integer age;
    private Float height;
    private Float weight;
    private Float bmiIndex;
}
