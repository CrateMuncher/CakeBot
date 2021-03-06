package net.cratemuncher.cakebot;

import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.List;

public abstract class CBCommand {
    
    private String cmd = "";
    private String desc = "Someone forgot to set a description. It was probably dodo.";
    private boolean hide = false;

    public abstract void handle(GenericMessageEvent evt, List<String> args) throws Exception;

    public String getCmd() {
        return cmd;
    }

    public String getDesc() {
        return desc;
    }

    public boolean getHide() {
        return hide;
    }

    // The setters are for use in the constructor, nowhere else
    protected void setCmd(String cmd) {
        this.cmd = cmd;
    }

    protected void setDesc(String desc) {
        this.desc = desc;
    }

    protected void setHide(boolean hide) {
        this.hide = hide;
    }
}
