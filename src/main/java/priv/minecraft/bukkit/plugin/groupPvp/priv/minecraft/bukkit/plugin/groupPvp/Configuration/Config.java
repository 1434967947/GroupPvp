package priv.minecraft.bukkit.plugin.groupPvp.priv.minecraft.bukkit.plugin.groupPvp.Configuration;


import com.sun.org.apache.xerces.internal.xs.StringList;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Created by yzh on 16-7-13.
 */
public class Config{
    private Configuration c;

    public Config(Plugin plugin){
        c=plugin.getConfig();
    }
    public String color(String string_to_translate){
        return ChatColor.translateAlternateColorCodes('&',string_to_translate);

    }
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
