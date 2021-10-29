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

public class Godarmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.DARK_RED + "" + ChatColor.BOLD + "God";
	
	public static final int ID = 133099;
	public static final int HELMET_ID = 1330994;
	public static final int CHESTPLATE_ID = 1330996;
	public static final int LEGGINGS_ID = 1330991;
	public static final int BOOTS_ID = 1330998;
	
	
	public static void init(Main plugin) {
		
		createHelmet(plugin);
		createChestplate(plugin);
		createLeggings(plugin);
		createBoots(plugin);
		
	}
	
	private static void createHelmet(Main plugin) {
		
		ItemStack item = new ItemStack(Material.NETHERITE_HELMET, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " helmet");
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("Ghelmmodi", 3, AttributeModifier.Operation.ADD_NUMBER));
		addLore(meta);
		meta.setCustomModelData(HELMET_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.OXYGEN, 10);
		
		NamespacedKey key = new NamespacedKey(plugin, "god_helmet");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("CS");
		
		recipe1.setIngredient('C', Material.DIAMOND_HELMET);
		recipe1.setIngredient('S', Material.GOLDEN_CARROT);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " chestplate");
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("Gchestmodi", 3, AttributeModifier.Operation.ADD_NUMBER));
		addLore(meta);
		meta.setCustomModelData(CHESTPLATE_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.THORNS, 10);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 10);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 10);
		
		NamespacedKey key = new NamespacedKey(plugin, "god_chestplate");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("IS");
		
		recipe.setIngredient('S', Material.SHIELD);
		recipe.setIngredient('I', Material.DIAMOND_CHESTPLATE);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}
	
	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " leggings");
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier("Gleggingmodi", 0.3, AttributeModifier.Operation.ADD_NUMBER));
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("Gleggingmodi2", 3, AttributeModifier.Operation.ADD_NUMBER));
		addLore(meta);
		meta.setCustomModelData(LEGGINGS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		
		NamespacedKey key = new NamespacedKey(plugin, "god_leggings");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("IS");
		
		recipe.setIngredient('S', Material.BLAZE_POWDER);
		recipe.setIngredient('I', Material.DIAMOND_LEGGINGS);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}

	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME + " boots");
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("Gbootsmodi", 3, AttributeModifier.Operation.ADD_NUMBER));
		addLore(meta);
		meta.setCustomModelData(BOOTS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 10);
		item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 10);
		
		NamespacedKey key = new NamespacedKey(plugin, "god_boots");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("IS");
		
		recipe1.setIngredient('S', Material.WATER_BUCKET);
		recipe1.setIngredient('I', Material.DIAMOND_BOOTS);
		
		boots = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void addProtToItem(ItemStack item) {
		
		item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
		item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		item.addEnchantment(Enchantment.MENDING, 1);
		
		
	}
	
	private static void addLore(ItemMeta meta) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("A gift from the GODS!!!");
		
		meta.setLore(lore);
		
		
	}

}
