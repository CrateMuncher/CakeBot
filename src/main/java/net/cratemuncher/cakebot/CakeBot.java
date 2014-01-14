package net.cratemuncher.cakebot;

import net.cratemuncher.cakebot.commands.*;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.ArrayList;
import java.util.List;

public class CakeBot extends ListenerAdapter {

    public static List<CBCommand> commands;

    @Override
    public void onGenericMessage(GenericMessageEvent event) throws Exception {
        for (CBCommand cmd : commands) {
            if ((event.getMessage().matches("^" + Config.prefix + cmd.getCmd() + ".*$")) || (cmd.hasRegex() && event.getMessage().matches("^" + cmd.getRegex() + "$"))) { // Basically, run this block if the message either matches the command OR the regex
                String[] fullargs = event.getMessage().split(" ");
                List<String> args = new ArrayList<String>();
                for (int i=1; i<fullargs.length; i++) {
                    args.add(fullargs[i]);
                }
                cmd.handle(event, args);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        commands = new ArrayList<CBCommand>();
        registerCommand(TimeCommand.class);
        registerCommand(HelpCommand.class);
        registerCommand(AYBCommand.class);
        registerCommand(BitcoinWalletCommand.class);
        registerCommand(StatusCommand.class);

        Configuration conf = new Configuration.Builder()
                .setName(Config.name)
                .setServerHostname(Config.hostname)
                .addAutoJoinChannel(Config.channel)
                .addListener(new CakeBot())
                .setAutoNickChange(true)
                .setAutoReconnect(true)
                .buildConfiguration();

        try {
            PircBotX bot = new PircBotX(conf);
            bot.startBot();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void registerCommand(Class<? extends CBCommand> clazz) {
        try {
            commands.add(clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}