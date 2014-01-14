package net.cratemuncher.cakebot.commands;

import net.cratemuncher.cakebot.CBCommand;
import net.cratemuncher.cakebot.Config;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class StatusCommand extends CBCommand {
    public StatusCommand() {
        setCmd("status");
        setDesc("Shows the current status of BitVid.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        String status = "Something went wrong, fuck.";
        try {
            status = new BufferedReader(new InputStreamReader(new URL("http://bitvid.net/api/status").openStream())).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        evt.respond("Status: " + status);
    }

    @Override
    public void handle(GenericMessageEvent evt, String arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
