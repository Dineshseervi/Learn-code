package com.example.springapphz.controller;


import com.example.springapphz.service.HazelcastConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class MyAppController {

    @Autowired
    private HazelcastConfiguration hazelcastConfiguration;


    @GetMapping(value = "/health")
    public String getHealth()
    {
        return "OK";
    }

    @GetMapping(value = "/size")
    public Integer getCacheSize()
    {
        return hazelcastConfiguration.addEntry();
    }
}
