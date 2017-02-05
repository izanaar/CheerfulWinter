package com.rpnkv.chwin.translate.config;

import com.rpnkv.chwin.translate.log.TranslationLogAspect;
import com.rpnkv.chwin.translate.providers.ApiProvider;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackageClasses = {ApiProvider.class, TranslationLogAspect.class})
@PropertySource("file:/opt/prop/chwin.properties")
@EnableAspectJAutoProxy
public class RootConfig {

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
