package com.millu.pp.blocks;

import java.util.List;

import com.millu.pp.Main;
import com.millu.pp.init.BlockInit;
import com.millu.pp.init.ItemInit;
import com.millu.pp.tileentity.TEBasicRTG;
import com.millu.pp.tileentity.TileEntityCoalGenerator;
import com.millu.pp.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRTGBase extends BlockBase implements IHasModel {
	

	
	public BlockRTGBase(String name) 
	{
		super(name, Material.IRON, Main.POWERTABS);
		setHardness(2F);
		setResistance(20F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 2);	
	
	}
	
	
	
	@Override
	public boolean hasTileEntity() 
	{
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TEBasicRTG();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
	{
		TEBasicRTG tileentity = (TEBasicRTG)worldIn.getTileEntity(pos);
		super.breakBlock(worldIn, pos, state);
	}
}
