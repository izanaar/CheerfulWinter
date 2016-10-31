package com.izanaar.chwin.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.izanaar.chwin.dao.DictionaryAPI;
import com.izanaar.chwin.dao.TranslationKeeper;
import com.izanaar.chwin.domain.Translation;
import com.izanaar.chwin.dto.translate.DicResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@Service
public class Dictionary {

    @Autowired
    private DictionaryAPI dictionaryAPI;

    @Autowired
    private TranslationKeeper translationKeeper;

    public DicResult translate(Translation translation) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String responseJson =
                dictionaryAPI.lookup(translation.getInputText(), translation.getInputLanguage(), translation.getFinalLanguage())
                        .orElse("");//TODO log if fails
        try {
            translationKeeper.keepTranslation(translation);
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
