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
@Profile("local-api")
public class LocalApiProvider implements ApiProvider {

    private static final ImmutableBiMap<String, String> map = new ImmutableBiMap.Builder<String, String>()
            .put("ru", "en")
            .put("en", "ru")
            .build();

    @Override
    public ImmutableBiMap<String, String> getAvailableLanguages() {
        return map;
    }

    @Override
    public Translation translate(TranslateRequest request) throws TranslateException {
        return new Translation(request.getText() + " from " + request.getSrcLang() + " to " + request.getDstLang());
    }
}
