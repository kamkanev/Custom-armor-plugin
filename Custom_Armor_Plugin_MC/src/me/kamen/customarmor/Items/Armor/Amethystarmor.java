package me.kamen.customarmor.Items.Armor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.kamen.customarmor.Main;
import net.md_5.bungee.api.ChatColor;

public class Amethystarmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.LIGHT_PURPLE + "Amethyst";
	
	public static final int ID = 133012;
	public static final int HELMET_ID = 1330124;
	public static final int CHESTPLATE_ID = 1330126;
	public static final int LEGGINGS_ID = 1330121;
	public static final int BOOTS_ID = 1330128;
	
	
	public static void init(Main plugin) {
		
		createHelmet(plugin);
		createChestplate(plugin);
		createLeggings(plugin);
		createBoots(plugin);
		
	}
	
	private static void createHelmet(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Amethyst helmet");
		addLore(meta);
		meta.setCustomModelData(1330124); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "amethyst_helmet");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("CCC",
					  "C C");
		
		recipe1.setIngredient('C', Material.AMETHYST_SHARD);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Amethyst chestplate");
		addLore(meta);
		meta.setCustomModelData(1330126); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "amethyst_chestplate");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("C C",
					 "CCC",
					 "CCC");
		
		recipe.setIngredient('C', Material.AMETHYST_SHARD);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}
	
	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Amethyst leggings");
		addLore(meta);
		meta.setCustomModelData(1330121); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "amethyst_leggings");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("CCC",
					 "C C",
					 "C C");
		
		recipe.setIngredient('C', Material.AMETHYST_SHARD);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}

	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Amethyst boots");
		addLore(meta);
		meta.setCustomModelData(1330128); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addEnchantment(Enchantment.PROTECTION_FALL, 2);
		
		NamespacedKey key = new NamespacedKey(plugin, "amethyst_boots");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape(
					 "C C",
					 "C C");

		
		recipe1.setIngredient('C', Material.AMETHYST_SHARD);
		
		boots = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void addProtToItem(ItemStack item) {
		
		item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		item.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 2);
		item.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
		item.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
		
		
	}
	
	private static void addLore(ItemMeta meta) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("An armor crafted by the best armorers in the world.");
		lore.add("It's powerful enough to beat even Jean!");
		
		meta.setLore(lore);
		
		
	}

}
