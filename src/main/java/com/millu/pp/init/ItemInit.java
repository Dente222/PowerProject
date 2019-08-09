package com.millu.pp.init;

import java.util.ArrayList;
import java.util.List;

import com.millu.pp.Main;
import com.millu.pp.items.ItemBase;
import com.millu.pp.items.ToolAxe;
import com.millu.pp.items.ToolHoe;
import com.millu.pp.items.ToolPickaxe;
import com.millu.pp.items.ToolShovel;
import com.millu.pp.items.ToolSword;
import com.millu.pp.items.armor.ArmorBase;
import com.millu.pp.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {

	//Makes Array list for items
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	//Material Register
	public static final ToolMaterial TOOL_MALACHITE = EnumHelper.addToolMaterial("tool_malachite", 1, 180, 3.0F, 1.0F, 6);
	public static final ArmorMaterial ARMOR_MALACHITE = EnumHelper.addArmorMaterial("armor_malachite", Reference.MOD_ID + ":malachite", 12, new int[]{2, 3, 3, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	//Items Register
	public static final Item INGOT_MALACHITE = new ItemBase("ingot_malachite", Main.POWERTABS);
	public static final Item INGOT_URAN = new ItemBase("ingot_uran", Main.POWERTABS);
	public static final Item CHUNK_URAN = new ItemBase("chunk_uran", Main.POWERTABS);
	public static final Item CHUNK_PYRITE = new ItemBase("chunk_pyrite", Main.POWERTABS);
	
	
	//Tools Register
	public static final Item PICKAXE_MALACHITE = new ToolPickaxe("pickaxe_malachite", TOOL_MALACHITE, Main.POWERTABS);
	public static final Item AXE_MALACHITE = new ToolAxe("axe_malachite", TOOL_MALACHITE, Main.POWERTABS);
	public static final Item SHOVEL_MALACHITE = new ToolShovel("shovel_malachite", TOOL_MALACHITE, Main.POWERTABS);
	public static final Item SWORD_MALACHITE = new ToolSword("sword_malachite", TOOL_MALACHITE, Main.POWERTABS);
	public static final Item HOE_MALACHITE = new ToolHoe("hoe_malachite", TOOL_MALACHITE, Main.POWERTABS);
	
	
	//Armor Register
	public static final Item HELMET_MALACHITE = new ArmorBase("helmet_malachite", ARMOR_MALACHITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_MALACHITE = new ArmorBase("chestplate_malachite", ARMOR_MALACHITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGING_MALACHITE = new ArmorBase("leggings_malachite", ARMOR_MALACHITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_MALACHITE = new ArmorBase("boots_malachite", ARMOR_MALACHITE, 1, EntityEquipmentSlot.FEET);
	
}
