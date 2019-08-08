package com.millu.pp.items;

import com.millu.pp.Main;
import com.millu.pp.init.ItemInit;
import com.millu.pp.proxy.ClientProxy;
import com.millu.pp.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	
	//Base class for our items, this class makes dummy items without any functions 
	public ItemBase(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.powertabs);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
