package com.liang.webservice.demo;

import com.liang.webservice.demo.service.WebServiceDemoService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @author:80003823 - fei.liang
 * @Date: 2019/5/30 15:07
 **/
public class WebServiceTest {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    public static void test(){
        try {
            String address="http://localhost:8080/services/webServiceDemoService?wsdl";
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.setAddress(address);
            jaxWsProxyFactoryBean.setServiceClass(WebServiceDemoService.class);
            WebServiceDemoService cs = (WebServiceDemoService) jaxWsProxyFactoryBean.create();
            String userName = "test webService";
            String result = cs.hello(userName);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式2.动态调用方式
     */
    public static void test2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/webServiceDemoService?wsdl");
        Object[] objects = new Object[0];
        try {
            //用法：client.invoke("方法名",参数1,参数2,参数3....);
        //            objects = client.invoke("add", model);
            objects = client.invoke("hello","world soap");
            System.out.println("success.....");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

}
