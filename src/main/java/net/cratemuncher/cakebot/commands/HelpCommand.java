package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import net.cratemuncher.cakebot.CakeBot;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public class HelpCommand extends CBCommand {
    public HelpCommand() {
        super("help", "Shows this screen.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("==========CAKEBOT HELP==========");
        for (CBCommand cmd : CakeBot.commands) {
            evt.respond("!" + cmd.getCmd() + "\t\t" + cmd.getDesc());
        }
        evt.respond("================================");
    }
}
