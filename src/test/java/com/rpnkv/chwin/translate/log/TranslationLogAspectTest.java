package com.rpnkv.chwin.translate.log;

import com.rpnkv.chwin.translate.dto.TranslateRequest;
import com.rpnkv.chwin.translate.exception.TranslateException;
import com.rpnkv.chwin.translate.providers.ApiProvider;
import com.rpnkv.chwin.translate.providers.local.LocalApiProvider;
import com.rpnkv.chwin.translate.providers.yandex.YaApiProvider;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

public class TranslationLogAspectTest {

    private ApiProvider localApiProvider;

    private ApiProvider yandexApiProvider;

    @Before
    public void setUp() throws Exception {
        TranslationLogAspect logAspect = new TranslationLogAspect();

        AspectJProxyFactory factory = new AspectJProxyFactory(new LocalApiProvider());
        factory.addAspect(logAspect);
        localApiProvider = factory.getProxy();

        factory = new AspectJProxyFactory(new YaApiProvider(mock(RestTemplate.class)));
        factory.addAspect(logAspect);
        yandexApiProvider = factory.getProxy();
    }

    @Test
    public void beforeTranslation() throws Exception {
        localApiProvider.translate(mock(TranslateRequest.class));
    }

    @Test(expected = TranslateException.class)
    public void translationFailure() throws Exception {
        yandexApiProvider.translate(mock(TranslateRequest.class));
    }
}