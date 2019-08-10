package com.millu.pp.tileentity;


import com.millu.pp.energy.OmniPowerEnergyStorage;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public class TEOmniEnergy extends TileEntity implements ITickable{
	
	//Sets max amount of stored energy
	private OmniPowerEnergyStorage storage = new OmniPowerEnergyStorage(1000);
	
	//Gets capability at T where T is current block
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		return super.getCapability(capability, facing);
	}
	
	//Checks if block has capability in this case Energy
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return true;
		return super.hasCapability(capability, facing);
	}
	
	//Sets default values for Extract and Receive of energy in case if we want to implement this directly
	//False stands for simulation If set to true it will simulate how the power I/O for current block without actually doing it for real
	@Override
	public void update() 
	{
		this.storage.receiveEnergy(1000, false);
		this.storage.extractEnergy(1000, false);
	}
	
}
