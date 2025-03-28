package me.abdelaziz.core.api;

import me.abdelaziz.core.builder.BotifyBot;

@SuppressWarnings("unused")
public abstract class BotifyFeature {

    private final String name, description;
    private final double price, hostingPrice;

    public BotifyFeature(final String name, final String description, final double price, final double hostingPrice) {
        this.name = name.replaceAll("[^a-zA-Z]", "").toLowerCase();

        this.price = price;
        this.description = description;
        this.hostingPrice = hostingPrice;
    }

    public void onEnable() {}

    public void onDisable() {}

    public void onBotAdd(final BotifyBot botifyBot) {}

    public void onBotRemove(final BotifyBot botifyBot) {}

    public final String getName() {
        return name;
    }

    public final double getPrice() {
        return price;
    }

    public final String getDescription() {
        return description;
    }

    public final double getHostingPrice() {
        return hostingPrice;
    }

    public final double getTotalPrice() {
        return price + hostingPrice;
    }
}
