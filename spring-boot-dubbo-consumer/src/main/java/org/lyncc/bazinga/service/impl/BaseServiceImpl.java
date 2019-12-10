package org.lyncc.bazinga.service.impl;

import org.apache.dubbo.config.annotation.Reference;
import org.lyncc.bazinga.service.BaseService;
import org.lyncc.bazinga.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @Override
    public String consumerSay(String name) {
        return helloService.sayHello(name);
    }
}
