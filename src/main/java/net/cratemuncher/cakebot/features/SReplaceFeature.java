package net.cratemuncher.cakebot.features;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import net.cratemuncher.cakebot.CBFeature;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SReplaceFeature extends CBFeature {
    HashMap<String, String> lastTexts;
    Pattern p = Pattern.compile("^(?:(.+): )?s/(.+)/([^/]+)/?$");

    public SReplaceFeature() {
        setDesc("Replaces your typos");
        lastTexts = new HashMap<String, String>();
    }


    @Override
    public void onMessage(MessageEvent evt) throws Exception {
        String msg = evt.getMessage();

        Matcher m = p.matcher(msg);

        if (m.matches()) {
            String from = m.group(2);
            String to = m.group(3);

            String user = m.group(1);

            String fixedText;
            if (user != null) {
                if (!lastTexts.containsKey(user)) {
                    return;
                }
                fixedText = lastTexts.get(user);
            } else {
                fixedText = lastTexts.get(evt.getUser().getNick());
            }

            fixedText = fixedText.replaceAll(from, to);

            evt.getChannel().send().message("What " + evt.getUser().getNick() + " meant: " + fixedText);
        } else {
            lastTexts.put(evt.getUser().getNick(), msg);
        }
    }
}
