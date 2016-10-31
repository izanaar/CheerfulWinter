package com.izanaar.chwin.dao;

import com.izanaar.chwin.domain.Translation;

import java.util.Set;

public interface TranslationKeeper {
    void keepTranslation (Translation translation);
    Set<Translation> getTranslations();
}
