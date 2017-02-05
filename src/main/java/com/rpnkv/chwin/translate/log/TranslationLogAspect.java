package com.rpnkv.chwin.translate.log;

import com.rpnkv.chwin.translate.dto.TranslateRequest;
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

    @Pointcut("execution(* com.rpnkv.chwin.translate.providers.ApiProvider.translate(com.rpnkv.chwin.translate.dto.TranslateRequest)) && args(request)")
    public void translateInterface(TranslateRequest request) {
    }

    @Pointcut("translateInterface(request) && !within(com.izanaar.chwin.translate.providers.local.*)")
    public void translateRemote(TranslateRequest request) {
    }

    @Pointcut("translateInterface(request) && within(com.izanaar.chwin.translate.providers.local.*)")
    public void translateLocal(TranslateRequest request) {
    }
/*
    @Before("translateLocal(request)")
    private void translateLocalBeforeLog(TranslateRequest request) {
        logger.debug("Translation through local 'api' has been requested.");
    }*/

    @After("translateLocal(request)")
    private void translateLocalAfterLog(TranslateRequest request) {
        logger.debug("Translation through local 'api' has been completed.");
    }

    @Before("translateInterface(request)")
    private void translateInterfaceBeforeLog(TranslateRequest request){
        logger.info("ABCDE");
    }

}
