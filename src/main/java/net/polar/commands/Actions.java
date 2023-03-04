package net.polar.commands;

import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static net.polar.PCommands.*;

final class Actions {
    private Actions() {}

    public static void ifPermitted(CommandSender sender, Runnable runnable, String... permissions) {
        if (sender instanceof Player) {
            ifPermitted((Player) sender, runnable, permissions);
            return;
        }
        runnable.run();
    }

    public static void ifPermitted(Player player, Runnable actionIfYes, String... permissions) {
        boolean status = player.hasPermission("pcommands.*");
        if (!status) {
            for (String permission : permissions) {
                if (player.hasPermission(permission)) {
                    status = true;
                    break;
                }
            }
        }
        if (status) {
            actionIfYes.run();
        } else {
            player.sendMessage(NO_PERMISSION);
        }
    }


    public static void ifPlayerAndPermitted(CommandSender sender, Consumer<Player> actionIfYes, String... permissions) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(NOT_PLAYER);
            return;
        }

        boolean status = player.hasPermission("pcommands.*");
        if (!status) {
            for (String permission : permissions) {
                if (player.hasPermission(permission)) {
                    status = true;
                    break;
                }
            }
        }


        if (status) {
            actionIfYes.accept(player);
        } else {
            player.sendMessage(NO_PERMISSION);
        }
    }

    public static boolean validPlayer(CommandSender sender, @Nullable Player player) {
        if (player == null) {
            sender.sendMessage(INVALID_PLAYER);
            return false;
        }
        return true;
    }
}
