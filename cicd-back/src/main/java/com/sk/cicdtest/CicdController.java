package com.sk.cicdtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CicdController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/test")
    public ResponseEntity<ModelApi> testController () {
        return new ResponseEntity<>(new ModelApi(200, "Controller is working", "SUCCESS"), HttpStatus.OK);
    }

    @GetMapping("/env")
    public ResponseEntity<ModelApi> getEnvironment() {
        return new ResponseEntity<>(new ModelApi(200, activeProfile, "SUCCESS"), HttpStatus.OK);
    }


}
