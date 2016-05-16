package com.izanaar.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.izanaar.dao.TranslationKeeper;
import com.izanaar.domain.Translation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ReviewControllerTest {

    @Mock
    private TranslationKeeper translationKeeper;

    @InjectMocks
    private ReviewController reviewController;

    private MockMvc controller;

    private Set<Translation> mockedTranslations;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = MockMvcBuilders.standaloneSetup(reviewController).build();

        initMockedTranslations();
        when(translationKeeper.getTranslations()).thenReturn(mockedTranslations);
    }

    private void initMockedTranslations() {
        Translation translation = new Translation("mock","mo","ck");
        mockedTranslations = Collections.singleton(translation);
    }

    @Test
    public void pageTemplate() throws Exception {
        controller.perform(get("/review/page_template"))
                .andExpect(view().name("review/review"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTranslations() throws Exception {
        controller.perform(get("/review/translations"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(mockedTranslations)));
    }



}