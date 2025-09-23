package com.simple.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.project.DAO.MainDAO;
import com.simple.project.Services.MainService;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;
    
    //get mapping that will be used by the front end to request information
    @GetMapping("/api/data")
    public ResponseEntity<MainDAO> dataEndpoint(){
        return ResponseEntity.ok(mainService.getSimpleData());
    }
}
