package me.kamen.customarmor.Items.Armor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.kamen.customarmor.Main;
import net.md_5.bungee.api.ChatColor;

public class NoobArmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.GREEN + "Noob";
	
	public static final int ID = 133040;
	public static final int HELMET_ID = 1330404;
	public static final int CHESTPLATE_ID = 1330406;
	public static final int LEGGINGS_ID = 1330401;
	public static final int BOOTS_ID = 1330408;
	
	
	public static void init(Main plugin) {
		
		createHelmet(plugin);
		createChestplate(plugin);
		createLeggings(plugin);
		createBoots(plugin);
		
	}
	
	private static void createHelmet(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME + " helmet");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("Nhelmetmodifier", 2, Operation.ADD_NUMBER));
		meta.setColor(Color.LIME);
		addLore(meta);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(HELMET_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "noob_helmet");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("LLL",
					  "L L");
		
		recipe1.setIngredient('L', Material.OAK_LEAVES);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	

	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME+" chestplate");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("Nchestmodifier", 6, Operation.ADD_NUMBER));
		meta.setColor(Color.LIME);
		addLore(meta);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(CHESTPLATE_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "noob_chestplate");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("L L",
					  "LLL",
					  "LLL");
		
		recipe1.setIngredient('L', Material.OAK_LEAVES);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME+" leggings");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("Nleggsmodifier", 5, Operation.ADD_NUMBER));
		meta.setColor(Color.LIME);
		addLore(meta);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(LEGGINGS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "noob_leggings");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("LLL",
					  "L L",
					  "L L");
		
		recipe1.setIngredient('L', Material.OAK_LEAVES);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME+" boots");
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("Nbootsmodifier", 2, Operation.ADD_NUMBER));
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier("Nbootsmodifier2", 0.1, Operation.ADD_NUMBER));
		meta.setColor(Color.LIME);
		addLore(meta);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(BOOTS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "noob_boots");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("L L",
					  "L L");
		
		recipe1.setIngredient('L', Material.OAK_LEAVES);
		
		boots = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void addProtToItem(ItemStack item) {
		
		item.addEnchantment(Enchantment.VANISHING_CURSE, 1);
		
	}
	
private static void addLore(ItemMeta meta) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("The power of the gods is useless for the mortals.");
		lore.add(ChatColor.BLUE + "Full armor: Gives you regeneration");
		
		
		meta.setLore(lore);
		
		
	}

}
