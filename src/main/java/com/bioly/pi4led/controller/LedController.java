package com.bioly.pi4led.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lukasz on 13.10.15.
 */
@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;

    static {
        GpioController gpio = GpioFactory.getInstance();
        pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
    }

    @RequestMapping("/")
    public String greeting() {
        return "Hello World";
    }

    @RequestMapping("/light")
    public String light(){
        pin.toggle();
        return "OK";
    }
}
