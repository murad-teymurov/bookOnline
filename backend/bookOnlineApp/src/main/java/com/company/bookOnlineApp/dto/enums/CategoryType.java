package com.company.bookOnlineApp.dto.enums;


public enum CategoryType {
    RESEARCH_HISTORY("Axtarma - Tarixi"),
    SCINECE("Bilik"),
    VALUE("DEGER"),
    OTHER("Diger");



    private final String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
