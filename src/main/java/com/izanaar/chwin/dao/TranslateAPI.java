package com.izanaar.chwin.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class TranslateAPI {

    @Value("${yandex.translate.key}")
    @NotNull
    private String apiKey;

    private final String apiUrl = "https://translate.yandex.net/api/v1.5/tr.json/getLangs";

}
