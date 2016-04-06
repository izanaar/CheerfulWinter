package com.izanaar.service;

import com.izanaar.dto.LangList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

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
            HttpEntity<LangList> responseEntity = restTemplate.getForEntity("https://translate.yandex.net/api/v1.5/tr.json/getLangs?" +
                    "key=" + apiKey, LangList.class);

            LangList langs = responseEntity.getBody();

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

    private Map<String, String> constructUrlVariables() {
        Map<String, String> variables = new HashMap<>(3, 1);

        variables.put("key", apiKey);

        return variables;
    }


}
