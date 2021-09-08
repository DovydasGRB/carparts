package com.example.individualtrackdg;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ITController {
    @RequestMapping
    public String hello(){
        return "If you see this - it works!";
    }
}
