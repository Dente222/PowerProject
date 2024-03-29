package com.millu.pp.blocks;

import com.millu.pp.Main;
import com.millu.pp.init.BlockInit;
import com.millu.pp.init.ItemInit;
import com.millu.pp.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockUraniumBase extends Block implements IHasModel {

	//Base class for dummy blocks that are made just to exist without any purpose just like stone
		public BlockUraniumBase(String name, Material material) {
			super(material);
			setUnlocalizedName(name);
			setRegistryName(name);
			setHardness(4F);
			setResistance(15F);
			setHarvestLevel("pickaxe", 2);
			setCreativeTab(Main.POWERTABS);
			
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		}
		
		//Drops specific item whit specific ammount
		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemInit.CHUNK_URAN, (int) (1)));
		}

		
		@Override
		public void registerModels() 
		{
			Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
		}

	}