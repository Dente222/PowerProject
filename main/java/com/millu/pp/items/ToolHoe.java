package com.millu.pp.items;

import com.millu.pp.Main;
import com.millu.pp.init.ItemInit;
import com.millu.pp.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel{
	

	public ToolHoe(String name, ToolMaterial material) {
		
		super(material);
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
