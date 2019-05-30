package com.liang.webservice.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author:80003823 - fei.liang
 * @Date: 2019/5/30 13:48
 **/
@WebService(name = "WebServiceDemoService",
        targetNamespace = "service.demo.webservice.liang.com"
)
public interface WebServiceDemoService {
    @WebMethod
    String hello(@WebParam(name = "name")String name);
}
