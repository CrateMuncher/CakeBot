package net.cratemuncher.cakebot.features;

import net.cratemuncher.cakebot.CBFeature;
import org.apache.commons.lang3.StringUtils;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubredditFeature extends CBFeature {
    private Pattern subredditPattern = Pattern.compile("/r/([A-Za-z0-9_.-]+)+");

    public SubredditFeature() {
        setDesc("Expands /r/subreddits into full links");
    }

    @Override
    public void onGenericMessage(GenericMessageEvent evt) throws Exception {
        String text = evt.getMessage();

        Matcher m = subredditPattern.matcher(text);

        Set<String> links = new LinkedHashSet<String>(); //java.util.Set, just to prevent duplicates
        while (m.find()) {
            links.add("http://reddit.com/r/" + m.group(1));
        }

        if (links.size() > 0) {
            String res = StringUtils.join(links, ", ");
            evt.respond(res);
        }
    }
}
