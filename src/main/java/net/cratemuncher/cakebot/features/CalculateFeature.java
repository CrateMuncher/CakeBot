package net.cratemuncher.cakebot.features;

import net.cratemuncher.cakebot.CBFeature;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculateFeature extends CBFeature {

    public CalculateFeature() {
        setDesc("Does simple math");
    }

    @Override
    public void onGenericMessage(GenericMessageEvent evt) throws Exception {
        String problem = evt.getMessage();
        if (problem.matches("^([-+/*]*\\d+(\\.\\d+)?)*$")) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            try {
                Object result = engine.eval(problem);
                evt.respond(problem + " = " + result);
            } catch (ScriptException ex) {
                evt.respond("Syntax error");
            }
        }
    }
}
