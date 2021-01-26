package com.example.demo.Service;

import com.example.demo.Model.BMI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BMIServiceImpl implements BMIService{

    @Override
    public float caculateIndex(BMI myBMI) {
        float result = myBMI.getWeight() / (myBMI.getHeight() * myBMI.getHeight());
        return result;
    }
}
