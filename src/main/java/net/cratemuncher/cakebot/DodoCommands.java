package net.cratemuncher.cakebot;

import net.cratemuncher.cakebot.commands.CalculateCommand;

public class DodoCommands {
    public static void registerCommands() {
        CakeBot.registerCommand(CalculateCommand.class);
    }
}
