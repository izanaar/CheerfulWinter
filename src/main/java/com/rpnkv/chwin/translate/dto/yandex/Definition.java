package com.rpnkv.chwin.translate.dto.yandex;

public class Definition {

    private String text;

    /*@JsonProperty("pos")*/
    private String position;

    /*@JsonProperty("tr")*/
    private TranslationEntry[] translationEntries;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TranslationEntry[] getTranslationEntries() {
        return translationEntries;
    }

    public void setTranslationEntries(TranslationEntry[] translationEntries) {
        this.translationEntries = translationEntries;
    }
}
