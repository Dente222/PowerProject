/*
  
 Here is just some old ENUM Variant Function that I don't need right now so lets just comment all this
 
package com.millu.pp.init;

import com.millu.pp.Main;
import com.millu.pp.blocks.item.ItemBlockVariants;
import com.millu.pp.util.IHasModel;
import com.millu.pp.util.IMetaName;
import com.millu.pp.util.handlers.EnumHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOres extends Block implements IHasModel, IMetaName {
	
	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);
	
	private String name, dimension;
	
	public BlockOres(String name, String dimension) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.powertabs);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.MALACHITE));
		
		this.name = name;
		this.dimension = dimension;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	
	@Override
	public int damageDropped(IBlockState state) {

		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	//Gets Metadata of block from its state
	@Override
	public int getMetaFromState(IBlockState state) {

		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta){
		
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta));
	}
	
	//Picks block variant based on its Metadata value so that Specific ore will drop item that coresponds to its Meta State
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	//Creates SubBlocks based on variant so they can be in Creative tab with different Variants
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

		for(EnumHandler.EnumType variant : EnumHandler.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		
		return new BlockStateContainer(this, new IProperty[] {VARIANT}); 
	}
	
	//This Changes ore name depending on its Variant
	@Override
	public String getSpecialName(ItemStack stack) {
		
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	//Loops method to generate Variants of our ore blocks
	@Override
	public void registerModels() {
		
		for(int i = 0; i <EnumHandler.EnumType.values().length; i++) {
			//This method generates variants based on the Dimension in their name if ore texture name is "ore_overworld_orename" than ore will generate in Overworld
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + this.dimension + "_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}

}
*/