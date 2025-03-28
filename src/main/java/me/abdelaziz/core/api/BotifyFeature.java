package me.abdelaziz.core.api;

import me.abdelaziz.core.builder.BotifyBot;

public abstract class BotifyFeature {

    private final double price;
    private final String name, description;

    public BotifyFeature(final String name, final String description, final double price) {
        this.name = name.replaceAll("[^a-zA-Z]", "").toLowerCase();

        this.price = price;
        this.description = description;
    }

    public void onEnable() {}

    public void onDisable() {}

    public void onBotAdd(final BotifyBot botifyBot) {}

    public void onBotRemove(final BotifyBot botifyBot) {}

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
