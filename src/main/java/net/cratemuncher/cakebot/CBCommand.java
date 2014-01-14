package net.cratemuncher.cakebot;

import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public abstract class CBCommand {
    
<<<<<<< HEAD
    private String cmd = "";
    private String desc = "Someone forgot to set a description. It was probably dodo.";
    private String regex = "";
=======
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
>>>>>>> CakeBot@GitHub/master

    public abstract void handle(GenericMessageEvent evt, List<String> args);

    public String getCmd() {
        return cmd;
    }

    public String getDesc() {
        return desc;
    }
    
    public boolean hasRegex() {
        return !regex.isEmpty();
    }
    
    public String getRegex() {
        return regex;
    }

    // The setters are for use in the constructor, nowhere else
    protected void setCmd(String cmd) {
        this.cmd = cmd;
    }

    protected void setDesc(String desc) {
        this.desc = desc;
    }

    protected void setRegex(String regex) {
        this.regex = regex;
    }
}
