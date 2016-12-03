package com.izanaar.chwin.translate.providers.yandex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = YaProviderConfig.class)
@TestPropertySource("file:/opt/prop/chwin.properties")
@ActiveProfiles("ya-api")
public class YaApiProviderTest {

    @Autowired
    private YaApiProvider apiProvider;

    @Test
    public void getAvailableLanguages() throws Exception {
        apiProvider.getAvailableLanguages();
    }

    @Test
    public void translate() throws Exception {
        String lang = "ru-en";
        System.out.println(lang.substring(0, lang.indexOf('-')));
        System.out.println(lang.substring(lang.indexOf('-') + 1));
    }

}