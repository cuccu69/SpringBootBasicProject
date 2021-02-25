package com.cukcoo.controller;

import com.cukcoo.model.Devices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String homePage(){
        return "Home";
    }

    @GetMapping("/{brand}")
    public String devices(Model model, @PathVariable String brand) {
        RestTemplate restTemplate = new RestTemplate();
        Devices result;
        if (brand.equals("samsung")){
            result = restTemplate.getForObject("http://localhost:8082/samsung/devices", Devices.class);
            model.addAttribute("result", result);
            return "Devices";
        } else if (brand.equals("apple")){
            result = restTemplate.getForObject("http://localhost:8083/apple/devices", Devices.class);
            model.addAttribute("result", result);
            return "Devices";
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping("/error")
    public String error(){
        return "Error";
    }
}
