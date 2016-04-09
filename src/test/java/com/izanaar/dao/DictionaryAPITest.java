package com.izanaar.dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class DictionaryAPITest {

    final String fakeApiKey = "k2ttqw";


    @Mock
    RestTemplateProvider restTemplateProvider;

    @InjectMocks
    DictionaryAPI dictionaryAPI;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(dictionaryAPI,"apiKey",fakeApiKey);

    }


    @Test
    public void initTranslationDirections() throws Exception {

    }

    @Test
    public void lookup() throws Exception {

    }

    @Test
    public void getDirections() throws Exception {

    }

    @Test
    public void getDirectionsForLang() throws Exception {

    }

}