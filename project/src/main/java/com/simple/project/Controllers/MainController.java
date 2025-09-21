package com.simple.project.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @GetMapping("/home")
    public ResponseEntity<String> homeEndpoint(){
        return ResponseEntity.ok("test");
    }
}
