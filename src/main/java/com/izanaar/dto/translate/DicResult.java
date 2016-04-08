package com.izanaar.dto.translate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DicResult {

    @JsonProperty("def")
    private Definition[] definitions;

    public Definition[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definition[] definitions) {
        this.definitions = definitions;
    }
}
