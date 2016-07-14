package priv.minecraft.bukkit.plugin.groupPvp.priv.minecraft.bukkit.plugin.groupPvp.Listeners;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import priv.minecraft.bukkit.plugin.groupPvp.GroupPvp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by yzh on 16-7-13.
 */
public class PlayerAttackListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerAttack(EntityDamageByEntityEvent e){

        if(e.getDamager() instanceof Player &&e.getEntity() instanceof Player){
            final Permission perms= GroupPvp.getPerm();
            final Player dr,en;
            dr=(Player)e.getDamager();
            en=(Player)e.getEntity();
            final Boolean[] cancel = {false};
if(GroupPvp.getCfg().isGroup()){
    new BukkitRunnable(){
        @Override
        public void run() {
            List<String> drGroups= Arrays.asList( perms.getPlayerGroups(dr));
            List enGroups=Arrays.asList(perms.getPlayerGroups(en));
            List<String> noPvpGroups=GroupPvp.getCfg().getGroups();
            for (String g:noPvpGroups)
                if (drGroups.contains(g) && enGroups.contains(g)) {
                    cancel[0] = true;

                    break;

                }
        }
    }.runTask(GroupPvp.getInstance());
}else{

    new BukkitRunnable(){
        @Override
        public void run() {
            for(String temp:GroupPvp.getCfg().getPerms()){
                if(dr.hasPermission(temp)&&en.hasPermission(temp)){
                    cancel[0]=true;
                    break;

                }

            }
        }
    }.runTask(GroupPvp.getInstance());
}

                e.setCancelled(cancel[0]);
                dr.sendMessage(GroupPvp.getCfg().getAttackMsg());

        }

    }
}
