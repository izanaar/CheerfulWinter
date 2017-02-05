package com.rpnkv.chwin.translate.dto;

public class TranslateRequest {

    private String srcLang,
            dstLang,
            text;

    public TranslateRequest() {
    }

    public TranslateRequest(String srcLang, String dstLang, String text) {
        this.srcLang = srcLang;
        this.dstLang = dstLang;
        this.text = text;
    }

    public String getSrcLang() {
        return srcLang;
    }

    public void setSrcLang(String srcLang) {
        this.srcLang = srcLang;
    }

    public String getDstLang() {
        return dstLang;
    }

    public void setDstLang(String dstLang) {
        this.dstLang = dstLang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TranslateRequest request = (TranslateRequest) o;

        if (srcLang != null ? !srcLang.equals(request.srcLang) : request.srcLang != null) return false;
        if (dstLang != null ? !dstLang.equals(request.dstLang) : request.dstLang != null) return false;
        return text != null ? text.equals(request.text) : request.text == null;

    }

    @Override
    public int hashCode() {
        int result = srcLang != null ? srcLang.hashCode() : 0;
        result = 31 * result + (dstLang != null ? dstLang.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TranslateRequest{" +
                "srcLang='" + srcLang + '\'' +
                ", dstLang='" + dstLang + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
