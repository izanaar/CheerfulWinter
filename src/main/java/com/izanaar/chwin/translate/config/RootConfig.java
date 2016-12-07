package com.izanaar.chwin.translate.config;

import com.izanaar.chwin.translate.log.TranslationLogAspect;
import com.izanaar.chwin.translate.providers.ApiProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

//@Configuration
@ComponentScan(basePackageClasses = {ApiProvider.class, TranslationLogAspect.class})
@PropertySource("file:/opt/prop/chwin.properties")
@EnableAspectJAutoProxy
public class RootConfig {

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
