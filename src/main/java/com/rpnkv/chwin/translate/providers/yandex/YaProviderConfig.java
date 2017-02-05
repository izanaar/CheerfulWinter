package com.rpnkv.chwin.translate.providers.yandex;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@PropertySource("file:/opt/prop/chwin.properties")
@Profile("ya-api")
public class YaProviderConfig {

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    RestTemplate yaRestTemplate(@Value("${ya.dict.key}") String apiKey) {
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> execution.execute(new YaHttpRequest(request, apiKey), body);

        RestTemplate template = new RestTemplate();
        template.setInterceptors(Collections.singletonList((interceptor)));
        return template;
    }

    @Bean
    YaApiProvider apiProvider(@Qualifier("yaRestTemplate") RestTemplate restTemplate) {
        return new YaApiProvider(restTemplate);
    }

}
