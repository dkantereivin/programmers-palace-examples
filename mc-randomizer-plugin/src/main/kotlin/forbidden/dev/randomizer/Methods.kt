package forbidden.dev.randomizer

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.CommandExecutor
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import kotlin.math.abs
import kotlin.random.Random

fun colorize(Message: String): String{
    return ChatColor.translateAlternateColorCodes('&', "&eRandomizer -> &9Me: &f$Message")
}

fun cPrint(Message: String){
    pluginServer.consoleSender.sendMessage(colorize(Message))
}

fun sendTo(Subject: Player, Message: String){
    Subject.sendMessage(colorize(Message))
}

fun randMaterial(): Material{
    val items = Material.values()
    val random = Random.nextInt(1, items.size)
    return if(plugin.config.getBoolean("Drops." + items[random].name)){
        items[random]
    }
    else {
        randMaterial()
    }
}
@Deprecated("Broken!", ReplaceWith(0.toString()))
fun randDurability(item: ItemStack): Int{
    return if (plugin.config.getBoolean("RandomDurability.${item.type.name}")){
        Random.nextInt(abs(item.type.maxDurability.toInt()) + 1)
    }
    else{
        0
    }
}

fun randAmount(material: Material): Int {
    return if (material.maxStackSize <= 1){1}else{Random.nextInt(1, material.maxStackSize)}
}

fun register(Object: Listener){
    pluginServer.pluginManager.registerEvents(Object, plugin)
}

fun setExecuter(Name: String, Object: CommandExecutor){
    plugin.getCommand(Name)?.setExecutor(Object)
}