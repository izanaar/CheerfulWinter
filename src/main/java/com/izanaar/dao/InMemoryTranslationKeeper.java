package com.izanaar.dao;

import com.izanaar.model.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Repository
public class InMemoryTranslationKeeper implements TranslationKeeper {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${translations.file.name}")
    @NotNull
    private String fileName;

    private Set<Translation> translations;

    @PostConstruct
    public void pc() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            translations = (HashSet<Translation>) inputStream.readObject();
            logger.info("Translations have been read.");
        } catch (FileNotFoundException e) {
            logger.warn("Unable to read serialized translations, creating new.");
            translations = new HashSet<>(10);
        } catch (IOException e) {
            logger.error("Translation-contained file reading ended with an IOException: {}", e);
        } catch (ClassCastException | ClassNotFoundException e) {
            logger.error("Translation-contained file reading ended with class cast exception.");
        }
    }

    @PreDestroy
    public void pd() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(translations);
            logger.info("Translations have been saved.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keepTranslation(Translation translation) {
        if (translations.add(translation)) {
            logger.debug("Saved translation: {}", translation);
        }
    }

    @Override
    public Set<Translation> getTranslations() {
        return translations;
    }
}
