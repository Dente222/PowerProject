package com.millu.pp.tabs;

import com.millu.pp.init.BlockInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PowerTabs extends CreativeTabs {
	
	//Creates Tab for our mod
	public PowerTabs(String label) { super("power_tab");
	//Loads background image for our custom CTab
	this.setBackgroundImageName("powertab.png");
	}
	
	//Selects Icon for our tab In this case our icon is Block
	public ItemStack getTabIconItem() { return new ItemStack(Item.getItemFromBlock(BlockInit.BLOCK_MALACHITE));
			
	}
}

