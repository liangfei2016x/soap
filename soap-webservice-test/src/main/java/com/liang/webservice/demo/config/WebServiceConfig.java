package com.liang.webservice.demo.config;

import com.liang.webservice.demo.service.WebServiceDemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * @author:80003823 - fei.liang
 * @Date: 2019/5/30 13:56
 **/
@Configuration
public class WebServiceConfig {

    @Autowired
    private WebServiceDemoService webServiceDemoService;

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint=new EndpointImpl(bus,webServiceDemoService);
        endpoint.publish("/webServiceDemoService");
        return endpoint;
    }

}
