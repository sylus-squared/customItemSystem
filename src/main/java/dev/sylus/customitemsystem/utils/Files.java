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
        this.main = mainInstance;
       // saveDefultConfig(fileName); // The file name is the name of the YAML file that will be worked with
        // I am doing it like this, so I can re-use this code in future projects
        // without having to change a thing
    }

    public void reloadConfig(String fileName){
        if (this.configFile == null){
            this.configFile = new File(main.getDataFolder(), fileName);
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
        InputStream defaultStream = this.main.getResource(fileName);

        if (defaultStream != null){
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        } else {
            Bukkit.getLogger().log(Level.SEVERE, "File: " + fileName + " is NULL");
        }
    }

    public FileConfiguration getConfig(String fileName){
        if (dataConfig == null){
            reloadConfig(fileName);
        }
        return this.dataConfig;
    }

    public void saveConfig(String fileName){
        if (this.dataConfig == null || this.configFile == null){
            return;
        }
        try {
            this.getConfig(fileName).save(this.configFile);
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
