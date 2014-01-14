import net.cratemuncher.cakebot.CakeBot;
import net.cratemuncher.cakebot.commands.CalculateCommand;

public class DodoCakeBotExt {
    
    public static void registerCommands() {
        CakeBot.registerCommand(CalculateCommand.class);
    }
}
