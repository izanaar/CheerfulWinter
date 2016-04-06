package com.izanaar.service;

import com.izanaar.dto.Langs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateService {

    @Value("${yandex.api.key}")
    @NotNull
    private String apiKey;

    private final String apiUrl = "https://translate.yandex.net/api/v1.5/tr.json/getLangs";

    public String translate(String textToTranslate) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            Map<String, String> params = constructUrlVariables();

            HttpEntity<Langs> responseEntity = restTemplate.getForEntity("https://translate.yandex.net/api/v1.5/tr.json/getLangs?" +
                    "key=" + apiKey, Langs.class);

            Langs langs = responseEntity.getBody();

            int q = 2;
        }catch (Exception e){
            System.out.println(e);
        }
        return "шла Саша по шоссе";
    }

    private Map<String, String> constructUrlVariables(){
        Map<String, String> variables = new HashMap<>(3, 1);

        variables.put("key", apiKey);

        return variables;
    }


}
