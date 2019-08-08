package com.millu.pp.blocks;

import com.millu.pp.Main;
import com.millu.pp.init.BlockInit;
import com.millu.pp.init.ItemInit;
import com.millu.pp.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockUraniumBase extends Block implements IHasModel {

	//Base class for dummy blocks that are made just to exist without any purpose just like stone
		public BlockUraniumBase(String name, Material material) {
			super(material);
			setUnlocalizedName(name);
			setRegistryName(name);
			setCreativeTab(Main.powertabs);
			
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		}
		
		
		@Override
		public void registerModels() {
			
			Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

		}

	}