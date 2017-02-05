package com.rpnkv.chwin.translate.providers.yandex;


import com.google.common.collect.ImmutableBiMap;
import com.rpnkv.chwin.translate.dto.TranslateRequest;
import com.rpnkv.chwin.translate.dto.Translation;
import com.rpnkv.chwin.translate.exception.TranslateException;
import com.rpnkv.chwin.translate.providers.ApiProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class YaApiProvider implements ApiProvider {

    @Value("${ya.dict.key}")
    private String apiKey;

    private static final String API_URI = "https://dictionary.yandex.net/api/v1/dicservice.json";

    private RestTemplate template;
    private ImmutableBiMap<String, String> langs;

    public YaApiProvider(RestTemplate template) {
        this.template = template;
    }

    /*@Override
    public IMap<String, String> getAvailableLanguages() {
        return langs != null ? langs : loadLangs();
    }

    private ImmutableBiMap<String, String> loadLangs(){
        final String METHOD_URI = "/getLangs";
        List<String> langs = new ArrayList<>();
        try {
            langs = template.getForObject(API_URI.concat(METHOD_URI), langs.getClass());//TODO cleanup!
            final ImmutableBiMap.Builder<String, String> builder = new ImmutableBiMap.Builder<>();
            langs.forEach(lang -> builder.put(lang.substring(0, lang.indexOf('-')), lang.substring(lang.indexOf('-') + 1)));
            this.langs = builder.build();
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return this.langs;
    }*/

    @Override
    public Map<String, List<String>> getAvailableLanguages() {
        return null;
    }

    @Override
    public Translation translate(TranslateRequest translateRequest) throws TranslateException {
        throw new TranslateException("Yandex api access is not implemented yet.");
    }
}
