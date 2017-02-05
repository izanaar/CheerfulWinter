package com.rpnkv.chwin.translate.providers;

import com.rpnkv.chwin.translate.dto.TranslateRequest;
import com.rpnkv.chwin.translate.dto.Translation;
import com.rpnkv.chwin.translate.exception.TranslateException;

import java.util.List;
import java.util.Map;

public interface ApiProvider {

    Map<String, List<String>> getAvailableLanguages();

    Translation translate(TranslateRequest translateRequest) throws TranslateException;

}
