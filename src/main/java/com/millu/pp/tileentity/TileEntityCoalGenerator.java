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

public class TileEntityCoalGenerator extends TileEntity implements ITickable{

	//Here we have place that defines our handlers and energy storage
	//OmniPowerEnergyStorage is referred to class in Energy package
	public ItemStackHandler handler = new ItemStackHandler(1);
	private OmniPowerEnergyStorage storage = new OmniPowerEnergyStorage(1000, 0, 20);
	
	//Energy is our Current energy
	//customName Used to define name for this block
	//cookTime is to count delay before engaging method
	//ENERGY_OUT_PUT is to define how much energy can be extracted per tick
	public int energy;
	private String customName;
	public int cookTime;
	public final int ENERGY_OUT_PUT = 20;
	
	//Runs our Generator on every tick update
	@Override
	public void update() 
	{
		//Will start working if provided Redsotne power
		if(world.isBlockPowered(pos)) {

			//Will check if there is tile entity in specific location from this block in this case above generator
			if (getWorld() != null && !getWorld().isRemote
					&& getWorld().getTileEntity(getPos().offset(EnumFacing.UP)) != null) {
				
				//Directs which way it can output energy
				IEnergyStorage storages = getWorld().getTileEntity(getPos().offset(EnumFacing.UP))
						.getCapability(CapabilityEnergy.ENERGY, EnumFacing.UP.getOpposite());
			
				//Check if there is more energy than 0 in our storage if yes than will extract energy from block
				//ENERGY_OUT_PUT is to determine how much energy it can extract form our generator false stands for simulation "If true it will simulate extraction but not gonna actually extract"
				if (storages != null && storages.canReceive() && energy > 0) {
					storage.extractEnergy(storages.receiveEnergy(ENERGY_OUT_PUT, false), false);
					this.energy = storage.getEnergyStored();
				
				}
			}
		}
		
		//Check for item in our fuel slot "Slot 0", what item is our fuel "In this case any Coal" and checks if there is still space for energy to be generated "Max energy stored is 1000 for this block"
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)) && energy == 1000)
		{
			
			//cookTime is to determine the delay before consuming our fuel
			//energy is generated energy while fuel is provided to our input slot
			cookTime++;
			energy++;
			
			//Check if our cookTime'r has reached 100
			if(cookTime == 100)
			{
				
				//Will consume 1 fuel from Slot 0 and resets timer
				handler.getStackInSlot(0).shrink(1);
				cookTime = 0;
			}
		}
		//Reset Cooking timer if there is no fuel in slot
		//Note: This will be removed due to infinite power Bug sooo DON"T USE THAT!
		else
		{
			cookTime--;
		}
	}
	
	//Checks if item is Valid Fuel
	private boolean isItemFuel(ItemStack stack) 
	{
		return getFuelValue(stack) > 0;
	}
	
	//Defines what is fuel for this Generator Note: in case of this generator "100" is just placeholder
	//Since my generator generates power per tick instead taking it from item
	//But you can apply this value every time cookTimer reaches its max value
	private int getFuelValue(ItemStack stack) 
	{
		//Coal is our fule this also applies to Charcoal 
		if(stack.getItem() == Items.COAL) return 100;
		else return 0;
	}
	
	//Gets capacity of T "T = current block" and applies it to energy storage
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return (T)this.storage;
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T)this.handler;
		return super.getCapability(capability, facing);
	}
	
	//Check if our energy storage has capability
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY) return true;
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}
	
	//Fun Part is here!
	//This writes information in this block as NBT tags
	//energy and cookTime is also used to create progress bar in block container function and draw it in our GUI
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", this.cookTime);
		compound.setInteger("GuiEnergy", this.energy);
		compound.setString("Name", getDisplayName().toString());
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	//Reads from our NBT tags so that Our block will be updated with info when entering our world again
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		this.energy = compound.getInteger("GuiEnergy");
		this.customName = compound.getString("Name");
		this.storage.readFromNBT(compound);
	}
	
	//Shows name of the gui in our generator gui
	@Override
	public ITextComponent getDisplayName()
	{
		return new TextComponentTranslation("container.block_cgenerator");
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
	
	//Gets the ID of field in out containet 
	//Used to draw progress arrow and energy bar in our gui
	public int getField(int id)
	{
		switch(id)
		{
		case 0:
			return this.energy;
		case 1:
			return this.cookTime;
		default:
			return 0;
		}
	}
	
	//Sets ID for our field's
	public void setField(int id, int value)
	{
		switch(id)
		{
		case 0:
			this.energy = value;
		case 1:
			this.cookTime = value;
		break;
		}
	}
	
	//Sets distance which allows player to interact with this block and will close gui when player is moved away from it
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}	
	
	
}