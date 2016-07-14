package priv.minecraft.bukkit.plugin.groupPvp.priv.minecraft.bukkit.plugin.groupPvp.Configuration;


import com.sun.org.apache.xerces.internal.xs.StringList;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;

import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Created by yzh on 16-7-13.
 */
public class Config{

private Configuration c;
    public Config(Plugin plugin) {

        try {
            c = YamlConfiguration.loadConfiguration(new InputStreamReader(new DataInputStream(new BufferedInputStream(new FileInputStream(new File(plugin.getDataFolder(), "config.yml")))), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            plugin.saveDefaultConfig();

        }
    }
    public String color(String string_to_translate){
        return ChatColor.translateAlternateColorCodes('&',string_to_translate);

    }
    public String getReloadMsg(){return  color((c.getString("PluginReload")));}
    public String getNoPermMsg(){return  color((c.getString("NotEnoughPermission")));}
    public String getAttackMsg(){
       return  color(c.getString("messageAttack"));
    }
    public String getDeathMsg(){
        return  color(c.getString("messageDeath"));
    }
    public Boolean isGroup(){
        return c.getBoolean("Group");
    }
    public List<String> getGroups(){
        return c.getStringList("Groups");
    }
    public List<String> getPerms(){
        return c.getStringList("Permission");
    }

}
