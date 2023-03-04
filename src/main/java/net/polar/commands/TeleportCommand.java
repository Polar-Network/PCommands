package net.polar.commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestom.server.command.builder.arguments.number.ArgumentDouble;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;

public final class TeleportCommand extends Command {

    public TeleportCommand() {
        super("teleport", "tp");

        ArgumentDouble xArg = ArgumentType.Double("x");
        ArgumentDouble yArg = ArgumentType.Double("y");
        ArgumentDouble zArg = ArgumentType.Double("z");

        ArgumentEntity toArg = ArgumentType.Entity("to").onlyPlayers(true);
        ArgumentEntity fromArg = ArgumentType.Entity("player").onlyPlayers(true);

        addSyntax((sender, context) -> {
            Actions.ifPlayerAndPermitted(sender, player -> {
                player.teleport(new Pos(context.get(xArg), context.get(yArg), context.get(zArg)));
            }, "pcommands.teleport");
        }, xArg, yArg, zArg);

        addSyntax((sender, context) -> {
            Actions.ifPlayerAndPermitted(sender, player -> {
                Player p = context.get(toArg).findFirstPlayer(sender);

                if (Actions.validPlayer(sender, p)) player.teleport(p.getPosition());
            }, "pcommands.teleport");
        }, toArg);

        addSyntax((sender, context) -> {
            Actions.ifPermitted(sender, () -> {
                Player p1 = context.get(fromArg).findFirstPlayer(sender);
                Player p2 = context.get(toArg).findFirstPlayer(sender);
                if (Actions.validPlayer(sender, p1) && Actions.validPlayer(sender, p2)) p1.teleport(p2.getPosition());

            }, "pcommands.teleport");
        }, fromArg, toArg);

        addSyntax((sender, context) -> {
            Actions.ifPermitted(sender, () -> {
                Player p = context.get(fromArg).findFirstPlayer(sender);
                if (Actions.validPlayer(sender, p)) p.teleport(new Pos(context.get(xArg), context.get(yArg), context.get(zArg)));
            }, "pcommands.teleport");
        }, fromArg, xArg, yArg, zArg);

    }

}
