package forbidden.dev.randomizer

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

object Blocks: Listener {

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent){
        val player = event.player
        val worldName = player.world.name
        val loc = event.block.location
        if (player.gameMode != GameMode.SURVIVAL) return
        if (plugin.config.getBoolean("EnabledWorlds.$worldName")){
            event.isCancelled=true
            event.block.type = Material.AIR
            val material = randMaterial()
            val amount = randAmount(material)
            if (material != Material.AIR && amount > 0) {val item = ItemStack(material, amount)
            if (!plugin.config.getBoolean("Drops.${item.type.name}")) return
            if (item.type != Material.AIR && item.amount != 0 && item.maxStackSize != 0) {try {
                player.world.dropItem(loc, item)
            }catch (e: Throwable){
                cPrint("&eTried to drop air")
            }

            }

            }

        }
    }
}
