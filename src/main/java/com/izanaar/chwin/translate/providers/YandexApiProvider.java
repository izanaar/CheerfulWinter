package com.izanaar.chwin.translate.providers;


import com.google.common.collect.ImmutableBiMap;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import com.izanaar.chwin.translate.exception.TranslateException;
import org.springframework.stereotype.Service;

public class YandexApiProvider implements ApiProvider {
    @Override
    public ImmutableBiMap<String, String> getAvailableLanguages() {
        return null;
    }

    @Override
    public Translation translate(TranslateRequest translateRequest) throws TranslateException {
        return null;
    }
}
