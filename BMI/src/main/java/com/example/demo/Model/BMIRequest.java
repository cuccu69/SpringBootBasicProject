package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BMIRequest {
    private Float height;
    private Float weight;
    private String name;
    private Integer age;
}
