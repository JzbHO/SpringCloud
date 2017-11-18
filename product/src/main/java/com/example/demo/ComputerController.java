package com.example.demo;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16 0016.
 */

@RestController
public class ComputerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComputerController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/test")
    public String index(){
        System.out.println("coming....");
//        ServiceInstance instance = serviceInstance();
//        LOGGER.info("provider service, host = " + instance.getHost()
//                + ", service_id = " + instance.getServiceId());
        return "Hello,Provider!";
    }



    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances("compute-service");
        if (list != null && list.size() > 0) {
            return (ServiceInstance) list.get(0);
        }
        return null;
    }
}
