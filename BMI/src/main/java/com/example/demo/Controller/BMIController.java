package com.example.demo.Controller;

import com.example.demo.Model.BMI;
import com.example.demo.Model.BMIRequest;
import com.example.demo.Service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

@Controller
public class BMIController {
    @Autowired
    BMIService bmiService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("bmiRequest", new BMIRequest());
        model.addAttribute("bmi", new BMI().getBmiIndex());
        return "home";
    }

    @PostMapping("/result")
    public String caculateBMI(BMIRequest request, Model model) {
        BMI myBMI = new BMI();
        myBMI.setAge(request.getAge());
        myBMI.setHeight(request.getHeight());
        myBMI.setName(request.getName());
        myBMI.setWeight(request.getWeight());
        myBMI.setBmiIndex(bmiService.caculateIndex(myBMI));


        model.addAttribute("bmiRequest", request);
        model.addAttribute("bmi", String.valueOf(myBMI.getBmiIndex()));

        return "home";
    }
}
