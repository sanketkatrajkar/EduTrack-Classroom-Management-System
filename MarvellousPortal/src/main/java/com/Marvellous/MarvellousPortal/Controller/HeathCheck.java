package com.Marvellous.MarvellousPortal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeathCheck {

    @GetMapping("/health")
    public String healthCheck() {
        return "EveryThink is OK !";
    }
}
