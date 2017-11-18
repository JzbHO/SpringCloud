package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
@FeignClient("compute-service")
public interface HelloService {
    @RequestMapping("test")
    String hello();
}
