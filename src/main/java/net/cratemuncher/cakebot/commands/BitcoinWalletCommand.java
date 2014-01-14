package net.cratemuncher.cakebot.commands;

import java.util.List;
import net.cratemuncher.cakebot.CBCommand;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class BitcoinWalletCommand extends CBCommand {
    public BitcoinWalletCommand() {
        setCmd("bitcoin-balance");
        setDesc("Shows the balance of a particular Bitcoin wallet.");
    }

    @Override
    public void handle(GenericMessageEvent evt, List<String> args) {
        evt.respond("This is a Bitcoin wallet address.");
    }
    
}
