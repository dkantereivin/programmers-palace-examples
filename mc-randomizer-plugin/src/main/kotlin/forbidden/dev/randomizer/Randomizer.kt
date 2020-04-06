package forbidden.dev.randomizer

import org.bukkit.Material
import org.bukkit.entity.Fish
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.Damageable
import org.bukkit.plugin.java.JavaPlugin

class Randomizer: JavaPlugin() {

    companion object{
        var instance: Randomizer? = null
        private set
    }

    override fun onEnable() {
        super.onEnable()
        instance=this
        cPrint("&aPlugin Starting...")
        // Register Events
        register(Blocks)
        register(Mobs)
        register(Fishing)
        // Register Commands
        setExecuter("Randomizer", RandomizerReload)
        setExecuter("ToggleAll", ToggleAll)
        // Required Methods
        setUpConfig()
        saveConfig()
        // End
        cPrint("&a&lPlugin Enabled!")
    }

    override fun onDisable() {
        super.onDisable()
        cPrint("&cPlugin Disabled!")
    }

    private fun setUpConfig() {
        saveDefaultConfig()
        for (world in pluginServer.worlds) {
            if (!config.contains("EnabledWorlds.${world.name}")) {
                config.set("EnabledWorlds.${world.name}", true)
            }
        }
        for (item in Material.values()) {
            if (!config.contains("Drops.${item.name}") && ItemStack(item).itemMeta is Damageable) {
                config.set("Drops.${item.name}", true)
            }
        }
    }

}