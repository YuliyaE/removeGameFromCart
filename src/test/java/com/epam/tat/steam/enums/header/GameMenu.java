package com.epam.tat.steam.enums.header;

public enum GameMenu implements Menu {
    FREE_TO_PLAY("free"),
    EARLY_ACCESS("early"),
    DEMOS("demos"),
    VR("vr"),
    ACTION("action"),
    ADVENTURE("adventure"),
    CASUAL("casual"),
    INDIE("indie"),
    MULTIPLAYER("multiplayer"),
    RACING("racing"),
    RPG("rpg"),
    SIMULATION("simulation"),
    SPORT("sport"),
    STRATEGY("strategy"),
    MAC_OS("mac");

    private String name;

    GameMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return getNameFromBundle(name);
    }
}
