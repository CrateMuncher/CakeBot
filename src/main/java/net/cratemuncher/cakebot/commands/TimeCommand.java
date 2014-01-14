package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.Date;
import java.util.List;

public class TimeCommand extends CBCommand {
    public TimeCommand() {
        super("time", "Shows the current time.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        String time = new Date().toString();
        evt.respond("The current time is: " + time);
    }
}
