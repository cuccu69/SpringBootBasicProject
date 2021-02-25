package com.example.demo.Controller;

import com.example.demo.Model.BMI;
import com.example.demo.Model.BMIMapper;
import com.example.demo.Model.BMIRequest;
import com.example.demo.Service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        BMIMapper.convertRequestToBmi(request);
        myBMI.setBmiIndex(bmiService.caculateIndex(myBMI));

        model.addAttribute("bmiRequest", request);
        model.addAttribute("bmi", String.valueOf(myBMI.getBmiIndex()));

        return "home";
    }
}
