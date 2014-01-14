package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.Date;
import java.util.List;

public class TimeCommand extends CBCommand {
    public TimeCommand() {
        setCmd("time");
        setDesc("Shows the current time.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        String time = new Date().toString();
        evt.respond("The current time is: " + time);
    }

    @Override
    public void handle(GenericMessageEvent evt, String arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
