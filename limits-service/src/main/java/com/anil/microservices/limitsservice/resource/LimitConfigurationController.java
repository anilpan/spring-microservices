package com.anil.microservices.limitsservice.resource;

import com.anil.microservices.limitsservice.config.Configuration;
import com.anil.microservices.limitsservice.model.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {
    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public LimitConfiguration retrievLimitsFromConfiguration(){
        return new LimitConfiguration(config.getMinimum(),config.getMaximum());
    }
}
