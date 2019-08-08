package com.millu.pp.items;

import java.util.Set;

import com.google.common.collect.Sets;
import com.millu.pp.Main;
import com.millu.pp.init.ItemInit;
import com.millu.pp.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

//Axe need to be extended as ItemTool but multiple axes can refer to this class
public class ToolAxe extends ItemTool implements IHasModel {

	//Sets our Custom Axe to be Efficient against blocks that are specified below.                VVV
		private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.LOG, Blocks.BOOKSHELF, Blocks.LADDER, 
																	   Blocks.DARK_OAK_DOOR, Blocks.ACACIA_DOOR, Blocks.ACACIA_FENCE,
																	   Blocks.ACACIA_FENCE_GATE, Blocks.ACACIA_STAIRS, Blocks.BED, 
																	   Blocks.BIRCH_DOOR, Blocks.BIRCH_FENCE, Blocks.BIRCH_FENCE_GATE, 
																	   Blocks.BIRCH_STAIRS, Blocks.CHEST, Blocks.CRAFTING_TABLE, 
																	   Blocks.DARK_OAK_FENCE, Blocks.DARK_OAK_FENCE_GATE, Blocks.DARK_OAK_STAIRS, 
																	   Blocks.DOUBLE_WOODEN_SLAB, Blocks.JUNGLE_DOOR, Blocks.JUNGLE_FENCE, 
																	   Blocks.JUNGLE_FENCE_GATE, Blocks.JUNGLE_STAIRS, Blocks.JUKEBOX, 
																	   Blocks.LIT_PUMPKIN, Blocks.NOTEBLOCK, Blocks.OAK_DOOR, 
																	   Blocks.OAK_FENCE, Blocks.OAK_FENCE_GATE, Blocks.OAK_STAIRS, 
																	   Blocks.PUMPKIN, Blocks.SPRUCE_DOOR, Blocks.SPRUCE_FENCE, 
																	   Blocks.SPRUCE_FENCE_GATE, Blocks.SPRUCE_STAIRS, 
																	   Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, 
																	   Blocks.TRAPDOOR, Blocks.TRAPPED_CHEST, Blocks.WOODEN_PRESSURE_PLATE);

	
	public ToolAxe(String name, ToolMaterial material) {
		
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.powertabs);
		
		ItemInit.ITEMS.add(this);
	}
	
	//Makes our axe efficient against Wood/Plants and Vines Blocks
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ?super.getDestroySpeed(stack, state) : this.efficiency;
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}















