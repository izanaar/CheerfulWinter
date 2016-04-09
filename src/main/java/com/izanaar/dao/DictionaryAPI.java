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
import java.util.*;
import java.util.stream.Collectors;


@Repository
public class DictionaryAPI {

    @Value("${yandex.dictionary.key}")
    @NotNull
    private String apiKey;

    @Autowired
    private RestTemplateProvider restTemplateProvider;

    private final String lookupUrl = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup",
                         langsUrl = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs";

    private Map<String, Set<String>> directions;

    @PostConstruct
    public void initTranslationDirections() {
        try {
            HttpEntity<String[]> langs = restTemplateProvider.getRestTemplate().getForEntity(buildLangsUri(), String[].class);
            initDirections(langs.getBody());
        } catch (RestClientException e) {
            directions = new HashMap<>();
            e.printStackTrace();
        }
    }

    private String buildLangsUri(){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(langsUrl)
                .queryParam("key", apiKey);
        return uriBuilder.toUriString();
    }

    private void initDirections(String[] body) {
        directions = Arrays.stream(body).collect(
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
    }

    public Optional<String> lookup(String text, String src, String dst) {
        try {
            RestTemplate restTemplate = restTemplateProvider.getRestTemplate();

            HttpEntity<String> response = restTemplate.getForEntity(buildLookupUri(text, src, dst), String.class);
            return Optional.ofNullable(response.getBody());

        } catch (RestClientException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private String buildLookupUri(String text, String src, String dst) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(lookupUrl)
                .queryParam("key", apiKey)
                .queryParam("lang", src + "-" + dst)
                .queryParam("ui","ru")
                .queryParam("text", text);

        return uriBuilder.toUriString();
    }

    public Optional<Set<String>> getDirections(){
        return Optional.ofNullable(directions.keySet());
    }

    public Optional<Set<String>> getDirectionsForLang(String lang){
        return Optional.ofNullable(directions.get(lang));
    }

}
