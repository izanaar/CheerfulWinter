package com.izanaar.chwin.translate.providers;

import com.google.common.collect.ImmutableBiMap;
import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;
import com.izanaar.chwin.translate.exception.TranslateException;

import java.util.List;
import java.util.Map;

public interface ApiProvider {

    Map<String, List<String>> getAvailableLanguages();

    Translation translate(TranslateRequest translateRequest) throws TranslateException;

}
