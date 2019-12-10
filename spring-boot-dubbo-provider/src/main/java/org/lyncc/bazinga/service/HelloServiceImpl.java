package org.lyncc.bazinga.service;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String username) {
        return "Hello docker & Hello spring boot & Hello " + username;
    }
}
