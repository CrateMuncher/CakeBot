package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import net.cratemuncher.cakebot.CBFeature;
import net.cratemuncher.cakebot.CakeBot;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public class HelpCommand extends CBCommand {
    public HelpCommand() {
        setCmd("help");
        setDesc("Shows this screen.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("==========CAKEBOT HELP==========");
        for (CBCommand cmd : CakeBot.commands) {
            if (!cmd.getHide()) {
                evt.respond("!" + cmd.getCmd() + "\t\t" + cmd.getDesc());
            }
        }

        if (!CakeBot.features.isEmpty()) {
            evt.respond("");
            evt.respond("Other features:");
            for (CBFeature feat : CakeBot.features) {
                if (!feat.getHide()) {
                    evt.respond(feat.getDesc());
                }
            }
        }
        evt.respond("================================");
    }

    @Override
    public void handle(GenericMessageEvent evt, String arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
