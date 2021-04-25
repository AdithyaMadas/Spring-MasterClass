package com.madas.controller;

import com.madas.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    //== Fields ==
    DemoService demoService;

    public DemoController(@Autowired DemoService demoService) {
        this.demoService = demoService;
    }

    //== Mappings ==

    // http://localhost:8080/Spring-MVC/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // http://localhost:8080/Spring-MVC/welcome
    // prefix + name + suffix
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("Name", "Madas");
        return "welcome";
    }

    // http://localhost:8080/Spring-MVC/welcome/service
    @GetMapping("welcome/service")
    public String welcomeService(@RequestParam String user, @RequestParam int age123, Model model) {
        model.addAttribute("Message", demoService.getHelloMessage(user));
        model.addAttribute("age", age123);
        return "welcome";
    }

    // == Model Attributes
    @ModelAttribute("h2")
    public String welcomeMessage() {
        return demoService.getWelcomeMessage();
    }
}
