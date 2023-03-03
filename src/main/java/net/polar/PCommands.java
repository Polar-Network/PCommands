package net.polar;

import net.kyori.adventure.text.Component;
import net.minestom.server.extensions.Extension;
import net.polar.commands.FindCommand;
import net.polar.commands.GamemodeCommand;
import net.polar.commands.TeleportCommand;
import net.polar.utils.ChatColor;

public class PCommands extends Extension {

    public static final Component NO_PERMISSION = ChatColor.color("<red>You do not have permission to use this command!");
    public static final Component NOT_PLAYER = ChatColor.color("<red>You must be a player to use this command!");
    public static final Component INVALID_PLAYER = ChatColor.color("<red>Invalid player!");

    @Override
    public void initialize() {
        Polaroid.registerCommands(
                new GamemodeCommand(),
                new TeleportCommand(),
                new FindCommand()
        );
    }

    @Override
    public void terminate() {

    }
}
