package com.epam.tat.steam.enums.header;

public enum HardwareMenu implements Menu {
    VALVE_INDEX("valve.index"),
    STEAM_CONTROLLER("steam.controller"),
    STEAM_LINK("steam.link"),
    HTC_VIVE("htc.vive");

    private String name;

    HardwareMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return getNameFromBundle(name);
    }
}
