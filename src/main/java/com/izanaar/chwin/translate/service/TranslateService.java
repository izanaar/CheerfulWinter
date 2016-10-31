package com.izanaar.chwin.translate.service;

import com.izanaar.chwin.translate.dto.TranslateRequest;
import com.izanaar.chwin.translate.dto.Translation;

public interface TranslateService {

    Translation translate(TranslateRequest translateRequest);

}
