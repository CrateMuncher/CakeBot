package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.Date;
import java.util.List;

public class RelevantCommand extends CBCommand {
    public RelevantCommand() {
        setCmd("relevant");
        setDesc("DUN DUN DUUUUUUUUUUUN!");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("http://www.youtube.com/watch?v=bW7Op86ox9g");
    }
}
