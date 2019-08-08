package com.millu.pp.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	
	public static enum EnumType implements IStringSerializable {
		
		//Defines our ore variants, MAX 16 Variants!
		//No more Polon since uranium spawns outside of this variants
		//This variants are for Non special ores, Ores like Uranium will be generating Radiation thanks to NuclearCraft
		MALACHITE(0, "malachite"), //Copper Ore
		LATERITE(1, "laterite"), //Aluminium Ore
		PYRITE(2,"pyrite"); //Added mostly to help with Sulfuric Acid Production
		
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private EnumType(int meta, String name) {
			
			this(meta, name, name);
		}
		//Let's set meta to make different variants of our ore.
		//Unidict will not gonna affect it but its outcome.
		private EnumType(int meta, String name, String unlocalizedName) {
			
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
			
		}
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getMeta() {
			return this.meta;
		}
		
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
		public static EnumType byMetadata(int meta) {
			return META_LOOKUP[meta];
		}
		
		static {
			for(EnumType enumtype : values()) {
				META_LOOKUP[enumtype.getMeta()] = enumtype;
			}
		}
	}
}
