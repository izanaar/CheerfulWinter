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
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DictionaryAPI {

    @Value("${yandex.dictionary.key}")
    @NotNull
    private String apiKey;

    @Autowired
    private ApplicationContext applicationContext;

    private final String apiUrl = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup";

    private Map<String, Set<String>> directions;

    @PostConstruct
    public void initTranslationDirections(){
        final String url = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs";
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("key", apiKey);
        System.out.println(uriBuilder.toUriString());

        try {
            HttpEntity<String[]> langs = new RestTemplate().getForEntity(uriBuilder.toUriString(), String[].class);

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
            e.printStackTrace();
        }
    }
}
