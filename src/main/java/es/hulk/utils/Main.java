package es.hulk.utils;

import es.hulk.utils.commands.GmCMD;
import es.hulk.utils.utils.FileConfig;
import es.hulk.utils.utils.command.CommandFramework;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

@Getter
@Setter
public class Main extends JavaPlugin {

    private CommandFramework commandFramework;
    private static Main instance;

    private FileConfig mainConfig;

    @Override
    public void onEnable() {
        
        commandFramework = new CommandFramework(this);
        instance = this;
        this.saveDefaultConfig();

        registerCMDs();
        loadConfig();
    }

    @Override
    public void onDisable() {
    }

    public void loadConfig() {
        mainConfig = new FileConfig(this, "config.yml");
    }

    public void registerCMDs() {
        commandFramework.registerCommands(new GmCMD());
    }

    public static Main getInstance() {
        return instance;
    }

    public CommandFramework getCommandFramework() {
        return commandFramework;
    }

    public void setCommandFramework(CommandFramework commandFramework) {
        this.commandFramework = commandFramework;
    }

    public static Main get() {
        return getPlugin(Main.class);
    }
}
