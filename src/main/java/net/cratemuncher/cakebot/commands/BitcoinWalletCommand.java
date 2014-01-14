package net.cratemuncher.cakebot.commands;

import java.util.List;
import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class BitcoinWalletCommand extends CBCommand {
    public BitcoinWalletCommand() {
        setCmd("bitcoin-balance");
        setDesc("Shows the balance of a particular Bitcoin wallet.");
        setRegex("[A-Za-z0-9]{34}");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("This is a Bitcoin wallet address.");
    }

    @Override
    public void handle(GenericMessageEvent evt, String arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
