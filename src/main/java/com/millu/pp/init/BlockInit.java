package com.millu.pp.init;

import java.util.ArrayList;
import java.util.List;

import com.millu.pp.Main;
import com.millu.pp.blocks.BlockBase;
import com.millu.pp.blocks.BlockStandardOres;
import com.millu.pp.blocks.BlockUraniumBase;
import com.millu.pp.blocks.machines.BlockCoalGeneratorBlock;
import com.millu.pp.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockInit {
	
	//Makes Array for our blocks
	public static final List<Block> BLOCKS = new ArrayList();
	
	//Normal Blocks
	public static final Block BLOCK_MALACHITE = new BlockBase("block_malachite", Material.IRON, Main.POWERTABS);

	
	//Ore Blocks
	//Place for ores that are a variant type of another ore
	//This is used for Variants but lets skip this since I dont have any rn
	//public static final Block ORE_SURFACE = new BlockOres("ore_overworld", "overworld");
	
	//Place where ores Generates without any Variants
	public static final Block ORE_URAN = new BlockUraniumBase("ore_uran", Material.ROCK);
	public static final Block ORE_MALACHITE = new BlockStandardOres("ore_malachite", Material.ROCK);
	public static final Block ORE_LATERITE = new BlockStandardOres("ore_laterite", Material.ROCK);
	public static final Block ORE_PYRITE = new BlockStandardOres("ore_pyrite", Material.ROCK);
	
	//Machine blocks and other Stuff
	public static final Block COAL_GENERATOR = new BlockCoalGeneratorBlock("block_cgenerator");

	//Custom Model Blocks
	
}
