package com.izanaar.chwin.translate.config;

import com.izanaar.chwin.translate.log.TranslationLogAspect;
import com.izanaar.chwin.translate.providers.ApiProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {ApiProvider.class, TranslationLogAspect.class})
@EnableAspectJAutoProxy
public class TranslateConfig {

}
