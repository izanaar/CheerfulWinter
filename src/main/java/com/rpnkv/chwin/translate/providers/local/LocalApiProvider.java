package com.rpnkv.chwin.translate.providers.local;

import com.rpnkv.chwin.translate.dto.TranslateRequest;
import com.rpnkv.chwin.translate.dto.Translation;
import com.rpnkv.chwin.translate.exception.TranslateException;
import com.rpnkv.chwin.translate.providers.ApiProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Profile("local-api")
public class LocalApiProvider implements ApiProvider {

    private static Map<String, List<String>> map;

    @Override
    public Map<String, List<String>> getAvailableLanguages() {
        return map != null ? map : initMap();
    }

    private Map<String, List<String>> initMap() {
        map = new HashMap<>();
        map.put("en", Collections.singletonList("ru"));
        map.put("ru", Collections.singletonList("en"));
        return map;
    }

    @Override
    public Translation translate(TranslateRequest request) throws TranslateException {
        return new Translation(request.getText() + " from " + request.getSrcLang() + " to " + request.getDstLang());
    }
}
