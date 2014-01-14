package net.cratemuncher.cakebot;

import net.cratemuncher.cakebot.commands.AYBCommand;
import net.cratemuncher.cakebot.commands.HelpCommand;
import net.cratemuncher.cakebot.commands.TimeCommand;
import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.ArrayList;
import java.util.List;
import net.cratemuncher.cakebot.commands.BitcoinWalletCommand;

public class CakeBot extends ListenerAdapter {

    public static List<CBCommand> commands;

    @Override
    public void onGenericMessage(GenericMessageEvent event) throws Exception {
        for (CBCommand cmd : commands) {
            if (event.getMessage().matches("^!" + cmd.getCmd() + ".*$")) {
                String[] fullargs = event.getMessage().split(" ");
                List<String> args = new ArrayList<String>();
                for (int i=1; i<fullargs.length; i++) {
                    args.add(fullargs[i]);
                }
                cmd.handle(event, args);
                return;
            }
        }
        for (CBCommand command : commands) {
            if (command.hasRegex() && event.getMessage().matches(command.getRegex())) {
                String[] args = event.getMessage().split(" ");
                List<String> argsList = new ArrayList<String>();
                for (int i = 1; i < args.length; i++) {
                    argsList.add(args[i]);
                }
                command.handle(event, argsList);
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

        Configuration conf = new Configuration.Builder()
                .setName("CakeBot9001")
                .setAutoNickChange(true)
                .setServerHostname("irc.freenode.net")
                .addAutoJoinChannel("#cakebot-test")
                .addListener(new CakeBot())
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