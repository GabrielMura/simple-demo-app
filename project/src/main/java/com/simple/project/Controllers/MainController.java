package com.simple.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simple.project.DAO.MainDAO;
import com.simple.project.Services.MainService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"}, methods = {RequestMethod.GET})
public class MainController {
    @Autowired
    private MainService mainService;
    
    //get mapping that will be used by the front end to request information
    @GetMapping("/home")
    public ResponseEntity<MainDAO> homeEndpoint(){
        return ResponseEntity.ok(mainService.getSimpleData());
    }
}
