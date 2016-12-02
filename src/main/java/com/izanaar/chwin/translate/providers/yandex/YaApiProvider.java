package com.izanaar.chwin.translate.providers.yandex;


import com.google.common.collect.ImmutableBiMap;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import com.izanaar.chwin.translate.exception.TranslateException;
import com.izanaar.chwin.translate.providers.ApiProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class YaApiProvider implements ApiProvider {

    @Value("${ya.dict.key}")
    private String apiKey;

    private RestTemplate template;
    private ImmutableBiMap<String, String> langs;

    public YaApiProvider(RestTemplate template) {
        this.template = template;
    }

    @Override
    public ImmutableBiMap<String, String> getAvailableLanguages() {
        return langs != null ? langs : loadLangs();
    }

    private ImmutableBiMap<String, String> loadLangs(){
        Map<String, String> params = Collections.singletonMap("key", "dict.1.1.20160406T161823Z.8d8d9df526a6d285.38f5076e5cbdffbc2fde0dd7a7fceccd1250778a");
        String url = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs";
        List<String> langs = new ArrayList<>();
        try {
            langs = template.getForObject(url, langs.getClass());
            System.out.println(langs);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Translation translate(TranslateRequest translateRequest) throws TranslateException {
        throw new TranslateException("Yandex api access is not implemented yet.");
    }
}
