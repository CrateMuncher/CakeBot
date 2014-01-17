package net.cratemuncher.cakebot;

import net.cratemuncher.cakebot.commands.*;
import net.cratemuncher.cakebot.features.CalculateFeature;
import net.cratemuncher.cakebot.features.SubredditFeature;
import net.cratemuncher.cakebot.features.UnitFeature;
import net.cratemuncher.cakebot.features.VerifyFeature;

public class CakeBotRegisters {
    public static void register() {
        CakeBot.registerCommand(TimeCommand.class);
        CakeBot.registerCommand(HelpCommand.class);
        CakeBot.registerCommand(AYBCommand.class);
        CakeBot.registerCommand(BitcoinWalletCommand.class);
        CakeBot.registerCommand(StatusCommand.class);
        CakeBot.registerCommand(RelevantCommand.class);

        CakeBot.registerFeature(CalculateFeature.class);
        CakeBot.registerFeature(SubredditFeature.class);
        CakeBot.registerFeature(VerifyFeature.class);
        CakeBot.registerFeature(UnitFeature.class);
    }
}
