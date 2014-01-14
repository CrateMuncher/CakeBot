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
}
