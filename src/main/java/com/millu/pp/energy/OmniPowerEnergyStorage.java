package com.millu.pp.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class OmniPowerEnergyStorage extends EnergyStorage{
	
	//Most of this were taken from EnergyStorage Class, this is used to allow our energy to be stored and work with other mods
	//This is a Storage System based on Forge Energy
	
	public OmniPowerEnergyStorage(int capacity)
    {
        super(capacity, capacity, capacity, 0);
    }

    public OmniPowerEnergyStorage(int capacity, int maxTransfer)
    {
    	super(capacity, maxTransfer, maxTransfer, 0);
    }

    public OmniPowerEnergyStorage(int capacity, int maxReceive, int maxExtract)
    {
    	super(capacity, maxReceive, maxExtract, 0);
    }

    public OmniPowerEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy)
    {
    	super(capacity, maxReceive, maxExtract, energy);
    }
    
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) 
    {
    	return super.receiveEnergy(maxReceive, simulate);
    }
    
    @Override
    public int extractEnergy(int maxExtract, boolean simulate) 
    {
    	return super.extractEnergy(maxExtract, simulate);
    }
    
    @Override
    public int getEnergyStored() 
    {
    	return super.getEnergyStored();
    }
    
    @Override
    public int getMaxEnergyStored()
    {
    	return super.getMaxEnergyStored();
    }
    
    @Override
    public boolean canExtract()
    {
    	return super.canExtract();
    }
    
    @Override
    public boolean canReceive() 
    {
    	return super.canReceive();
    }
    
    //This reads default storage Tags "NOTE: Tags need's to gave this exact names to work properly!"
    public void readFromNBT(NBTTagCompound compound)
    {
    	this.energy = compound.getInteger("Energy");
    	this.capacity = compound.getInteger("Capacity");
    	this.maxReceive = compound.getInteger("MaxReceive");
    	this.maxExtract = compound.getInteger("MaxExtract");
    }
    
    //This saves default storage Tags "NOTE: Tags need's to gave this exact names to work properly!"
    public void writeToNBT(NBTTagCompound compound)
    {
    	compound.setInteger("Energy", this.energy);
    	compound.setInteger("Capacity", this.capacity);
    	compound.setInteger("MaxReceive", this.maxReceive);
    	compound.setInteger("MaxExtract", this.maxExtract);
    }
}
