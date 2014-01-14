package net.cratemuncher.cakebot;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public abstract class CBCommand {
    private String cmd;
    private String desc;
    public CBCommand(String cmd, String desc) {
        this.cmd = cmd;
        this.desc = desc;
    }

    public abstract void handle(GenericMessageEvent evt, List<String> args);

    public String getCmd() {
        return cmd;
    }

    public String getDesc() {
        return desc;
    }
}
