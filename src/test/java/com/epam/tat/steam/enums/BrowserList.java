package com.epam.tat.steam.enums;

public enum BrowserList {
    CHROME("chrome"),

    EDGE("edge"),

    FIREFOX("firefox"),

    OPERA("opera"),

    SAFARI("safari");

    private String name;

    BrowserList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
