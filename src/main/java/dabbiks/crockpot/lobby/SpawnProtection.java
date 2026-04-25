package dabbiks.crockpot.lobby;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.*;

public class SpawnProtection implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        event.setCancelled(true);
        return;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;

        if (event.getClickedBlock() != null) {
            Material blockType = event.getClickedBlock().getType();
            String name = blockType.name();
            if (name.contains("BUTTON") || name.equals("LEVER") || name.contains("DOOR")) {
                return;
            }
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onHangingBreak(HangingBreakByEntityEvent event) {
        if (!(event.getRemover() instanceof Player player)) return;
        if (player.hasPermission("*")) return;
        if (!player.getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onOtherEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;
        if (player.hasPermission("*")) return;
        if (!player.getWorld().getName().equalsIgnoreCase("world")) return;
        if (event.getEntity() instanceof Player) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked().hasPermission("*")) return;
        if (!event.getWhoClicked().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if (event.getWhoClicked().hasPermission("*")) return;
        if (!event.getWhoClicked().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onBucketFill(PlayerBucketFillEvent event) {
        if (event.getPlayer().hasPermission("*")) return;
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onSaturationLose(FoodLevelChangeEvent event) {
        if (!event.getEntity().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent event) {
        if (!event.getPlayer().getWorld().getName().equalsIgnoreCase("world")) return;
        event.setCancelled(true);
        event.getItem().remove();
    }
}