package com.izanaar.chwin.translate.config;

import com.izanaar.chwin.translate.service.LocalTranslateService;
import com.izanaar.chwin.translate.service.TranslateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class TranslateConfig {

    @Bean
    public TranslateService translateService(){
        return new LocalTranslateService();
    }

}
