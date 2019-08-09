package com.millu.pp.util.handlers;

import com.millu.pp.init.BlockInit;
import com.millu.pp.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	
	//Recipe Handler function usually for smelting recipes since smelting is Hard Coded
	public static void registerSmelting() {
		
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_MALACHITE ,1 ,0), new ItemStack(ItemInit.INGOT_MALACHITE, 1), 1.0f);	
		
	}

}
