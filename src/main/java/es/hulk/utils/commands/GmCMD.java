package es.hulk.utils.commands;

import es.hulk.utils.Main;
import es.hulk.utils.utils.FileConfig;
import es.hulk.utils.utils.Utils;
import es.hulk.utils.utils.command.BaseCommand;
import es.hulk.utils.utils.command.Command;
import es.hulk.utils.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class GmCMD extends BaseCommand {

    private final Main plugin = Main.get();
    private final FileConfig mainConfig = Main.get().getMainConfig();

    @Command(name = "test", aliases = {"testing", "testeng", "utilities.testing"}, permission = "permission.example", noPerm = "§cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();
        if (player.hasPermission("test.permission")) {
            player.sendMessage(Utils.color(mainConfig.getString("TEXT-STRING")));
        }
    }
}
