package com.izanaar.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.izanaar.dto.translate.Definition;
import com.izanaar.dto.translate.DicResult;
import com.izanaar.model.Translation;
import com.izanaar.service.Dictionary;
import com.izanaar.web.DictionaryController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DictionaryControllerTest {

    String srcLang = "ru";
    Set<String> translationLangs;

    String wordToTranslate = "table";
    DicResult translation;

    @Mock
    Dictionary dictionary;

    @InjectMocks
    DictionaryController dictionaryController;

    MockMvc controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = MockMvcBuilders.standaloneSetup(dictionaryController).build();

        initMocksForGettingTranslationLangs();
        initMocksForLookup();
    }

    private void initMocksForGettingTranslationLangs() {
        translationLangs = Arrays.stream(new String[]{"en", "uk"}).collect(Collectors.toSet());

        when(dictionary.getTranslationLanguages(anyString())).thenReturn(Collections.emptySet());
        when(dictionary.getTranslationLanguages(srcLang)).thenReturn(translationLangs);
    }

    private void initMocksForLookup() {

        translation = new DicResult();

        Definition definition = new Definition();
        definition.setText("стол");

        translation.setDefinitions(new Definition[]{definition});

        Translation testTranslation = new Translation("table", "en", "ru");

        when(dictionary.translate(any(Translation.class))).thenReturn(new DicResult());
        when(dictionary.translate(testTranslation)).thenReturn(translation);
    }

    @Test
    public void template() throws Exception {

    }

    @Test
    public void getSrcLangs() throws Exception {

    }

    @Test
    public void lookup() throws Exception {
        controller
                .perform(get("/dictionary/lookup")
                        .param("text", "table")
                        .param("src", "en")
                        .param("dst", "ru"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(translation)));
    }

    @Test
    public void getTrnLangs() throws Exception {
        controller
                .perform(get("/dictionary/trn_langs").param("src", srcLang))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(translationLangs)));


    }

}