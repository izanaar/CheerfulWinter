package com.izanaar.chwin.translate.providers.local;

import com.google.common.collect.ImmutableBiMap;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import com.izanaar.chwin.translate.exception.TranslateException;
import com.izanaar.chwin.translate.providers.ApiProvider;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Conditional(value = NoApiProviderCondition.class)
public class LocalApiProvider implements ApiProvider{

    @Override
    public ImmutableBiMap<String, String> getAvailableLanguages() {
        return null;
    }

    @Override
    public Translation translate(TranslateRequest request) throws TranslateException {
        return null;
    }
}
