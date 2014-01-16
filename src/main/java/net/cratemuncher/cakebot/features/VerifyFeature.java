package net.cratemuncher.cakebot.features;

import net.cratemuncher.cakebot.CBFeature;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class VerifyFeature extends CBFeature {

    public VerifyFeature() {
        setDesc("Verifies math");
    }

    @Override
    public void onGenericMessage(GenericMessageEvent evt) throws Exception {
        String regex = "^(([-+/*]*\\d+(\\.\\d+)?)*)\\s*=\\s*(([-+/*]*\\d+(\\.\\d+)?)*)$";
        String problem = evt.getMessage();
        if (problem.matches(regex)) {
            String leftProblem = problem.replaceAll(regex, "$1");
            String rightProblem = problem.replaceAll(regex, "$4");
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            try {
                Object resultLeft = engine.eval(leftProblem);
                Object resultRight = engine.eval(rightProblem);
                if (resultLeft.equals(resultRight)) {
                    evt.respond(resultLeft + " = " + resultRight);
                }
                else {
                    evt.respond(resultLeft + " != " + resultRight);
                }

            } catch (ScriptException ex) {
                Logger.getLogger(CalculateFeature.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
