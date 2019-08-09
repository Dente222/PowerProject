package com.millu.pp.util.handlers;

import com.millu.pp.blocks.containers.ContainerCoalGenerator;
import com.millu.pp.guis.GuiCoalGenerator;
import com.millu.pp.tileentity.TileEntityCoalGenerator;
import com.millu.pp.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_COAL_GENERATOR) return new ContainerCoalGenerator(player.inventory, (TileEntityCoalGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		
		return null;
		
	}
	
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_COAL_GENERATOR) return new GuiCoalGenerator(player.inventory, (TileEntityCoalGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	
	}
}