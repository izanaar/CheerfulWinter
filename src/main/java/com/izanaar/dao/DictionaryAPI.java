package com.izanaar.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.izanaar.dto.translate.DicResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import java.util.*;
import java.util.stream.Collectors;


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

            lookup("table");
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public void lookup(String text) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", apiKey)
                .queryParam("lang", "en-ru")
                .queryParam("ui","ru")
                .queryParam("text",text);

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpEntity<String> response = restTemplate.getForEntity(uriBuilder.toUriString(), String.class);

            ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            try {
                DicResult result = mapper.readValue(response.getBody(), DicResult.class);
                int l = 2;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (RestClientException | JSONException e) {
            e.printStackTrace();
        }
    }
}
