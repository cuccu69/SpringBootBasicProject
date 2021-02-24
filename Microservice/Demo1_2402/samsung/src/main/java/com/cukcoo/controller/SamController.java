package com.cukcoo.controller;

import com.cukcoo.model.Device;
import com.cukcoo.model.Devices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/samsung")
public class SamController {

    @GetMapping("/devices")
    public Devices getDevice() {
        List<Device> listDevices = new ArrayList<>();
        Device s21 = new Device("s21", "phone", "samsung");
        Device s21Ultra = new Device("s21Ultra", "phone", "samsung");
        listDevices.add(s21);
        listDevices.add(s21Ultra);

        Devices samsungDevice = new Devices(listDevices);

        return samsungDevice;
    }
}
