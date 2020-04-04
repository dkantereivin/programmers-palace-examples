package forbidden.dev.randomizer

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object ToggleAll: CommandExecutor {

    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        if (p0 is Player){
            if (!p0.hasPermission("Randomizer.ToggleAll")){
                sendTo(p0, "&cYou Do Not have permissions to run this command.")
            }
            else{
                for (item in Material.values()){
                   if (plugin.config.getBoolean("Drops.${item.name}")){
                       plugin.config.set("Drops.${item.name}", false)
                   }
                   else{
                       plugin.config.set("Drops.${item.name}", true)
                   }
                }
                plugin.saveConfig()
                sendTo(p0, "&aSuccessfully Toggled all items.")
                sendTo(p0, "&aUse &9'/Randomizer' &ato reload config")
            }
        }else{
            for (item in Material.values()){
                if (plugin.config.getBoolean("Drops.${item.name}")){
                    plugin.config.set("Drops.${item.name}", false)
                }
                else{
                    plugin.config.set("Drops.${item.name}", true)
                }
            }
            plugin.saveConfig()
            cPrint("&aSuccessfully Toggled all items.")
            cPrint("&aUse &9'/Randomizer' &ato reload config")
        }
        return true
    }

}