package es.hulk.utils.commands;

import es.hulk.utils.utils.command.BaseCommand;
import es.hulk.utils.utils.command.Command;
import es.hulk.utils.utils.command.CommandArgs;

public class GmCMD extends BaseCommand {

    @Command(name = "test", aliases = {"testing", "testeng", "utilities.testing"}, permission = "permission.example", noPerm = "§cNo Permission")

    @Override
    public void onCommand(CommandArgs cmd) {

    }
}
