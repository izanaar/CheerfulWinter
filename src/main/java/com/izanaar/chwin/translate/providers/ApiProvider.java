package com.izanaar.chwin.translate.providers;

import com.google.common.collect.ImmutableBiMap;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import com.izanaar.chwin.translate.exception.TranslateException;

public interface ApiProvider {

    ImmutableBiMap<String, String> getAvailableLanguages();

    Translation translate(TranslateRequest translateRequest) throws TranslateException;

}
