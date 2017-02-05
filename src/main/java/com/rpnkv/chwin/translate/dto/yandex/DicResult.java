package com.rpnkv.chwin.translate.dto.yandex;


public class DicResult {

    /*@JsonProperty("def")*/
    private Definition[] definitions;

    public Definition[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definition[] definitions) {
        this.definitions = definitions;
    }
}
