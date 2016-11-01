package com.izanaar.chwin.translate.service;

import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalTranslateService implements TranslateService {

    private static final Logger logger = LoggerFactory.getLogger(LocalTranslateService.class);

    public Translation translate(TranslateRequest translateRequest) {
        return null;
    }

    @Override
    public String toString() {
        logger.info("Local TranslationService.toString() invoked.");
        return "Local TranslationService implementation";
    }
}
