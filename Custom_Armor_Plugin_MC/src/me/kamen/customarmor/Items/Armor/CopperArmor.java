package me.kamen.customarmor.Items.Armor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.kamen.customarmor.Main;
import net.md_5.bungee.api.ChatColor;

public class CopperArmor {
	
	private static ItemStack helmet;
	private static ItemStack chestplate;
	private static ItemStack leggings;
	private static ItemStack boots;
	
	public static final String NAME = ChatColor.WHITE + "" + ChatColor.BOLD + "COPPER";
	
	public static final int ID = 133090;
	public static final int HELMET_ID = 1330904;
	public static final int CHESTPLATE_ID = 1330906;
	public static final int LEGGINGS_ID = 1330901;
	public static final int BOOTS_ID = 1330908;
	
	public static List<PotionEffect> EFFECTS = new ArrayList<PotionEffect>();
	
	
	public static void init(Main plugin) {
		
		createHelmet(plugin);
		createChestplate(plugin);
		createLeggings(plugin);
		createBoots(plugin);
		generateEffects();
		
	}
	
	private static void createHelmet(Main plugin) {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME+" helmet");
		addLore(meta);
		meta.setCustomModelData(HELMET_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "copper_helmet");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape("CCC",
					  "C C");
		
		recipe1.setIngredient('C', Material.COPPER_INGOT);
		
		helmet = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void createChestplate(Main plugin) {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME+" chestplate");
		addLore(meta);
		meta.setCustomModelData(CHESTPLATE_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "copper_chestplate");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("C C",
					 "CCC",
					 "CCC");
		
		recipe.setIngredient('C', Material.COPPER_INGOT);
		
		chestplate = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}
	
	private static void createLeggings(Main plugin) {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME+" leggings");
		addLore(meta);
		meta.setCustomModelData(LEGGINGS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "copper_leggings");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("CCC",
					 "C C",
					 "C C");
		
		recipe.setIngredient('C', Material.COPPER_INGOT);
		
		leggings = item;
		
		Bukkit.addRecipe(recipe);
		
		
	}

	private static void createBoots(Main plugin) {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(NAME+" boots");
		addLore(meta);
		meta.setCustomModelData(BOOTS_ID); //1130 - armor
		
		item.setItemMeta(meta);
		
		addProtToItem(item);
		
		NamespacedKey key = new NamespacedKey(plugin, "copper_boots");
		
		ShapedRecipe recipe1 = new ShapedRecipe(key, item);
		
		recipe1.shape(
					 "C C",
					 "C C");

		
		recipe1.setIngredient('C', Material.COPPER_INGOT);
		
		boots = item;
		
		Bukkit.addRecipe(recipe1);
		
		
	}
	
	private static void generateEffects() {
		
		
		EFFECTS.add(new PotionEffect(PotionEffectType.SLOW, 20, 0));
		
		Random rnd = new Random();
		
		List<PotionEffectType> ps = generateGoodEffects();
		
		EFFECTS.add(new PotionEffect(ps.get(rnd.nextInt(ps.size())), 20, rnd.nextInt(3)));
		
		ps = generateBadEffects();
		
		EFFECTS.add(new PotionEffect(ps.get(rnd.nextInt(ps.size())), 20, rnd.nextInt(3)));
		
	}
	
	private static void addProtToItem(ItemStack item) {
		
		item.addEnchantment(Enchantment.THORNS, 1);
		
		Random rnd = new Random();
		
		List<Enchantment> ench = generateGoodEnchatments();
		
		item.addUnsafeEnchantment(ench.get(rnd.nextInt(ench.size())), rnd.nextInt(3)+1);
		
		ench = generateBadEnchatments();
		
		item.addUnsafeEnchantment(ench.get(rnd.nextInt(ench.size())), 1);
		
		
	}
	
	private static void addLore(ItemMeta meta) {
		
		List<String> lore = new ArrayList<String>();
		
		lore.add("An useless armor, as intended!");
		
		meta.setLore(lore);
		
		
	}
	
	private static List<Enchantment> generateGoodEnchatments() {
		
		List<Enchantment> enchants = new ArrayList<Enchantment>();
		
		enchants.add(Enchantment.PROTECTION_ENVIRONMENTAL);
		enchants.add(Enchantment.PROTECTION_EXPLOSIONS);
		enchants.add(Enchantment.PROTECTION_FALL);
		enchants.add(Enchantment.PROTECTION_FIRE);
		enchants.add(Enchantment.PROTECTION_PROJECTILE);
		

		enchants.add(Enchantment.THORNS);
		enchants.add(Enchantment.DURABILITY);
		enchants.add(Enchantment.OXYGEN);
		enchants.add(Enchantment.SOUL_SPEED);
		enchants.add(Enchantment.FROST_WALKER);
		
		return enchants;
		
	}
	
	private static List<Enchantment> generateBadEnchatments() {
		
		List<Enchantment> enchants = new ArrayList<Enchantment>();
		
		enchants.add(Enchantment.BINDING_CURSE);
		enchants.add(Enchantment.VANISHING_CURSE);
		
		return enchants;
		
	}
	
	private static List<PotionEffectType> generateGoodEffects() {
		
		List<PotionEffectType> potions = new ArrayList<PotionEffectType>();
		
		potions.add(PotionEffectType.ABSORPTION);
		potions.add(PotionEffectType.FAST_DIGGING);
		potions.add(PotionEffectType.SPEED);
		potions.add(PotionEffectType.REGENERATION);
		potions.add(PotionEffectType.JUMP);
		
		return potions;
		
	}
	
	private static List<PotionEffectType> generateBadEffects() {
		
		List<PotionEffectType> potions = new ArrayList<PotionEffectType>();

		potions.add(PotionEffectType.POISON);
		potions.add(PotionEffectType.SLOW_DIGGING);
		potions.add(PotionEffectType.BLINDNESS);
		potions.add(PotionEffectType.CONFUSION);
		potions.add(PotionEffectType.GLOWING);
		
		return potions;
		
	}

}
