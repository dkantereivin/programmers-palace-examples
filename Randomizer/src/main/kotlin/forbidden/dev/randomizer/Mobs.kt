package forbidden.dev.randomizer

import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent

object Mobs: Listener {

    @EventHandler
    fun onMobDeath(event: EntityDeathEvent){
        val killer = event.entity.killer
        if (killer is Player){
            val worldName = killer.world.name
            if (killer.gameMode != GameMode.SURVIVAL) return
            if (plugin.config.getBoolean("EnabledWorlds.$worldName") && killer.gameMode == GameMode.SURVIVAL){
                val material = randMaterial()
                for (item in event.drops){
                    item.type = material
                    item.amount = randAmount(material)
                }
            }
        }
    }
}