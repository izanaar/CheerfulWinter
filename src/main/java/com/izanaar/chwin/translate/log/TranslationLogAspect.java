package com.izanaar.chwin.translate.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TranslationLogAspect {

    private static Logger logger = LoggerFactory.getLogger(TranslationLogAspect.class);

    @Pointcut("execution(* com.izanaar.chwin.translate.providers.ApiProvider.translate(..))")
    public void translateInterface() {
    }

    @Pointcut("translateInterface() && !within(com.izanaar.chwin.translate.providers.local.*)")
    public void translateRemote() {
    }

    @Pointcut("translateInterface() && !translateRemote()")
    public void translateLocal() {
    }

    @Before("translateLocal()")
    private void translateLocalBeforeLog() {
        logger.debug("Translation through local 'api' has been requested.");
    }

    @After("translateLocal()")
    private void translateLocalAfterLog() {
        logger.debug("Translation through local 'api' has been completed.");
    }


    

}
