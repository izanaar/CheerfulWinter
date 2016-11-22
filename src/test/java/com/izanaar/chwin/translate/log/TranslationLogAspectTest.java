package com.izanaar.chwin.translate.log;

import com.izanaar.chwin.translate.config.TranslateConfig;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.exception.TranslateException;
import com.izanaar.chwin.translate.providers.ApiProvider;
import com.izanaar.chwin.translate.providers.local.LocalApiProvider;
import com.izanaar.chwin.translate.providers.yandex.YandexApiProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
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

        factory = new AspectJProxyFactory(new YandexApiProvider());
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