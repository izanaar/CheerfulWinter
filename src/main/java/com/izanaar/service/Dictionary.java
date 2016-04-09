package com.izanaar.service;

import com.izanaar.dao.DictionaryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Dictionary {

    @Autowired
    private DictionaryAPI dictionaryAPI;

    public Optional<String> translateWord(String word){
        return dictionaryAPI.lookup(word);
    }

}
