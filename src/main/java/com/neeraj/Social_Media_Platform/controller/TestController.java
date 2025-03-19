package com.neeraj.Social_Media_Platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "You have accessed a protected endpoint!";
    }
}

