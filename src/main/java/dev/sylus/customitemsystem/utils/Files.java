package dev.sylus.customitemsystem.utils;

import dev.sylus.customitemsystem.CustomItemSystem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class Files {

    private FileConfiguration dataConfig = null;
    private File configFile = null;
    private CustomItemSystem main;

    public Files(CustomItemSystem mainInstance, String fileName){ // Constructor
        main = mainInstance;
        saveDefultConfig(fileName); // The file name is the name of the YAML file that will be worked with
        // I am doing it like this, so I can re-use this code in future projects
        // without having to change a thing
    }

    public void reloadConfig(String fileName){
        if (configFile == null){
            configFile = new File(main.getDataFolder(), fileName);
        }
        dataConfig = YamlConfiguration.loadConfiguration(configFile);
        InputStream defaultStream = main.getResource(fileName);

        try {
            if (!(configFile.exists())){
                configFile.createNewFile();
                Bukkit.getLogger().log(Level.WARNING, "Had to create file: " + fileName);
            }
        } catch (IOException exception) {
            Bukkit.getLogger().log(Level.SEVERE, "Error creating file: " + fileName);
        }

        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            dataConfig.setDefaults(defaultConfig);
        } else {
            Bukkit.getLogger().log(Level.SEVERE, "File: " + fileName + " is NULL");
        }
    }

    public FileConfiguration getConfig(String fileName){
        if (dataConfig == null){
            reloadConfig(fileName);
        }
        return dataConfig;
    }

    public void saveConfig(String fileName){
        if (dataConfig == null || configFile == null){
            return;
        }
        try {
            getConfig(fileName).save(configFile);
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save config for: " + fileName + " Stack trace: " + e);
        }
    }

    public void saveDefultConfig(String fileName){
        if (configFile == null){
            configFile = new File(main.getDataFolder(), fileName);
        }
        if (!(configFile.exists())){
            main.saveResource(fileName, false);
        }
    }
}
