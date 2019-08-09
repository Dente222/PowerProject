package com.millu.pp.util.handlers;

import com.millu.pp.tileentity.TileEntityCoalGenerator;
import com.millu.pp.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		
		GameRegistry.registerTileEntity(TileEntityCoalGenerator.class, new ResourceLocation(Reference.MOD_ID + ":block_cgenerator"));
	
	}
}