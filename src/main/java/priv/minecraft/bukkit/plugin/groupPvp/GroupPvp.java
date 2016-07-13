package priv.minecraft.bukkit.plugin.groupPvp;


import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import priv.minecraft.bukkit.plugin.groupPvp.priv.minecraft.bukkit.plugin.groupPvp.Configuration.Config;

import java.util.HashMap;

/**
 * Created by yzh on 16-7-13.
 */
public class GroupPvp extends JavaPlugin  {
    public  static HashMap<String,String> messages;
    public static Permission perms = null;
    public  static Config cfg;
    public  static Plugin plugin;
    public  static Economy econ=null;
    private boolean setupPermissions() {
        perms = getServer().getServicesManager().getRegistration(Permission.class).getProvider();
        return perms != null;
    }
    private boolean setupEconomy() {
        econ = getServer().getServicesManager().getRegistration(Economy.class).getProvider();
        return econ!= null;
    }
    public static Permission getPerm(){
        return  perms;
    }
    public static HashMap<String,String> getMessages(){

        return messages;
    }
    public  static Config getCfg(){
        return cfg;

    }
    @Override
    public void onEnable(){
plugin=this;
saveDefaultConfig();
        setupPermissions();
        cfg=new Config(this);

    }
    public static Plugin getInstance(){

        return plugin;
    }
    @Override
    public void onDisable(){
        perms=null;
saveConfig();
    }
    public static Economy getEconomy(){
        return econ;

    }

}
