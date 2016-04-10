package com.izanaar.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    private MockMvc controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = MockMvcBuilders.standaloneSetup(reviewController).build();
    }

    @Test
    public void pageTemplate() throws Exception {
        controller.perform(get("/review/page_template"))
                .andExpect(view().name("review/review"))
                .andExpect(status().isOk());
    }

}