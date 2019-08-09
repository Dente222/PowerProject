package com.millu.pp.blocks;

import com.millu.pp.Main;
import com.millu.pp.init.BlockInit;
import com.millu.pp.init.ItemInit;
import com.millu.pp.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockStandardOres extends Block implements IHasModel {

		//Class defined for any typical ore blocks such as Copper Aluminium or Tin
		public BlockStandardOres(String name, Material material) {
			super(Material.ROCK);
			setUnlocalizedName(name);
			setRegistryName(name);
			setHardness(2F);
			setResistance(10F);
			setHarvestLevel("pickaxe", 1);
			setCreativeTab(Main.POWERTABS);
			
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
		}

			@Override
			public void registerModels() 
			{
				Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
			}

}