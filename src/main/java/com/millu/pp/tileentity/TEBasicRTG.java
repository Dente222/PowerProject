package com.millu.pp.tileentity;

import com.millu.pp.blocks.machines.BlockCoalGeneratorBlock;
import com.millu.pp.energy.OmniPowerEnergyStorage;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TEBasicRTG extends TileEntity implements ITickable{

	//Here we have place that defines our handlers and energy storage
	//OmniPowerEnergyStorage is referred to class in Energy package
	public ItemStackHandler handler = new ItemStackHandler(1);
	private OmniPowerEnergyStorage storage = new OmniPowerEnergyStorage(2, 0, 20);
	
	//Energy is our Current energy
	//customName Used to define name for this block
	//cookTime is to count delay before engaging method
	//ENERGY_OUT_PUT is to define how much energy can be extracted per tick
	public int energy;
	public byte zegar;
	public final int RTG_OUT_PUT = 2;
	
	//Runs our Generator on every tick update
	@Override
	public void update() 
	{
		zegar++;
		
		if(zegar == 30) {
			
			energy += 2;
			zegar = 0;
				
			//To prevent overcharge of the storage
				if(energy >= 4) {
					energy = 2;
				}
			
		
			//Will check if there is tile entity in specific location from this block in this case above generator
			if (getWorld() != null && !getWorld().isRemote
					&& getWorld().getTileEntity(getPos().offset(EnumFacing.UP)) != null) {
				
				//Directs which way it can output energy
				IEnergyStorage storages = getWorld().getTileEntity(getPos().offset(EnumFacing.UP))
						.getCapability(CapabilityEnergy.ENERGY, EnumFacing.UP.getOpposite());
			
				//Check if there is more energy than 0 in our storage if yes than will extract energy from block
				//ENERGY_OUT_PUT is to determine how much energy it can extract form our generator false stands for simulation "If true it will simulate extraction but not gonna actually extract"
				if (storages != null && storages.canReceive() && energy > 0) {
					storage.extractEnergy(storages.receiveEnergy(RTG_OUT_PUT, false), false);
					this.energy = storage.getEnergyStored();
				
				}
			}
		}
	}
	
	
	//Gets capacity of T "T = current block" and applies it to energy storage
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		return super.getCapability(capability, facing);
	}
	
	//Check if our energy storage has capability
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return true;
		return super.hasCapability(capability, facing);
	}
	
	//Fun Part is here!
	//This writes information in this block as NBT tags
	//energy and cookTime is also used to create progress bar in block container function and draw it in our GUI
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	//Reads from our NBT tags so that Our block will be updated with info when entering our world again
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.storage.readFromNBT(compound);
	}
	
	//Gets Energy from variable
	public int getEnergyStored()
	{
		return this.energy;
	}
	
	//Gets allowed amout on our generator energy storage
	public int getMaxEnergyStored()
	{
		return this.storage.getMaxEnergyStored();
	}
	
	// Defines variable which will be used as our power when we will be extracting it
	 public int extractEnergy(int maxExtract, boolean simulate) 
	    {
	    	return this.energy;
	    }
	

	//Sets distance which allows player to interact with this block and will close gui when player is moved away from it
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}	
	
	
}