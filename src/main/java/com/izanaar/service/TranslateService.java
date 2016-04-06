package com.izanaar.service;

import com.izanaar.dto.LangList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.*;

@Service
public class TranslateService {

    @Value("${yandex.api.key}")
    @NotNull
    private String apiKey;

    private final String apiUrl = "https://translate.yandex.net/api/v1.5/tr.json/getLangs";

    private Map<String, HashSet<String>> translations = new HashMap<>();

    @PostConstruct
    private void initTranslations() {
        RestTemplate restTemplate = new RestTemplate();
        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                    .queryParam("key", apiKey);

            HttpEntity<?> entity = new HttpEntity<>(LangList.class);

            HttpEntity<LangList> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, LangList.class);

            LangList langs = response.getBody();

            langs.getDirs().forEach(this::collectTranslation);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void collectTranslation(String translation) {//TODO implement via Collectors
        int hyphenIndex = translation.indexOf('-');
        String key = translation.substring(0, hyphenIndex);
        String value = translation.substring(hyphenIndex + 1);

        if(!translations.containsKey(key)){
            translations.put(key, new HashSet<>());
        }

        translations.get(key).add(value);
    }

    public String translate(String textToTranslate) {
        return "шла Саша по шоссе";
    }

    public Set<String> getSourceLangs(){
        return translations.keySet();
    }

    public Set<String> getTranslations(String sourceLang){
        return translations.containsKey(sourceLang) ? translations.get(sourceLang) : Collections.EMPTY_SET;
    }

}
