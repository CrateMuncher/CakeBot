package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.Date;
import java.util.List;

public class AYBCommand extends CBCommand {
    public AYBCommand() {
        super("ayb", "ALL YOUR BASE");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("ALL YOUR " + (args.size() > 0 ? args.get(0) : "BASE") + " ARE BELONG TO US");
    }
}
