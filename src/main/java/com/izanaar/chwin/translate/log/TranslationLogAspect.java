package com.izanaar.chwin.translate.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TranslationLogAspect {

    private static Logger logger = LoggerFactory.getLogger(TranslationLogAspect.class);

    @Before("execution(* com.izanaar.chwin.translate.providers.ApiProvider.translate(..))")
    public void beforeTranslation(){
        logger.info("Translation has been requested.");
    }

}
