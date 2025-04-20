package me.Gizzarduhh.persistentPlayerDrops.listener;

import me.Gizzarduhh.persistentPlayerDrops.PersistentPlayerDrops;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerDeathListener implements Listener {

    private final PersistentPlayerDrops plugin;

    public PlayerDeathListener(PersistentPlayerDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.getDrops().forEach(itemStack -> itemStack.editPersistentDataContainer((pdc -> {
            pdc.set(plugin.PERSISTENT_KEY, PersistentDataType.BOOLEAN, true);
        })));
    }
}