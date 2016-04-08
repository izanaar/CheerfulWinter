package com.izanaar.dao;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateProvider {

    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
