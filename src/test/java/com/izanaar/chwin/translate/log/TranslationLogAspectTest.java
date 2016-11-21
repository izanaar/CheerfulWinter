package com.izanaar.chwin.translate.log;

import com.izanaar.chwin.translate.config.TranslateConfig;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.providers.ApiProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("local-api")
@ContextConfiguration(classes = TranslateConfig.class)
public class TranslationLogAspectTest {

    @Autowired
    private ApiProvider apiProvider;

    @Test
    public void beforeTranslation() throws Exception {
        apiProvider.translate(mock(TranslateRequest.class));
    }

}