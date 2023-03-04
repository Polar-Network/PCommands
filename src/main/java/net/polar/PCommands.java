package net.polar;

import net.kyori.adventure.text.Component;
import net.minestom.server.MinecraftServer;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.extensions.Extension;
import net.polar.commands.*;
import net.polar.utils.ChatColor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PCommands extends Extension {

    public static final Component NO_PERMISSION = ChatColor.color("<red>You do not have permission to use this command!");
    public static final Component NOT_PLAYER = ChatColor.color("<red>You must be a player to use this command!");
    public static final Component INVALID_PLAYER = ChatColor.color("<red>Invalid player!");

    private static final Set<UUID> buildMode = ConcurrentHashMap.newKeySet();

    @Override
    public void initialize() {
        List.of(new GamemodeCommand(),
                new TeleportCommand(),
                new FindCommand(),
                new SaveCommand(),
                new BuildCommand()
        ).forEach(MinecraftServer.getCommandManager()::register);

        getEventNode().addListener(PlayerBlockBreakEvent.class, event -> {
            if (cantBuild(event.getPlayer().getUuid()))
                event.setCancelled(true);

        });
        getEventNode().addListener(PlayerBlockBreakEvent.class, event -> {
            if (cantBuild(event.getPlayer().getUuid()))
                event.setCancelled(true);
        });
    }


    public static boolean cantBuild(UUID uuid) {
        return !buildMode.contains(uuid);
    }

    public static boolean toggleBuild(UUID uuid) {
        if (buildMode.contains(uuid)) {
            buildMode.remove(uuid);
            return false;
        } else {
            buildMode.add(uuid);
            return true;
        }
    }

    @Override
    public void terminate() {

    }
}
