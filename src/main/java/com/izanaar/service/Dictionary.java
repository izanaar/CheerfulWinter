package com.izanaar.service;

import com.izanaar.dao.DictionaryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class Dictionary {

    @Autowired
    private DictionaryAPI dictionaryAPI;

    public Optional<String> translateWord(String word){
        return dictionaryAPI.lookup(word);
    }

    public Set<String> getSourceLanguages(){
        return dictionaryAPI.getDirections().orElse(Collections.emptySet());
    }

    public Set<String> getTranslationLanguages(String sourceLang) {
        return dictionaryAPI.getDirectionsForLang(sourceLang).orElse(Collections.emptySet());
    }
}
