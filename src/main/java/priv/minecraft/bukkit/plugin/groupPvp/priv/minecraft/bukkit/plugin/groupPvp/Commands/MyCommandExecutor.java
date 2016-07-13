package priv.minecraft.bukkit.plugin.groupPvp.priv.minecraft.bukkit.plugin.groupPvp.Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import priv.minecraft.bukkit.plugin.groupPvp.GroupPvp;

public class MyCommandExecutor implements CommandExecutor{
    private GroupPvp p;

    public MyCommandExecutor(GroupPvp p){
        this.p=p;

    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equals("gpr")){
            if(commandSender.hasPermission("grouppvp.reload")){
                p.reloadConfig();
            commandSender.sendMessage(p.getCfg().getReloadMsg());
                return true;
            }

        }
        return false;
    }


}
