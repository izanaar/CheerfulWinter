package com.izanaar.chwin.translate;

import com.izanaar.chwin.translate.config.TranslateConfig;
import com.izanaar.chwin.translate.service.TranslateService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TranslateContext {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TranslateConfig.class);
        TranslateService translateService = context.getBean(TranslateService.class);
        System.out.println(translateService);
    }
}
