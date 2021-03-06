package com.madas.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DemoController {

    @ResponseBody
    @GetMapping("home")
    public String home() {
        log.info("home() called");
        return "Hello to Spring Boot";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {
        log.info("welcome() method called");
        model.addAttribute("message", "welcome to Spring Boot");
        return "welcome";
    }
}
