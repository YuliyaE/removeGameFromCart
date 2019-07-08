package com.epam.tat.steam.enums.header;

public enum  LanguageMenu implements Menu {
    ENGLISH("english", "en"),
    RUSSIAN("russian", "ru"),
    DEUTSCH("deutsch", "de"),
    POLSKI("polski", "pol"),
    UKRANIAN("ukranian", "ukr");

    private String name;
    private String localLanguageButtonName;

    LanguageMenu(String name, String localLanguageButtonName) {
        this.name = name;
        this.localLanguageButtonName=localLanguageButtonName;
    }

    public String getName() {
        return getNameFromBundle(name);
    }
    public String getLocalLanguageButtonName() {
        return getNameFromBundle(localLanguageButtonName);
    }

}
