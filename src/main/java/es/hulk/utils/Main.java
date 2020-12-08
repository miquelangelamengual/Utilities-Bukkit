package es.hulk.utils;

import es.hulk.utils.commands.GmCMD;
import es.hulk.utils.utils.command.CommandFramework;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private CommandFramework commandFramework;
    private static Main instance;

    private File testFile;
    private FileConfiguration tesConfig;

    @Override
    public void onEnable() {

        instance = this;
        this.saveDefaultConfig();

        registerCMDs();

    }

    @Override
    public void onDisable() {
    }

    public void registerCMDs() {
        commandFramework.registerCommands(new GmCMD());
    }

    public FileConfiguration getTesConfig() {
        return this.tesConfig;
    }

    public void createScoreboardConfig() {
        testFile = new File(getDataFolder(), "test.yml");
        if (!testFile.exists()) {
            testFile.getParentFile().mkdirs();
            saveResource("test.yml", false);
        }
        tesConfig = new YamlConfiguration();
        try {
            tesConfig.load(testFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
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
}
