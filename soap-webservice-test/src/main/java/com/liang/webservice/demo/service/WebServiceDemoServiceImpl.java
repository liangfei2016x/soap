package com.liang.webservice.demo.service;

import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @author:80003823 - fei.liang
 * @Date: 2019/5/30 13:49
 **/
@WebService(serviceName = "WebServiceDemoService",
        targetNamespace = "service.demo.webservice.liang.com",
        endpointInterface = "com.liang.webservice.demo.service.WebServiceDemoService"
)

@Service
public class WebServiceDemoServiceImpl implements WebServiceDemoService{
    @Override
    public String hello(String name) {
        return "hello "+name;
    }
}
