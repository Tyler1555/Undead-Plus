package me.tyler15555.undeadplus.biome;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGrave extends BiomeGenBase {

	/*
	 * This code was originally written by Techguy573, some names have been changed
	 * Updated by Tyler15555
	 */
	
	public BiomeGrave() {
		super(50);
		this.setBiomeName("Grave");
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		topBlock = Blocks.grass.getDefaultState();
		fillerBlock = Blocks.dirt.getDefaultState();
		minHeight = 0.1F;
		maxHeight = 0.3F;
		theBiomeDecorator.treesPerChunk = 0;
		theBiomeDecorator.deadBushPerChunk = 10;
		theBiomeDecorator.flowersPerChunk = 0;
		theBiomeDecorator.grassPerChunk = 4;
		theBiomeDecorator.mushroomsPerChunk = 10;
		theBiomeDecorator.waterlilyPerChunk = 0;
		theBiomeDecorator.reedsPerChunk = 0;
		waterColorMultiplier = 0xbe0000; 
		//Tree generator moved to world gen class
	}
	
	public int getModdedBiomeGrassColor(int original) {
		return Color.GRAY.getRGB();
	}
	
	public int getModdedBiomeFoliageColor(int original) {
		return Color.BLACK.getRGB();
	}

}
