package com.izanaar.dao;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Repository
public class DictionaryAPI {

    @Value("${yandex.dictionary.key}")
    @NotNull
    private String apiKey;

    @Autowired
    private RestTemplateProvider restTemplateProvider;

    private final String apiUrl = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup";

    private Map<String, Set<String>> directions;

    @PostConstruct
    public void initTranslationDirections() throws IOException {
        final String url = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("key", apiKey);

        try {
            HttpEntity<String[]> langs = restTemplateProvider.getRestTemplate().getForEntity(uriBuilder.toUriString(), String[].class);

            directions = Arrays.stream(langs.getBody()).collect(
                    Collectors.toMap(
                            s -> s.substring(0, s.indexOf('-')),
                            s -> Collections.singleton(s.substring(s.indexOf('-') + 1)),
                            (exst,newv) ->{
                                Set<String> mrgd = new HashSet<>(exst);
                                mrgd.addAll(newv);
                                return mrgd;
                            }
                    )
            );

        } catch (RestClientException e) {
            directions = null;
            e.printStackTrace();
        }
    }

    public Optional<String> lookup(String text) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", apiKey)
                .queryParam("lang", "en-ru")
                .queryParam("ui","ru")
                .queryParam("text",text);

        try {
            RestTemplate restTemplate = restTemplateProvider.getRestTemplate();

            HttpEntity<String> response = restTemplate.getForEntity(uriBuilder.toUriString(), String.class);

            return Optional.ofNullable(response.getBody());
        } catch (RestClientException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Set<String>> getDirections(){
        return Optional.ofNullable(directions.keySet());
    }

    public Optional<Set<String>> getDirectionsForLang(String lang){
        return Optional.ofNullable(directions.get(lang));
    }

}
