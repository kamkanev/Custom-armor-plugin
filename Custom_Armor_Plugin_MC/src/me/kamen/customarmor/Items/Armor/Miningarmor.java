package me.kamen.customarmor.Items.Armor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.kamen.customarmor.Main;
import net.md_5.bungee.api.ChatColor;

public class Miningarmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.DARK_GRAY + "Mining";
	
	public static final int ID = 133021;
	public static final int HELMET_ID = 1330214;
	public static final int CHESTPLATE_ID = 1330216;
	public static final int LEGGINGS_ID = 1330211;
	public static final int BOOTS_ID = 1330218;
	
	
	public static void init(Main plugin) {
		
		createHelmet(plugin);
		createChestplate(plugin);
		createLeggings(plugin);
		createBoots(plugin);
		
	}
	
	private static void createHelmet(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " helmet");
		addLore(meta);
		meta.setCustomModelData(HELMET_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addEnchantment(Enchantment.DURABILITY, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "mining_helmet");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("CCC",
					  "CSC");
		
		recipe1.setIngredient('C', Material.IRON_INGOT);
		recipe1.setIngredient('S', Material.GLASS);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " chestplate");
		addLore(meta);
		meta.setCustomModelData(CHESTPLATE_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addEnchantment(Enchantment.THORNS, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "mining_chestplate");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("IS");
		
		recipe.setIngredient('S', Material.SHIELD);
		recipe.setIngredient('I', Material.IRON_CHESTPLATE);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}
	
	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " leggings");
		addLore(meta);
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier("Mleggingmodi", 2, AttributeModifier.Operation.ADD_NUMBER));
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("Mleggingmodi2", 5, AttributeModifier.Operation.ADD_NUMBER));
		meta.setCustomModelData(LEGGINGS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "mining_leggings");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("IS");
		
		recipe.setIngredient('S', Material.SHIELD);
		recipe.setIngredient('I', Material.IRON_LEGGINGS);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}

	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " boots");
		addLore(meta);
		meta.setCustomModelData(BOOTS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
		item.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
		
		NamespacedKey key = new NamespacedKey(plugin, "mining_boots");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("IS");
		
		recipe1.setIngredient('S', Material.WATER_BUCKET);
		recipe1.setIngredient('I', Material.IRON_BOOTS);
		
		boots = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void addProtToItem(ItemStack item) {
		
		item.addEnchantment(Enchantment.MENDING, 1);
		
		
	}
	
	private static void addLore(ItemMeta meta) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("An armor crafted for mining in the depth of the world!");
		
		meta.setLore(lore);
		
		
	}

}
