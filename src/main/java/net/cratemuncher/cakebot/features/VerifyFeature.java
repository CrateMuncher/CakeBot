package net.cratemuncher.cakebot.features;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import net.cratemuncher.cakebot.CBFeature;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class VerifyFeature extends CBFeature {

    public VerifyFeature() {
        setDesc("Verifies mathemathical expressions");
    }

    @Override
    public void onGenericMessage(GenericMessageEvent evt) throws Exception {
        String problem = evt.getMessage().replaceAll(" ", "");
        try {
            String[] sides = problem.split("=");
            double[] results = new double[sides.length];
            if (sides.length < 2) {
                return;
            }
            for (int i = 0; i < sides.length; i++) {
                Calculable calc = new ExpressionBuilder(sides[i]).build();
                double result = calc.calculate();
                results[i] = result;
            }

            boolean equal = true;
            double prev = results[0];
            for (double num : results) {
                if (!equal) {
                    break;
                }
                equal = Math.abs(prev - num) < 0.0001; // "equal" remains true if the difference between the numbers is less than 0.0001 (to account for floating point errors)
            }

            String text = "";
            for (int i = 0; i < results.length; i++) {
                text = text + sides[i] + " [" + results[i] + "]";
                if (i < results.length-1) {
                    text = text + (equal ? " == " : " != ");
                }
            }

            if (equal) {
                evt.respond("Yes, " + text);
            } else {
                evt.respond("Dang, " + text);
            }
        } catch (Exception ignored) {
        }
    }
}
