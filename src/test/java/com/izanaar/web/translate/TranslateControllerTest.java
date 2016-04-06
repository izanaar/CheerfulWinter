package com.izanaar.web.translate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.izanaar.dto.Translation;
import com.izanaar.service.TranslateService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.when;
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
        mockMvc.perform(get("/translate/"))
                .andExpect(view().name("translate/translate"))
                .andExpect(status().isOk());
    }

    @Test
    public void translate() throws Exception {
        mockMvc.perform(post("/translate/translate")
                .contentType(MediaType.TEXT_PLAIN)
                .content(textToTranslate)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("translation").value(translatedText));

    }

}