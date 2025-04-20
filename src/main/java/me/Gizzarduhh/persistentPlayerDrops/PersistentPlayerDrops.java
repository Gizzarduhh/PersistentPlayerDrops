package me.Gizzarduhh.persistentPlayerDrops;

import me.Gizzarduhh.persistentPlayerDrops.listener.ItemDespawnListener;
import me.Gizzarduhh.persistentPlayerDrops.listener.ItemPickupListener;
import me.Gizzarduhh.persistentPlayerDrops.listener.PlayerDeathListener;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PersistentPlayerDrops extends JavaPlugin {

    public final NamespacedKey PERSISTENT_KEY = new NamespacedKey(this,"persistent");

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerListeners(getServer().getPluginManager());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners(PluginManager pluginManager) {
        pluginManager.registerEvents(new ItemDespawnListener(this), this);
        pluginManager.registerEvents(new ItemPickupListener(this), this);
        pluginManager.registerEvents(new PlayerDeathListener(this), this);
    }

    public boolean isPersistent(ItemStack itemStack) {
        return itemStack.getType() != Material.AIR && itemStack.getPersistentDataContainer().getOrDefault(PERSISTENT_KEY, PersistentDataType.BOOLEAN, false);
    }
}
