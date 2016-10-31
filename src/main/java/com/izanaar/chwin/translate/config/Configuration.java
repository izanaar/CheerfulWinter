package com.izanaar.chwin.translate.config;

import com.izanaar.chwin.translate.service.TranslateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static org.mockito.Mockito.mock;

@org.springframework.context.annotation.Configuration
@ComponentScan
public class Configuration {

    @Bean
    public TranslateService translateService(){
        return mock(TranslateService.class);
    }

}
