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
    private int age;
    private float height;
    private float weight;
    private float bmiIndex;
}
