package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import net.cratemuncher.cakebot.Config;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.Date;
import java.util.List;

public class StatusCommand extends CBCommand {
    public StatusCommand() {
        setCmd("status");
        setDesc("Shows the current status of BitVid.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("Status: " + Config.statusMessage);
    }
}
