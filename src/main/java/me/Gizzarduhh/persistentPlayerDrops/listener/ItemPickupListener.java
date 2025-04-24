package me.Gizzarduhh.persistentPlayerDrops.listener;

import me.Gizzarduhh.persistentPlayerDrops.PersistentPlayerDrops;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemPickupListener implements Listener {

    private final PersistentPlayerDrops plugin;

    public ItemPickupListener(PersistentPlayerDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if (plugin.isPersistent(e.getItem().getItemStack())) {
            e.getItem().getItemStack().editPersistentDataContainer(pdc -> pdc.remove(plugin.PERSISTENT_KEY));
        }
    }
}
