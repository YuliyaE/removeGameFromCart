package com.epam.tat.steam.enums.header;

public enum StoreMenu implements Menu {
    HOME("home"),
    RECENTLY_VIEWED("recently.viewed"),
    CURATORS("curators"),
    RECENTLY_UPDATED("recently.updated");

    private String name;

    StoreMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return getNameFromBundle(name);
    }
}
