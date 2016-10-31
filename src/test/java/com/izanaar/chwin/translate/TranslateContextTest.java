package com.izanaar.chwin.translate;

import com.izanaar.chwin.translate.config.Configuration;
import com.izanaar.chwin.translate.service.TranslateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class TranslateContextTest {

    @Autowired
    private TranslateService translateService;

    @Test
    public void serviceNotNull() throws Exception {
        assertNotNull(translateService);
        System.out.println(translateService);
    }
}
