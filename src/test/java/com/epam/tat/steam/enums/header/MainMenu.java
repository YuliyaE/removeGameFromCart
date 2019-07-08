package com.epam.tat.steam.enums.header;

public enum MainMenu implements Menu {
    YOUR_STORE("store"),
    GAMES("games"),
    SOFTWARE("software"),
    HARDWARE("hardware"),
    NEWS("news");

    private String name;

    MainMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return getNameFromBundle(name);
    }
}
