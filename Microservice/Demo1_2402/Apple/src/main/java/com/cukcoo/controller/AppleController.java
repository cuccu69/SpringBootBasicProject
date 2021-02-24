package com.cukcoo.controller;

import com.cukcoo.model.Device;
import com.cukcoo.model.Devices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apple")
public class AppleController {

    @GetMapping("/devices")
    public Devices getDevice() {
        List<Device> listDevices = new ArrayList<>();
        Device iPhoneX = new Device("iPhoneX", "phone", "Apple");
        Device iPad = new Device("iPad", "tablet", "Apple");
        listDevices.add(iPhoneX);
        listDevices.add(iPad);

        Devices appleDevice = new Devices(listDevices);

        return appleDevice;
    }
}
