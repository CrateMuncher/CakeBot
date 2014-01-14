package net.cratemuncher.cakebot;

import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public abstract class CBCommand {
    
    private final String cmd;
    private final String desc;
    private final String regex;
    
    public CBCommand(String cmd, String desc) {
        this.cmd = cmd;
        this.desc = desc;
        this.regex = null;
    }
    
    public CBCommand(String cmd, String desc, String regex) {
        this.cmd = cmd;
        this.desc = desc;
        this.regex = regex;
    }

    public abstract void handle(GenericMessageEvent evt, List<String> args);

    public String getCmd() {
        return cmd;
    }

    public String getDesc() {
        return desc;
    }
    
    public boolean hasRegex() {
        return regex != null;
    }
    
    public String getRegex() {
        return regex;
    }
}
