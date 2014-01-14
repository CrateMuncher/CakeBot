package net.cratemuncher.cakebot;

import org.pircbotx.hooks.ListenerAdapter;

public class CBFeature extends ListenerAdapter {
    private String desc = "Someone forgot to set a description. It was probably dodo.";
    private boolean hide = false;

    public String getDesc() {
        return desc;
    }

    public boolean getHide() {
        return hide;
    }

    // The setters are for use in the constructor, nowhere else
    protected void setDesc(String desc) {
        this.desc = desc;
    }

    protected void setHide(boolean hide) {
        this.hide = hide;
    }
}
