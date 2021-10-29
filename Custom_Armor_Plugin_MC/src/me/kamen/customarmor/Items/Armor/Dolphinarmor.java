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
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.kamen.customarmor.Main;
import net.md_5.bungee.api.ChatColor;

public class Dolphinarmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.AQUA + "" + ChatColor.BOLD + "Dolphin";
	
	public static final int ID = 133000;
	public static final int HELMET_ID = 1330004;
	public static final int CHESTPLATE_ID = 1330006;
	public static final int LEGGINGS_ID = 1330001;
	public static final int BOOTS_ID = 1330008;
	
	
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
		meta.setColor(Color.AQUA);
		addLore(meta, "How deep can you go?");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(HELMET_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "dolphin_helmet");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("LLL",
					  "L L");
		
		recipe1.setIngredient('L', Material.KELP);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	

	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME+" chestplate");
		meta.setColor(Color.AQUA);
		addLore(meta, "The sea can be dangerous!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(CHESTPLATE_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		
		NamespacedKey key = new NamespacedKey(plugin, "dolphin_chestplate");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("L L",
					  "LLL",
					  "LLL");
		
		recipe1.setIngredient('L', Material.KELP);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME+" leggings");
		meta.setColor(Color.AQUA);
		addLore(meta, "Jump like a dolphin!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(LEGGINGS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "dolphin_leggings");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("LLL",
					  "L L",
					  "L L");
		
		recipe1.setIngredient('L', Material.KELP);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
		
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName(NAME+" boots");
		meta.setColor(Color.AQUA);
		addLore(meta, "Swim like a pro!");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setCustomModelData(BOOTS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, "dolphin_boots");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("L L",
					  "L L");
		
		recipe1.setIngredient('L', Material.KELP);
		
		boots = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void addProtToItem(ItemStack item) {
		
		item.addEnchantment(Enchantment.DURABILITY, 3);
		
	}
	
private static void addLore(ItemMeta meta, String custom) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("A gift by the god of the seas Poseidon");
		lore.add(ChatColor.AQUA + custom);
		lore.add(ChatColor.BLUE + "Full armor: Gives you the power of the sea!");
		
		
		meta.setLore(lore);
		
		
	}

}
