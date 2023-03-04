package net.polar.commands;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.arguments.ArgumentString;
import net.minestom.server.command.builder.arguments.ArgumentType;
import net.minestom.server.command.builder.arguments.ArgumentWord;

public final class SchematicCommand extends Command {

    public SchematicCommand() {
        super("schematic", "schem");
        setDefaultExecutor((sender, context) -> Actions.ifPermitted(sender, () -> {
            if (!MinecraftServer.getBrandName().equals("Polaroid")) {
                throw new IllegalStateException("This command is only available on Polaroid!");
            }
        }, "pcommands.schematic"));

    }



    private static class Paste extends Command {

        private Paste() {
            super("paste", "p");
            ArgumentWord nameArg = ArgumentType.Word("name");

        }

    }


}
