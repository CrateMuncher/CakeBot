package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public class AYBCommand extends CBCommand {
    public AYBCommand() {
        setCmd("ayb");
        setDesc("ALL YOUR BASE");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("ALL YOUR " + (args.size() > 0 ? args.get(0).toUpperCase() : "BASE") + " ARE BELONG TO US");
    }

    @Override
    public void handle(GenericMessageEvent evt, String arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
