package net.cratemuncher.cakebot;

import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public abstract class CBCommand {
    
    private String cmd;
    private String desc;
    private String regex;
    
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
