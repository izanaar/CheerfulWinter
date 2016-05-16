package com.izanaar.dao;

import com.izanaar.domain.Translation;

import java.util.Set;

public interface TranslationKeeper {
    void keepTranslation (Translation translation);
    Set<Translation> getTranslations();
}
