package me.kamen.customarmor.Items.Armor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.kamen.customarmor.Main;
import net.md_5.bungee.api.ChatColor;

public class Blazearmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.GOLD + "" + ChatColor.BOLD + "Blaze";
	
	public static final int ID = 133071;
	public static final int HELMET_ID = 1330714;
	public static final int CHESTPLATE_ID = 1330716;
	public static final int LEGGINGS_ID = 1330711;
	public static final int BOOTS_ID = 1330718;
	
	public static void init(Main plugin) {
		
		createHelmet(plugin);
		createChestplate(plugin);
		createLeggings(plugin);
		createBoots(plugin);
		
	}

	private static void createHelmet(Main plugin) {
		
		ItemStack item = new ItemStack(Material.GOLDEN_HELMET);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Blaze helmet");
		meta.setCustomModelData(1330714); //1130 - armor
		addLore(meta, "Lava no problem!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		
		item.addEnchantment(Enchantment.DURABILITY, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "blaze_helmet");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GB");
		
		recipe.setIngredient('G', Material.GOLDEN_HELMET);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe);
		
	}

	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.GOLDEN_CHESTPLATE);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Blaze chestplate");
		meta.setCustomModelData(1330716); //1130 - armor
		addLore(meta, "Power of turn the odds!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		
		item.addEnchantment(Enchantment.DURABILITY, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "blaze_chestplate");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GB");
		
		recipe.setIngredient('G', Material.GOLDEN_CHESTPLATE);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe);
		
	}

	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.GOLDEN_LEGGINGS);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Blaze Leggings");
		meta.setCustomModelData(1330711); //1130 - armor
		addLore(meta, "These leggings give you the ability to never to worry about falling!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		
		item.addEnchantment(Enchantment.DURABILITY, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "blaze_leggings");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GB");
		
		recipe.setIngredient('G', Material.GOLDEN_LEGGINGS);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe);
		
	}

	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Blaze Boots");
		meta.setCustomModelData(1330718); //1130 - armor
		addLore(meta, "I pity those below me!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		item.setItemMeta(meta);
		
		item.addEnchantment(Enchantment.DURABILITY, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "blaze_boots");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GB");
		
		recipe.setIngredient('G', Material.GOLDEN_BOOTS);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		
		boots = item;
		
		Bukkit.addRecipe(recipe);
		
	}
	
private static void addLore(ItemMeta meta, String custom) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("The power of the blaze in nice beautiful armor!");
		lore.add(ChatColor.GOLD + custom);
		lore.add(ChatColor.BLUE + "Full armor: The Nether gives you regeneration,");
		lore.add(ChatColor.BLUE + " and when on fire the armor gives you the power of destruction.");
		
		
		meta.setLore(lore);
		
		
	}

}
