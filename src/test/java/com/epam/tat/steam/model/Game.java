package com.epam.tat.steam.model;

import java.util.Objects;

public class Game {
    private String name;
    private String price;
    private String platform;

    public Game(String name, String price, String platform) {
        this.name = name;
        this.price = price;
        this.platform = platform;
    }

    public Game() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return name.equals(game.name) &&
                price.equals(game.price) &&
                platform.equals(game.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, platform);
    }
}
