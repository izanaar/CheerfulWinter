package com.izanaar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Service
public class DictionaryAPI {

    @Value("${yandex.dictionary.key}")
    @NotNull
    private String apiKey;

    @Autowired
    private ApplicationContext applicationContext;

    private final String apiUrl = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup";

    private Map<String, HashSet<String>> directions;

    @PostConstruct
    public void initTranslationDirections(){
        final String url = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("key", apiKey);
        System.out.println(uriBuilder.toUriString());

        try {
            HttpEntity<String[]> langs = new RestTemplate().getForEntity(uriBuilder.toUriString(), String[].class);

            directions = new HashMap<>();
            Arrays.stream(langs.getBody()).forEach(this::addDirection);

        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    private void addDirection(String direction){
        int hypenIndex = direction.indexOf('-');
        String key = direction.substring(0,hypenIndex),
                value = direction.substring(hypenIndex + 1);

        if(!directions.containsKey(key)){
            directions.put(key, new HashSet<>());
        }

        directions.get(key).add(value);
    }
}
