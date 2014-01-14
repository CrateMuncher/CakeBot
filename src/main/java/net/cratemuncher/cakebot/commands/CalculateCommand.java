package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculateCommand extends CBCommand {

    public CalculateCommand() {
        setCmd("calculate");
        setDesc("Can evaluate a mathematical problem.");
        setRegex("[0-9\\+\\-\\*]{3,}");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        // Do nothing
    }

    @Override
    public void handle(GenericMessageEvent evt, String arg) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object result = engine.eval(arg);
            evt.respond(arg + " = " + result);
        } catch (ScriptException ex) {
            Logger.getLogger(CalculateCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
