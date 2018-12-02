package com.liuzhengri.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
class ProductController {

    @Autowired
    private Registration registration;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Map getProduct() {
        Map<String, Object> map = new HashMap<>();
        map.put("host", registration.getHost());
        map.put("port", registration.getPort());
        map.put("id", registration.getServiceId());
        return map;
    }
}
