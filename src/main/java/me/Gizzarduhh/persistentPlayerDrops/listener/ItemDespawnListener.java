package me.Gizzarduhh.persistentPlayerDrops.listener;

import me.Gizzarduhh.persistentPlayerDrops.PersistentPlayerDrops;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public class ItemDespawnListener implements Listener {

    private final PersistentPlayerDrops plugin;

    public ItemDespawnListener(PersistentPlayerDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemDespawn(ItemDespawnEvent e) {
        if (plugin.isPersistent(e.getEntity().getItemStack())) e.setCancelled(true);
    }
}
