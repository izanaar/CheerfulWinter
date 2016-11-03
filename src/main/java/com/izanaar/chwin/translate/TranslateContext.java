package com.izanaar.chwin.translate;

import com.izanaar.chwin.translate.config.TranslateConfig;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import com.izanaar.chwin.translate.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TranslateContext {

    private static final Logger logger = LoggerFactory.getLogger(TranslateContext.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TranslateConfig.class);
        TranslateService translateService = context.getBean(TranslateService.class);
        TranslateRequest request = new TranslateRequest("en", "ru", "savation");
        Translation translation = translateService.translate(request);

        logger.debug("Translate request: " + request);
        logger.debug("Translation: " + translation);
    }
}
