package net.polar.commands;

import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.polar.utils.ChatColor;

public final class GamemodeCommand extends Command {

    public GamemodeCommand() {
        super("gamemode", "gm");
        setDefaultExecutor((sender, context) -> {
            sender.sendMessage(ChatColor.color("<red>You must specify a gamemode!"));
        });
        addSubcommand(new SurvivalCommand());
        addSubcommand(new CreativeCommand());
        addSubcommand(new AdventureCommand());
        addSubcommand(new SpectatorCommand());
    }



    private static class SurvivalCommand extends Command {
        public SurvivalCommand() {
            super("survival", "s", "0");

            setDefaultExecutor((sender, context) -> {
                Actions.ifPlayerAndPermitted(
                        sender,
                        (player) -> player.setGameMode(GameMode.SURVIVAL),
                        "pcommands.gamemode.*", "pcommands.gamemode.survival");
            });

            ArgumentEntity target = ArgumentType.Entity("target").onlyPlayers(true);
            addSyntax((sender, context) -> {
                Player player = context.get(target).findFirstPlayer(sender);
                if (Actions.validPlayer(sender, player)) {
                    player.setGameMode(GameMode.SURVIVAL);
                }
            });

        }
    }

    private static class CreativeCommand extends Command {
        public CreativeCommand() {
            super("creative", "c", "1");

            setDefaultExecutor((sender, context) -> {
                Actions.ifPlayerAndPermitted(
                        sender,
                        (player) -> player.setGameMode(GameMode.CREATIVE),
                        "pcommands.gamemode.*", "pcommands.gamemode.creative");
            });

            ArgumentEntity target = ArgumentType.Entity("target").onlyPlayers(true);
            addSyntax((sender, context) -> {
                Player player = context.get(target).findFirstPlayer(sender);
                if (Actions.validPlayer(sender, player)) {
                    player.setGameMode(GameMode.CREATIVE);
                }
            });
        }
    }

    private static class AdventureCommand extends Command {
        public AdventureCommand() {
            super("adventure", "a", "2");

            setDefaultExecutor((sender, context) -> {
                Actions.ifPlayerAndPermitted(
                        sender,
                        (player) -> player.setGameMode(GameMode.ADVENTURE),
                        "pcommands.gamemode.*", "pcommands.gamemode.adventure");
            });

            ArgumentEntity target = ArgumentType.Entity("target").onlyPlayers(true);
            addSyntax((sender, context) -> {
                Player player = context.get(target).findFirstPlayer(sender);
                if (Actions.validPlayer(sender, player)) {
                    player.setGameMode(GameMode.ADVENTURE);
                }
            });
        }
    }

    private static class SpectatorCommand extends Command {
        public SpectatorCommand() {
            super("spectator", "sp", "3");

            setDefaultExecutor((sender, context) -> {
                Actions.ifPlayerAndPermitted(
                        sender,
                        (player) -> player.setGameMode(GameMode.SPECTATOR),
                        "pcommands.gamemode.*", "pcommands.gamemode.spectator");
            });

            ArgumentEntity target = ArgumentType.Entity("target").onlyPlayers(true);
            addSyntax((sender, context) -> {
                Player player = context.get(target).findFirstPlayer(sender);
                if (Actions.validPlayer(sender, player)) {
                    player.setGameMode(GameMode.SPECTATOR);
                }
            });
        }
    }

}


