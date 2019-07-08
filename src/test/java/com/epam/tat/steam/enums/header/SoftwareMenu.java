package com.epam.tat.steam.enums.header;

public enum SoftwareMenu implements Menu {
    SOFTWARE_HUB("software.hub"),
    ANIMATION_MODELING("animation"),
    AUDIO("audio"),
    DESING("design"),
    EDUCATION("education"),
    GAME_DEVELOPMENT("development"),
    PHOTO_EDITING("photo"),
    UTILITIES("utilities"),
    VIDEO_PRODUCTION("video"),
    WEB_PUBLISHING("web");

    private String name;

    SoftwareMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return getNameFromBundle(name);
    }
}
