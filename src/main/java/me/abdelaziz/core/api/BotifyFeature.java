package me.abdelaziz.core.api;

import me.abdelaziz.core.builder.BotifyBot;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class BotifyFeature {

    private final double price, hostingPrice;
    private final List<CommandData> commands;
    private final String key, name, description;
    private final List<ListenerAdapter> listeners;

    public BotifyFeature(final String key, final String name, final String description, final double price, final double hostingPrice) {
        this.name = name;
        this.key = key.replaceAll("[^a-zA-Z]", "").toLowerCase();

        this.price = price;
        this.description = description;
        this.hostingPrice = hostingPrice;

        this.commands = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public void onEnable() {}

    public void onDisable() {}

    public void onBotAdd(final BotifyBot botifyBot) {}

    public void onBotRemove(final BotifyBot botifyBot) {}

    public final void registerListener(final ListenerAdapter... listeners) {
        if (listeners == null) return;

        for (final ListenerAdapter listener : listeners)
            if (listener != null && !this.listeners.contains(listener))
                this.listeners.add(listener);
    }

    public final void unregisterListener(final ListenerAdapter... listeners) {
        if (listeners != null)
            this.listeners.removeAll(List.of(listeners));
    }

    public final void registerCommand(final CommandData... commands) {
        if (commands == null) return;

        for (final CommandData command : commands)
            if (command != null && !this.commands.contains(command))
                this.commands.add(command);
    }

    public final void unregisterCommand(final CommandData... commands) {
        if (commands != null)
            this.commands.removeAll(List.of(commands));
    }

    public final String getKey() {
        return key;
    }

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

    public List<CommandData> getCommands() {
        return commands;
    }

    public List<ListenerAdapter> getListeners() {
        return listeners;
    }

    public final double getTotalPrice() {
        return price + hostingPrice;
    }
}
