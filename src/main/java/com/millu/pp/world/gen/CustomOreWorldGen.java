package com.millu.pp.world.gen;

import java.util.Random;

import com.millu.pp.init.BlockInit;
import com.millu.pp.init.BlockOres;
import com.millu.pp.util.handlers.EnumHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CustomOreWorldGen implements IWorldGenerator {
	
	//Private Non Array list to define ores for ore Gen
	private WorldGenerator ore_overworld_malachite, ore_overworld_laterite, ore_overworld_pyrite, ore_uran;
	
	public CustomOreWorldGen() {
		
		ore_overworld_malachite = new WorldGenMinable(BlockInit.ORE_SURFACE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.MALACHITE), 11, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_laterite = new WorldGenMinable(BlockInit.ORE_SURFACE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.LATERITE), 9, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_pyrite = new WorldGenMinable(BlockInit.ORE_SURFACE.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumType.LATERITE), 13, BlockMatcher.forBlock(Blocks.STONE));
		
		//Uranium does not belong to any Variant
		ore_uran = new WorldGenMinable(BlockInit.ORE_URAN.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));

	}
	
	//Provider for ores to generate in specific Dimension More cases = More Dimensions!
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:
			
			//Placeholder in case of adding ore vatiants to Nether
			//worldGenerartorGen(ore_nether_malachite, world, random, chunkX, chunkZ, 50, 0, 100);
			
			break;
			
		case 0:
			
			//In this case this ores will spawn in Overworld
			worldGenerartorGen(ore_overworld_malachite, world, random, chunkX, chunkZ, 24, 0, 70);
			worldGenerartorGen(ore_overworld_laterite, world, random, chunkX, chunkZ, 20, 0, 50);
			worldGenerartorGen(ore_overworld_pyrite, world, random, chunkX, chunkZ, 15, 0, 60);
			worldGenerartorGen(ore_uran, world, random, chunkX, chunkZ, 10, 0, 30);
			
			break;
			
		case 1:
			
			//Placeholder in case of adding ore vatiants to End
			//worldGenerartorGen(ore_end_malachite, world, random, chunkX, chunkZ, 50, 0, 256);
		}
	}
	
	private void worldGenerartorGen(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore wygenerowa³o sie nie poprawnie!/Ore has generated Incorrectyl!");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
	
}
