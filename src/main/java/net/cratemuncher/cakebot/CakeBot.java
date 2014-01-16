package net.cratemuncher.cakebot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CakeBot extends ListenerAdapter {

    public static List<CBCommand> commands;
    public static List<CBFeature> features;

    @Override
    public void onGenericMessage(GenericMessageEvent event) throws Exception {
        for (CBCommand cmd : commands) {
            if ((event.getMessage().matches("^" + Config.prefix + cmd.getCmd() + ".*$"))) {
                String[] fullargs = event.getMessage().split(" ");
                List<String> args = new ArrayList<String>();
                args.addAll(Arrays.asList(fullargs).subList(1, fullargs.length));
                cmd.handle(event, args);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        commands = new ArrayList<CBCommand>();
        features = new ArrayList<CBFeature>();

        CakeBotRegisters.register();

        Configuration conf = new Configuration.Builder()
                .setName(Config.name)
                .setServerHostname(Config.hostname)
                .addAutoJoinChannel(Config.channel)
                .addListener(new CakeBot())
                .setAutoNickChange(true)
                .setAutoReconnect(true)
                .buildConfiguration();
        for (ListenerAdapter listener : features) {
            conf.getListenerManager().addListener(listener);
        }

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

    public static void registerFeature(Class<? extends CBFeature> clazz) {
        try {
            features.add(clazz.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}