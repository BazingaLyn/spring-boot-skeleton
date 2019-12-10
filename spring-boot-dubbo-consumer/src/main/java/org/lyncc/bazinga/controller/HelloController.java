package org.lyncc.bazinga.controller;

import org.lyncc.bazinga.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private BaseService baseService;


    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        return baseService.consumerSay(name);
    }
}
