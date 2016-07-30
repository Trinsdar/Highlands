package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenBambooForest extends BiomeGenBaseHighlands
{

	public BiomeGenBambooForest(int par1)
    {
        super(par1);
        
        theBiomeDecorator.treesPerChunk = 35;
        theBiomeDecorator.grassPerChunk = 4;
        theBiomeDecorator.flowersPerChunk = 1;
	    
        minHeight = 0.3F;
        maxHeight = 0.2F;
        temperature = 1.1F;
        rainfall = 0.3F;
        
        plants.add(HighlandsGenerators.greenLeaf);
        plants.add(HighlandsGenerators.mcWTulip);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return HighlandsGenerators.bambooGen;
    }
    
    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        
        genStandardOre(2, HighlandsGenerators.hlsand, 0, 72, world, random, pos);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.goldCount/2, theBiomeDecorator.goldGen, theBiomeDecorator.chunkProviderSettings.goldMinHeight, theBiomeDecorator.chunkProviderSettings.goldMaxHeight, world, random, pos);
    }
}
