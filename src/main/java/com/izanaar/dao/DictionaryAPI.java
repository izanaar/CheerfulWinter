package com.izanaar.dao;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONArray;
import org.json.JSONException;
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
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


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
    public void initTranslationDirections() throws IOException {
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

            lookup("text");
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public void lookup(String text) throws IOException {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", "2515")
                .queryParam("lang", "en-ru")
                .queryParam("text",text);
        try {
            String genreJson = IOUtils.toString(uriBuilder.build().toUri());
            JSONObject json = new JSONObject(genreJson);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
