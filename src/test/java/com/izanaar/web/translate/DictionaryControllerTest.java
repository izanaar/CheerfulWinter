package com.izanaar.web.translate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.izanaar.dao.DictionaryAPI;
import com.izanaar.service.Dictionary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DictionaryControllerTest {

    String srcLang = "ru";
    Set<String> translationLangs;

    @Mock
    Dictionary dictionary;

    @InjectMocks
    DictionaryController dictionaryController;

    MockMvc controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = MockMvcBuilders.standaloneSetup(dictionaryController).build();

        translationLangs = Arrays.stream(new String[]{"en", "uk"}).collect(Collectors.toSet());

        when(dictionary.getTranslationLanguages(anyString())).thenReturn(Collections.emptySet());
        when(dictionary.getTranslationLanguages(srcLang)).thenReturn(translationLangs);
    }

    @Test
    public void template() throws Exception {

    }

    @Test
    public void getSrcLangs() throws Exception {

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