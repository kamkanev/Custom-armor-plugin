package me.kamen.customarmor.Listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World.Environment;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Dolphin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.kamen.customarmor.Main;
import me.kamen.customarmor.ArmorEvent.ArmorEquipEvent;
import me.kamen.customarmor.Items.Armor.Blazearmor;
import me.kamen.customarmor.Items.Armor.CopperArmor;
import me.kamen.customarmor.Items.Armor.Dolphinarmor;
import me.kamen.customarmor.Items.Armor.Godarmor;
import me.kamen.customarmor.Items.Armor.Miningarmor;
import me.kamen.customarmor.Items.Armor.NoobArmor;

public class ArmorListenervent implements Listener{
	
	private Main plugin;
	private HashMap<UUID, Integer> fallingPlayers = new HashMap<UUID, Integer>();
	
	public ArmorListenervent(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
		
		runnable();
	}
	
	private void runnable() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			boolean[] areEffectsGiven = new boolean[] {false, false, false, false, false };
			
			@Override
			public void run() {
				
				
			for(Player p : Bukkit.getOnlinePlayers()) {
				
				
//				ItemStack helm = p.getInventory().getHelmet();
//				ItemStack chest = p.getInventory().getChestplate();
//				ItemStack leggs = p.getInventory().getLeggings();
//				ItemStack boots = p.getInventory().getBoots();
				
				short c = 0;
				int oldarrmorId = -1;
				for(ItemStack piece : p.getInventory().getArmorContents()) {
					
					if(piece != null) {
						
						ItemMeta meta = piece.getItemMeta();
						
						if(meta.hasCustomModelData()) {
							
							int arrmorId = meta.getCustomModelData()/10;
							
							if(oldarrmorId == -1) {
								oldarrmorId = arrmorId;
							}else if(oldarrmorId != arrmorId) {
								
								c = 0;
								
							}
							
							String pieceType = piece.getType().name().split("_")[1];
							
							if(pieceType.equals("HELMET")) {
								
								c++;
								
								switch (arrmorId) {
								case Blazearmor.ID:
										p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0));
										
									break;
									
								case Dolphinarmor.ID:
									p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100, 0));
									break;
									
								case Godarmor.ID:
									p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100, 0));
									p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 0));
									break;

								default:
									break;
								}
								
							}else if(pieceType.equals("CHESTPLATE")) {
								
								c++;
								
								switch (arrmorId) {
								case Blazearmor.ID:
										p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));

									break;
									
								case Miningarmor.ID:
									
									if(p.getLocation().getBlockY() < p.getLocation().getWorld().getHighestBlockYAt(p.getLocation())) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1));
									}
									
									
									break;
									
								case Godarmor.ID:
									p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 4));
									p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 4));
									p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 9));
									p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 2));
									p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 9));
									break;

								default:
									break;
								}
								
							}else if(pieceType.equals("LEGGINGS")) {
								
								c++;
								
								switch (arrmorId) {
								case Blazearmor.ID:
										p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 2));

									break;
									
								case Dolphinarmor.ID:
									p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 1));
									break;
									
								case Godarmor.ID:
									p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 1));
									break;

								default:
									break;
								}
								
							}if(pieceType.equals("BOOTS")) {
								
								c++;
								
								switch (arrmorId) {
								case Blazearmor.ID:
									if(p.isSneaking()) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 0));
									}else {
										p.removePotionEffect(PotionEffectType.LEVITATION);
									}

									break;

								default:
									break;
								}
								
							}
							
							if(c == 4) {
								
								switch (arrmorId) {
								case Blazearmor.ID:
									
									if(p.getFireTicks() > 0) {
										
										p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 1));
										
									}
									
									if(p.getWorld().getEnvironment().equals(Environment.NETHER)) {
										
										p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
										
									}

									break;
									
								case NoobArmor.ID:
									
									p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
									
									break;
									
								case Dolphinarmor.ID:
									
									p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 100, 0));
									
									if(p.isInWater()) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0));
										p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
									}
									
									break;
									
								case Miningarmor.ID:
									
									p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100, 0));
									
									if(p.getLocation().getBlockY() < p.getLocation().getWorld().getHighestBlockYAt(p.getLocation())) {
										p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100, 2));
										p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 1));
									}
									
									
									break;
									
								case Godarmor.ID:
									
									p.removePotionEffect(PotionEffectType.BLINDNESS);
									p.removePotionEffect(PotionEffectType.SLOW);
									
									break;
									
								case CopperArmor.ID:
									
									for(PotionEffect po : CopperArmor.EFFECTS) {
										
										if(!p.hasPotionEffect(po.getType())) {
											
											p.addPotionEffect(po);
											
										}
										
									}
									
									break;

								default:
									break;
								}
								
							}
							
						}
						
					}
					
				}
				
				
			}
				
			}
		}, 0L, 20);
		
	}
	
	@EventHandler
	public void onArmorWear(ArmorEquipEvent e) {
		
		
		
		if(e.getNewArmorPiece() != null) {
			
			ItemMeta arr = e.getNewArmorPiece().getItemMeta();
			
			if(!e.getNewArmorPiece().getType().isAir() && arr.hasCustomModelData()) {
				
				if(arr.getCustomModelData() == Miningarmor.HELMET_ID) {

					Player p = e.getPlayer();
					
					p.setResourcePack("https://www.dropbox.com/s/09ljxpyl80gmhek/Xray_Ultimate_1.17_v4.1.2.zip?dl=1");
				
				}
				
				if(arr.getCustomModelData() == Godarmor.BOOTS_ID) {
					
					Player p = e.getPlayer();
					
					p.setAllowFlight(true);
					
				}
				
			}
			
		}else if(e.getOldArmorPiece() != null) {
			
			ItemMeta arr = e.getOldArmorPiece().getItemMeta();
			
			if(arr.hasCustomModelData()) {
				
				if(arr.getCustomModelData() == Miningarmor.HELMET_ID) {

					Player p = e.getPlayer();
					
					p.setResourcePack("https://www.dropbox.com/s/oq5d2zhpltip56o/VanillaTweaks_r311532.zip?dl=1");
				
				}
				
				if(arr.getCustomModelData() == Godarmor.BOOTS_ID) {
					
					Player p = e.getPlayer();
					
					p.setAllowFlight(false);
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void Move (PlayerMoveEvent event) {
		
	    HashSet<Material> transparent = new HashSet<Material>();
	    Player p = event.getPlayer();
	   if(p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getItemMeta().hasCustomModelData()) {
		   
		   if(p.getInventory().getLeggings().getItemMeta().getCustomModelData() == Godarmor.LEGGINGS_ID) {
			   
//			   Block block = p.getTargetBlock(transparent, 3);
//			    transparent.addAll(Arrays.asList(Material.values()));
//			    Location loc = block.getLocation().add(0, -1, 0);
//			    Vector x = loc.toVector();
//			    Vector pl = p.getLocation().toVector();
//			    x.subtract(pl);
//			    x.multiply(-1D);
//			    Location finalLoc = p.getLocation().add(x);
//			    finalLoc.getBlock().setType(Material.FIRE);
			   if(ensureFromIsDifferentToTo(event.getFrom(), event.getTo())) {
				   Block fr = event.getFrom().getBlock();
				   if(fr.getType().equals(Material.AIR)) {
					   
					   event.getFrom().getBlock().setType(Material.FIRE);
					   
				   }
				   
			   }
			   //System.out.println(event.getFrom().getBlock().getType());
			   
		   }
		   
	   }
	}
	
	public boolean ensureFromIsDifferentToTo(Location from, Location to) {
        if (!(from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == to.getBlockZ())) {
            return true;
        }
        else {
            return false;
        }
    }
	
    @EventHandler
    public void setFlyOnJump(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
       
        if(event.isFlying() && event.getPlayer().getGameMode() != GameMode.CREATIVE) {
           
            player.setFlying(false);
            Vector jump = player.getLocation().getDirection().multiply(0.2).setY(1.1);
            player.setVelocity(player.getVelocity().add(jump));
           
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void setStomp(PlayerMoveEvent e) {
    	
    	Player p = e.getPlayer();
    	
    	if(p.getVelocity().getY() < 0 && e.getFrom().getBlockY() > e.getTo().getBlockY() && !p.isSwimming() && !p.isFlying()) {
    		
    		if(p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().hasCustomModelData()) {
    			
    			if(p.getInventory().getBoots().getItemMeta().getCustomModelData() == Godarmor.BOOTS_ID && p.isSneaking()) {
    				
    				Vector fall = p.getLocation().getDirection().multiply(0.5).setY(-2.2);
    				
    				p.setVelocity(fall);
    				
    				if(!this.fallingPlayers.containsKey(p.getUniqueId())) {
    					this.fallingPlayers.put(p.getUniqueId(), 0);
    				}
    				
    				Material bmat = e.getTo().getBlock().getType().name().contains("AIR") ? e.getTo().clone().subtract(0, 1, 0).getBlock().getType() : e.getTo().getBlock().getType();
    				int fallingBlocks = 0;
    				
    				if(bmat.equals(Material.AIR)) {
    					fallingBlocks = this.fallingPlayers.get(p.getUniqueId()) + (e.getFrom().getBlockY() - e.getTo().getBlockY());
    				}else {
    					
    					for(Entity en : p.getNearbyEntities(3, 3, 3)) {
    						
    						if(en instanceof LivingEntity){
    							
    							((LivingEntity) en).damage(this.fallingPlayers.get(p.getUniqueId()) + (e.getFrom().getBlockY() - e.getTo().getBlockY())*2);
    							
    						}
    						
    						
    					}
    					this.fallingPlayers.put(p.getUniqueId(), 0);
    					}
    				
    				
    			}
    			
    		}
    		
    	}
    	
    }

}
