package com.izanaar.chwin.translate.log;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TranslationLogAspect {

    private static Logger logger = LoggerFactory.getLogger(TranslationLogAspect.class);

    @Before("execution(* com.izanaar.chwin.translate.providers.ApiProvider.translate(..)) && within(com.izanaar.chwin.translate.providers.local.*)")
    public void beforeLocalTranslation(){
        logger.info("Local translation has been requested.");
    }

    @AfterThrowing("execution(* com.izanaar.chwin.translate.providers.ApiProvider.translate(..)) && !within(com.izanaar.chwin.translate.providers.local.*))")
    public void afterRemoteApiTranslationThrowing(){
        logger.error("Execution 'translate()' method has failed.");
    }

}
