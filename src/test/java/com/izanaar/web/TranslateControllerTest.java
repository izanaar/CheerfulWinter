package com.izanaar.web;

import com.izanaar.service.TranslateService;
import com.izanaar.web.TranslateController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class TranslateControllerTest {

    private final String textToTranslate = "involves",
                            translatedText = "включает";

    @Mock
    TranslateService translateService;

    @InjectMocks
    TranslateController translateController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(translateController).build();
        //when(translateService.translate(textToTranslate)).thenReturn(translatedText);
    }

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/translation/page_template"))
                .andExpect(view().name("translate/translate"))
                .andExpect(status().isOk());
    }

    @Test
    @Ignore
    public void translate() throws Exception {
        mockMvc.perform(post("/translation/translate")
                .contentType(MediaType.TEXT_PLAIN)
                .content(textToTranslate)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("translation").value(translatedText));

    }

}