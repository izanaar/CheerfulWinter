package com.izanaar.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.izanaar.dao.DictionaryAPI;
import com.izanaar.dto.translate.DicResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class Dictionary {

    @Autowired
    private DictionaryAPI dictionaryAPI;

    public DicResult translateWord(String word, String src, String dst) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String responseJson = dictionaryAPI.lookup(word, src, dst).orElse("");//TODO log if fails
        try {
            return mapper.readValue(responseJson, DicResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new DicResult();
        }
    }

    public Set<String> getSourceLanguages() {
        return dictionaryAPI.getDirections().orElse(Collections.emptySet());
    }

    public Set<String> getTranslationLanguages(String sourceLang) {
        return dictionaryAPI.getDirectionsForLang(sourceLang).orElse(Collections.emptySet());
    }
}
