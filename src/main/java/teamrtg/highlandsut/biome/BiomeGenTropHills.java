package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenTropHills extends BiomeGenBaseHighlands
{

	public BiomeGenTropHills(int par1)
    {
        super(par1);
        
        theBiomeDecorator.treesPerChunk = 12;
        theBiomeDecorator.grassPerChunk = 10;
        theBiomeDecorator.flowersPerChunk = 1;
	    
        this.minHeight = 0.4F;
        this.maxHeight = 0.5F;
        this.temperature = 0.95F;
        this.rainfall = 0.7F;
        
        plants.add(HighlandsGenerators.mcOrchid);
        plants.add(HighlandsGenerators.greenLeaf);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return HighlandsGenerators.eucalyptusGen;
    }
    
    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        
        genStandardOre(theBiomeDecorator.chunkProviderSettings.coalCount/2, theBiomeDecorator.coalGen, theBiomeDecorator.chunkProviderSettings.coalMinHeight, theBiomeDecorator.chunkProviderSettings.coalMaxHeight, world, random, pos);
    }
}
