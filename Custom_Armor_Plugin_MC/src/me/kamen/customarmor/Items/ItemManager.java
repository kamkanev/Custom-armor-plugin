package me.kamen.customarmor.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Dolphin;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import me.kamen.customarmor.Main;
import me.kamen.customarmor.Items.Armor.Amethystarmor;
import me.kamen.customarmor.Items.Armor.Blazearmor;
import me.kamen.customarmor.Items.Armor.CopperArmor;
import me.kamen.customarmor.Items.Armor.Dolphinarmor;
import me.kamen.customarmor.Items.Armor.Godarmor;
import me.kamen.customarmor.Items.Armor.Miningarmor;
import me.kamen.customarmor.Items.Armor.NoobArmor;

public class ItemManager {
	
	private Main plugin;
	
	public ItemManager(Main plugin) {
		
		this.plugin = plugin;
		
		addAmetystBToShards();
		Amethystarmor.init(plugin);
		
		Blazearmor.init(plugin);
		
		NoobArmor.init(plugin);
		
		Dolphinarmor.init(plugin);
		
		Miningarmor.init(plugin);
		
		Godarmor.init(plugin);
		
		CopperArmor.init(plugin);
		
	}
	
	private void addAmetystBToShards() {
		
		ItemStack amm = new ItemStack(Material.AMETHYST_SHARD, 4);
		
		ShapedRecipe recipe = new ShapedRecipe(amm);
		
		recipe.shape("B");
		
		recipe.setIngredient('B', Material.AMETHYST_BLOCK);
		
		Bukkit.addRecipe(recipe);
	}

}
