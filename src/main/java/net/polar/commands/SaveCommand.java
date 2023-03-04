package net.polar.commands;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.polar.Polaroid;

public final class SaveCommand extends Command {

    public SaveCommand() {
        super("save");

        this.setDefaultExecutor((sender, context) -> {
            Actions.ifPermitted(sender, () -> {
                if (!MinecraftServer.getBrandName().equals("Polaroid")) {
                    throw new IllegalStateException("This command is only available on Polaroid!");
                }

                Polaroid.getDefaultInstance().saveInstance().thenRun(() -> {
                    Polaroid.getDefaultInstance().saveChunksToStorage();
                });
            }, "pcommands.save");
        });
    }


}
