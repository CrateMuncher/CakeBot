package net.cratemuncher.cakebot.features;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import net.cratemuncher.cakebot.CBFeature;
import org.pircbotx.hooks.types.GenericMessageEvent;

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
        try {
            Calculable calc = new ExpressionBuilder(problem).build();
            double result=calc.calculate();
            evt.respond(calc.getExpression() + " = " + result);
        } catch (Exception ignored) {
        }
    }
}
