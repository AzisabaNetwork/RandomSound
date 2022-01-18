package com.github.sirokuri_.randomsound.listener;

import com.github.sirokuri_.randomsound.RandomSound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class RandomSoundInteract implements Listener {

    private final RandomSound plugin;

    public RandomSoundInteract(RandomSound randomSound) {
        this.plugin = randomSound;
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if(block == null) return;
        Sound sound = plugin.getRandomSound();
        Location location = player.getLocation();
        if ((event.getHand() != EquipmentSlot.HAND || event.getAction() == Action.LEFT_CLICK_AIR)) return;
        player.playSound(location,sound,10,1);
    }
}