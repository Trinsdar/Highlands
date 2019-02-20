package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenMeadow extends BiomeGenBaseHighlands {

    public BiomeGenMeadow(int par1) {

        super(HLBiomeProps.MEADOW.getProps());

        spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));

        decorator.treesPerChunk = 0;
        decorator.grassPerChunk = 15;
        decorator.flowersPerChunk = 8;

        decorator.generateFalls = false;

        plants.add(HighlandsGenerators.lavender);
        plants.add(HighlandsGenerators.cotton);
        plants.add(HighlandsGenerators.mcDaisy);
        plants.add(HighlandsGenerators.mcRTulip);
        plants.add(HighlandsGenerators.mcOTulip);
        plants.add(HighlandsGenerators.mcWTulip);
        plants.add(HighlandsGenerators.mcAllium);
    }

    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return HighlandsGenerators.poplarGen;
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(10, HighlandsGenerators.hlwater, 10, 64, world, random, pos);
        genStandardOre(decorator.chunkProviderSettings.lapisCount / 2, decorator.lapisGen, 0, 32, world, random, pos);
    }
}
