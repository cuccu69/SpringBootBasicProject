package com.example.demo.Model;

public class BMIMapper {
    public static BMI convertRequestToBmi(BMIRequest request){
        BMI bmi = new BMI();

        bmi.setWeight(request.getWeight());
        bmi.setName(request.getName());
        bmi.setHeight(request.getHeight());
        bmi.setAge(request.getAge());

        return bmi;
    }
}
