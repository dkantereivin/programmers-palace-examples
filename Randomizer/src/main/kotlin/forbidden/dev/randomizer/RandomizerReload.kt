package forbidden.dev.randomizer

import forbidden.dev.randomizer.cPrint
import forbidden.dev.randomizer.plugin
import forbidden.dev.randomizer.sendTo
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object RandomizerReload: CommandExecutor {

    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        if (p0 is Player){
            if (!p0.hasPermission("Randomizer.Reload")){
                sendTo(p0, "&cYou Do Not have permissions to run this command.")
            }
            else{
                sendTo(p0, "&cReloading Config.. Please wait.")
                plugin.reloadConfig()
                sendTo(p0, "&cConfig Successfully reloaded.")
            }
        }else{
            cPrint("&cReloading Config.. Please wait.")
            plugin.reloadConfig()
            cPrint("&cConfig Successfully reloaded.")

        }
        return true
    }


}