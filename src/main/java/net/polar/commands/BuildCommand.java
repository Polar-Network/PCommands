package net.polar.commands;

import net.minestom.server.command.builder.Command;
import net.polar.PCommands;
import net.polar.utils.ChatColor;

public final class BuildCommand extends Command {

    public BuildCommand() {
        super("build", "buildmode");
        setDefaultExecutor((sender, context) -> {
            Actions.ifPlayerAndPermitted(sender, player -> {
                String state = PCommands.toggleBuild(player.getUuid()) ? "<green>enabled" : "<red>disabled";
                sender.sendMessage(ChatColor.color("<gold>Build mode " + state + "<gold>!"));
            }, "pcommands.build");
        });
    }

}
