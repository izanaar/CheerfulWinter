package com.izanaar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Translation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String inputText;
    private String sourceLanguage;
    private String finalLanguage;

    public Translation() {
    }

    public Translation(String text, String src, String dst) {
        inputText = text.trim();
        sourceLanguage = src;
        finalLanguage = dst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Translation that = (Translation) o;

        return new org.apache.commons.lang.builder.EqualsBuilder()
                .append(id, that.id)
                .append(inputText, that.inputText)
                .append(sourceLanguage, that.sourceLanguage)
                .append(finalLanguage, that.finalLanguage)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(inputText)
                .append(sourceLanguage)
                .append(finalLanguage)
                .toHashCode();
    }

    @Override
    public String toString() {
        return inputText + ("(" + sourceLanguage + "-" + finalLanguage + ")");
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputLanguage() {
        return sourceLanguage;
    }

    public void setInputLanguage(String inputLanguage) {
        this.sourceLanguage = inputLanguage;
    }

    public String getFinalLanguage() {
        return finalLanguage;
    }

    public void setFinalLanguage(String finalLanguage) {
        this.finalLanguage = finalLanguage;
    }
}
