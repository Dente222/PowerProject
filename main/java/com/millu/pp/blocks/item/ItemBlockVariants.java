package com.millu.pp.blocks.item;

import com.millu.pp.util.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;


public class ItemBlockVariants extends ItemBlock {
	
	//A class that register correct Item block from meta value of our ore blocks
	public ItemBlockVariants(Block block) {
		
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	//Same as in BlockOres class but for items
	public String getUnlocalizedName(ItemStack stack) {
		
		return super.getUnlocalizedName() + "_" + ((IMetaName)this.block).getSpecialName(stack);
	}

}
