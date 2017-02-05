package com.rpnkv.chwin.translate.providers.yandex;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

class YaHttpRequest implements HttpRequest {

    private HttpRequest request;
    private String apiKey;

    YaHttpRequest(HttpRequest request, String apiKey) {
        this.request = request;
        this.apiKey = apiKey;
    }

    @Override
    public HttpMethod getMethod() {
        return request.getMethod();
    }

    @Override
    public URI getURI() {
        return UriComponentsBuilder.fromUri(request.getURI())
                .queryParam("key", apiKey)
                .build()
                .toUri();
    }

    @Override
    public HttpHeaders getHeaders() {
        return request.getHeaders();
    }
}
