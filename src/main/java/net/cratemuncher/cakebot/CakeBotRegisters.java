package net.cratemuncher.cakebot;

import net.cratemuncher.cakebot.commands.*;
import net.cratemuncher.cakebot.features.CalculateFeature;
import net.cratemuncher.cakebot.features.SubredditFeature;

public class CakeBotRegisters {
    public static void register() {
        CakeBot.registerCommand(TimeCommand.class);
        CakeBot.registerCommand(HelpCommand.class);
        CakeBot.registerCommand(AYBCommand.class);
        CakeBot.registerCommand(BitcoinWalletCommand.class);
        CakeBot.registerCommand(StatusCommand.class);

        CakeBot.registerFeature(CalculateFeature.class);
        CakeBot.registerFeature(SubredditFeature.class);
    }
}
