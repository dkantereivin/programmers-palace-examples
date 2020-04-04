package forbidden.dev.randomizer

import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerFishEvent
import org.bukkit.inventory.ItemStack

object Fishing: Listener {

    @EventHandler
    fun onFish(event: PlayerFishEvent){
        val player = event.player
        if (event.state == PlayerFishEvent.State.CAUGHT_FISH){
            val worldName = player.world.name
            val loc = event.player.location
            if (player.gameMode != GameMode.SURVIVAL) return
            if (plugin.config.getBoolean("EnabledWorlds.$worldName") && player.gameMode == GameMode.SURVIVAL){
                val material = randMaterial()
                val item = ItemStack(material, randAmount(material))
                if (!plugin.config.getBoolean("Drops.${item.type.name}")) return
                if (item.type != Material.AIR && !item.isSimilar(ItemStack(Material.AIR, randAmount(material)))) {player.world.dropItem(loc, item)}
            }
        }
    }

}