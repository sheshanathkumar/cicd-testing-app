package com.sk.cicdtest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cicd-test-0.1")
public class CicdController {

    private static final Logger logger = LogManager.getLogger(CicdController.class);

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/test")
    public ResponseEntity<ModelApi> testController () {
        logger.info("fetching test api");
        return new ResponseEntity<>(new ModelApi(200, "Controller is working", "SUCCESS"), HttpStatus.OK);
    }

    @GetMapping("/env")
    public ResponseEntity<ModelApi> getEnvironment() {
        logger.info("fetching env api");
        return new ResponseEntity<>(new ModelApi(200, activeProfile, "SUCCESS"), HttpStatus.OK);
    }


}
