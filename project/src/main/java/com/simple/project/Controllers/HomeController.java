package com.simple.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String forward() {
        // Forward to Angular’s index.html
        return "forward:/index.html";
    }
}