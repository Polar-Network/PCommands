package net.polar.commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.number.ArgumentFloat;
import net.minestom.server.entity.Entity;

import java.util.Collection;

import static net.minestom.server.command.builder.arguments.ArgumentType.Float;

public class FindCommand extends Command {
    public FindCommand() {
        super("find");

        ArgumentFloat rangeArg = Float("range");

        this.addSyntax((sender, context) -> {
            Actions.ifPlayerAndPermitted(sender, player -> {
                float range = context.get(rangeArg);
                Collection<Entity> entities = player.getInstance().getNearbyEntities(player.getPosition(), range);

                player.sendMessage("Search result: ");

                for (Entity entity : entities) {
                    player.sendMessage("    " + entity.getEntityType() + ": ");
                    player.sendMessage("        Meta: " + entity.getEntityMeta());
                    player.sendMessage("        Permissions: " + entity.getAllPermissions());
                    player.sendMessage("        Position: " + entity.getPosition());
                }

                player.sendMessage("End result.");
            }, "pcommands.find");
        }, rangeArg);

    }

}