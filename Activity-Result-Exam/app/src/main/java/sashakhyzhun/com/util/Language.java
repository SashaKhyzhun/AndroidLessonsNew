package sashakhyzhun.com.util;

public enum Language {

    ENGLISH("Английский"),
    RUSSIAN("Русский"),
    UKRAINE("Украинский");

    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
