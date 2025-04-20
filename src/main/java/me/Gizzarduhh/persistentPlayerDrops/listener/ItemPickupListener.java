package me.Gizzarduhh.persistentPlayerDrops.listener;

import me.Gizzarduhh.persistentPlayerDrops.PersistentPlayerDrops;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.persistence.PersistentDataType;

public class ItemPickupListener implements Listener {

    private final PersistentPlayerDrops plugin;

    public ItemPickupListener(PersistentPlayerDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPickup(EntityPickupItemEvent e) {
        if (plugin.isPersistent(e.getItem().getItemStack())) {
            e.getItem().getItemStack().editPersistentDataContainer(pdc -> {
               pdc.set(plugin.PERSISTENT_KEY, PersistentDataType.BOOLEAN, false);
            });
        }
    }
}
