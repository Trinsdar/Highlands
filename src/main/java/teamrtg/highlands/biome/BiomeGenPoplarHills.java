package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenPoplarHills extends BiomeGenBaseHighlands {

    public BiomeGenPoplarHills(int par1) {

        super(HLBiomeProps.POPLAR_HILLS.getProps());

        decorator.treesPerChunk = 6;
        decorator.grassPerChunk = 10;
        decorator.flowersPerChunk = 4;

        plants.add(HighlandsGenerators.mcOrchid);
        plants.add(HighlandsGenerators.mcDaisy);
    }


    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return HighlandsGenerators.poplarGen;
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(10, HighlandsGenerators.hlwater, 10, 64, world, random, pos);
        genStandardOre(decorator.chunkProviderSettings.diamondCount / 2, decorator.diamondGen, decorator.chunkProviderSettings.diamondMinHeight, decorator.chunkProviderSettings.diamondMaxHeight, world, random, pos);
    }
}
