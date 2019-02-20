package teamrtg.highlands.init;

import java.util.ArrayList;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamrtg.highlands.Config;
import teamrtg.highlands.HighlandsSettings;
import teamrtg.highlands.biome.BiomeGenAdirondacks;
import teamrtg.highlands.biome.BiomeGenAdirondacksFoothills;
import teamrtg.highlands.biome.BiomeGenAlps;
import teamrtg.highlands.biome.BiomeGenAlpsFoothills;
import teamrtg.highlands.biome.BiomeGenBadlands;
import teamrtg.highlands.biome.BiomeGenBadlandsFoothills;
import teamrtg.highlands.biome.BiomeGenBaldHill;
import teamrtg.highlands.biome.BiomeGenBambooForest;
import teamrtg.highlands.biome.BiomeGenBaseHighlands;
import teamrtg.highlands.biome.BiomeGenDryForest;
import teamrtg.highlands.biome.BiomeGenDunes;
import teamrtg.highlands.biome.BiomeGenGreyMountains;
import teamrtg.highlands.biome.BiomeGenGreyMountainsFoothills;
import teamrtg.highlands.biome.BiomeGenHighlands;
import teamrtg.highlands.biome.BiomeGenLake;
import teamrtg.highlands.biome.BiomeGenLowlands;
import teamrtg.highlands.biome.BiomeGenMeadow;
import teamrtg.highlands.biome.BiomeGenMojave;
import teamrtg.highlands.biome.BiomeGenPinelands;
import teamrtg.highlands.biome.BiomeGenPoplarHills;
import teamrtg.highlands.biome.BiomeGenRedwoodForest;
import teamrtg.highlands.biome.BiomeGenTropHills;
import teamrtg.highlands.biome.BiomeGenTropicalIslands;
import teamrtg.highlands.reference.ModInfo;
import teamrtg.highlands.util.BiomeUtils;

/*
 * Highlands biomes - Highlands API
 * 
 * This class contains all of the biomes for Highlands.
 * Only access this class in Post Initialization!
 * The values are populated during Highlands initialization.
 */
public class HighlandsBiomes {

    //main biomes
    public static Biome highlandsBiome;
    public static Biome pinelands;
    public static Biome autumnForest;
    public static Biome alps;
    public static Biome meadow;
    public static Biome tropicDryForest;
    public static Biome redwoodForest;
    public static Biome lowlands;
    public static Biome mojave;
    public static Biome poplarHills;
    public static Biome badlands;
    public static Biome greyMtns;
    public static Biome tropHills;
    public static Biome dryForest;
    public static Biome adirondack;
    public static Biome bambooForest;
    public static Biome dunes;

    //Sub Biomes
    public static Biome lake;
    public static Biome baldHill;
    public static Biome tropicalIslands;

    //Foothill biomes.
    public static Biome adirondackFoothills;
    public static Biome alpsFoothills;
    public static Biome badlandsFoothills;
    public static Biome greyMtnsFoothills;

    //ArrayList of biomes for the Highlands worldtype
    public static ArrayList<Biome> biomesForHighlands = new ArrayList<Biome>();

    //ArrayList of Highlands biomes not including default ones, these will be added to the default world
    //Currently not used since BiomeManager doesn't really do different biomes for different world types
    //public static ArrayList<Biome> biomesForDefault = new ArrayList<Biome>();

    //ArrayList of sub-biomes, controls which Highlands biomes generate as sub-biomes (currently used for Lake and Bald Hill)
    public static ArrayList<Biome> subBiomes = new ArrayList<Biome>();

    //ArrayList of biomes that have foothills, not that are foothills.
    public static ArrayList<Biome> foothillsBiomes = new ArrayList<Biome>();

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {

        //main biomes

        if (Config.alpsGenerate.getBoolean(true)) {

            alps = registerBiome(event, new BiomeGenAlps(Config.alpsID.getInt()), "alps");
            biomesForHighlands.add(alps);

            if (canHaveFoothills(alps)) {
                alpsFoothills = registerBiome(event, new BiomeGenAlpsFoothills(Config.alpsID.getInt() + 128), "alps_foothills");
                biomesForHighlands.add(alpsFoothills);
                foothillsBiomes.add(alps);
            }
        }
        if (Config.badlandsGenerate.getBoolean(true)) {

            badlands = registerBiome(event, new BiomeGenBadlands(Config.badlandsID.getInt()), "badlands");
            biomesForHighlands.add(badlands);

            if (canHaveFoothills(badlands)) {
                badlandsFoothills = registerBiome(event, new BiomeGenBadlandsFoothills(Config.badlandsID.getInt() + 128), "badlands_foothills");
                biomesForHighlands.add(badlandsFoothills);
                foothillsBiomes.add(badlands);
            }
        }
        if (Config.poplarHillsGenerate.getBoolean(true)) {
            poplarHills = registerBiome(event, new BiomeGenPoplarHills(Config.poplarHillsID.getInt()), "poplar_hills");
            biomesForHighlands.add(poplarHills);
        }
        if (Config.highlandsbGenerate.getBoolean(true)) {
            highlandsBiome = registerBiome(event, new BiomeGenHighlands(Config.highlandsbID.getInt()), "highlands");
            biomesForHighlands.add(highlandsBiome);
        }
        if (Config.lowlandsGenerate.getBoolean(true)) {
            lowlands = registerBiome(event, new BiomeGenLowlands(Config.lowlandsID.getInt()), "lowlands");
            biomesForHighlands.add(lowlands);
        }
        if (Config.meadowGenerate.getBoolean(true)) {
            meadow = registerBiome(event, new BiomeGenMeadow(Config.meadowID.getInt()), "meadow");
            biomesForHighlands.add(meadow);
        }
        if (Config.pinelandsGenerate.getBoolean(true)) {
            pinelands = registerBiome(event, new BiomeGenPinelands(Config.pinelandsID.getInt()), "pinelands");
            biomesForHighlands.add(pinelands);
        }
        if (Config.redwoodForestGenerate.getBoolean(true)) {
            redwoodForest = registerBiome(event, new BiomeGenRedwoodForest(Config.redwoodForestID.getInt()), "redwood_forest");
            biomesForHighlands.add(redwoodForest);
        }
        if (Config.mojaveGenerate.getBoolean(true)) {
            mojave = registerBiome(event, new BiomeGenMojave(Config.mojaveID.getInt()), "mojave");
            biomesForHighlands.add(mojave);
        }
        if (Config.greyMtnsGenerate.getBoolean(true)) {

            greyMtns = registerBiome(event, new BiomeGenGreyMountains(Config.greyMtnsID.getInt()), "grey_mountains");
            biomesForHighlands.add(greyMtns);

            if (canHaveFoothills(greyMtns)) {
                greyMtnsFoothills = registerBiome(event, new BiomeGenGreyMountainsFoothills(Config.greyMtnsID.getInt() + 128), "grey_mountains_foothils");
                biomesForHighlands.add(greyMtnsFoothills);
                foothillsBiomes.add(greyMtns);
            }
        }
        if (Config.tropHillsGenerate.getBoolean(true)) {
            tropHills = registerBiome(event, new BiomeGenTropHills(Config.tropHillsID.getInt()), "tropical_hills");
            biomesForHighlands.add(tropHills);
        }
        if (Config.dryForestGenerate.getBoolean(true)) {
            dryForest = registerBiome(event, new BiomeGenDryForest(Config.dryForestID.getInt()), "dry_forest");
            biomesForHighlands.add(dryForest);
        }
        if (Config.adirondackGenerate.getBoolean(true)) {

            adirondack = registerBiome(event, new BiomeGenAdirondacks(Config.adirondackID.getInt()), "adirondack");
            biomesForHighlands.add(adirondack);

            if (canHaveFoothills(adirondack)) {
                adirondackFoothills = registerBiome(event, new BiomeGenAdirondacksFoothills(Config.adirondackID.getInt() + 128), "adirondack_foothills");
                biomesForHighlands.add(adirondackFoothills);
                foothillsBiomes.add(adirondack);
            }
        }
        if (Config.bambooForestGenerate.getBoolean(true)) {
            bambooForest = registerBiome(event, new BiomeGenBambooForest(Config.bambooForestID.getInt()), "bamboo_forest");
            biomesForHighlands.add(bambooForest);
        }
        if (Config.dunesGenerate.getBoolean(true)) {
            dunes = registerBiome(event, new BiomeGenDunes(Config.dunesID.getInt()), "dunes");
            biomesForHighlands.add(dunes);
        }


        //sub-biomes
        if (Config.lakeGenerate.getBoolean(true)) {
            lake = registerBiome(event, new BiomeGenLake(Config.lakeID.getInt()), "lake");
            subBiomes.add(lake);
        }
        if (Config.baldHillGenerate.getBoolean(true)) {
            baldHill = registerBiome(event, new BiomeGenBaldHill(Config.baldHillID.getInt()), "bald_hills");
            subBiomes.add(baldHill);
        }
        if (Config.tropicalIslandsGenerate.getBoolean(true)) {
            tropicalIslands = registerBiome(event, new BiomeGenTropicalIslands(Config.tropicalIslandsID.getInt()), "tropical_islands");
            subBiomes.add(tropicalIslands);
        }
    }

    private static Biome registerBiome(RegistryEvent.Register<Biome> event, Biome biome, String name) {
        biome.setRegistryName(ModInfo.MOD_ID, name);

        event.getRegistry().register(biome);

        return biome;
    }


    //sets up sub-biome lists after all biomes are initialized.
    public static void setUpAllSubBiomes() {

        ArrayList<Biome> enabledBiomes = new ArrayList<Biome>();
        for (Biome b : biomesForHighlands) {
            enabledBiomes.add(b);
        }
        for (Biome b : subBiomes) {
            enabledBiomes.add(b);
        }

        addSubBiome(alps, Biomes.FROZEN_RIVER, enabledBiomes);
        addSubBiome(autumnForest, baldHill, enabledBiomes);
        addSubBiome(autumnForest, lake, enabledBiomes);
        addSubBiome(poplarHills, meadow, enabledBiomes);
        addSubBiome(poplarHills, lake, enabledBiomes);
        addSubBiome(meadow, lake, enabledBiomes);
        addSubBiome(highlandsBiome, Biomes.FOREST, enabledBiomes);
        addSubBiome(pinelands, autumnForest, enabledBiomes);
        addSubBiome(redwoodForest, highlandsBiome, enabledBiomes);
        addSubBiome(redwoodForest, lake, enabledBiomes);
        addSubBiome(mojave, Biomes.MESA, enabledBiomes);
        addSubBiome(mojave, Biomes.SAVANNA, enabledBiomes);
        addSubBiome(tropHills, lake, enabledBiomes);
        addSubBiome(dryForest, Biomes.SAVANNA, enabledBiomes);
    }

    public static void addSubBiome(Biome parent, Biome sub, ArrayList<Biome> list) {

        if (parent != null && sub != null && list.contains(parent) && list.contains(sub) && parent instanceof BiomeGenBaseHighlands) {
            ((BiomeGenBaseHighlands) parent).subBiomes.add(sub);
        }
    }

    public static void setUpBiomeManager() {

//        for (int i = 0; i < biomesForHighlands.size(); i++) {
//            Biome hlb = biomesForHighlands.get(i);
//            if (!(hlb == null)) {
//                //System.out.println(hlb.biomeName + " has been added to the biome list.");
//
//                BiomeEntry entry = new BiomeEntry(hlb, 10);
//                BiomeType type = (hlb.getTemperature() < 0.3 ? BiomeType.ICY : hlb.getTemperature() < 0.5 ? BiomeType.COOL
//                    : hlb.getTemperature() < 1.0 ? BiomeType.WARM : BiomeType.DESERT);
//                BiomeManager.addBiome(type, entry);
//                if (hlb.getTemperature() >= 0.5 && hlb.getTemperature() <= 0.7) {
//                    BiomeManager.addBiome(BiomeType.COOL, entry);
//                }
//                if (hlb.getTemperature() >= 0.9 && hlb.getTemperature() <= 1.0) {
//                    BiomeManager.addBiome(BiomeType.DESERT, entry);
//                }
//                BiomeManager.addSpawnBiome(hlb);
//                BiomeManager.addStrongholdBiome(hlb);
//                if (hlb.equals(meadow) || hlb.equals(highlandsBiome)
//                    || hlb.equals(lowlands) || hlb.equals(mojave)) {
//                    BiomeManager.addVillageBiome(hlb, true);
//                }
//            }
//
//        }
        if (HighlandsSettings.vanillaBiomeChanges) {
            BiomeManager.addVillageBiome(Biomes.ICE_PLAINS, true);
        }

        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.DESERT, 10));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.SAVANNA, 10));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.MESA_CLEAR_ROCK, 5));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.MESA_ROCK, 5));
        BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(Biomes.MESA, 5));

        BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Biomes.JUNGLE, 10));

        BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(Biomes.REDWOOD_TAIGA, 10));
    }


    public static void modifyVanillaBiomes() {

        if (HighlandsSettings.vanillaBiomeChanges) {

            /*

            TODO: How do we change the attributes of already-registered biomes? - WhichOnesPink

            Biomes.EXTREME_HILLS.minHeight = 1.0F;
            Biomes.SWAMPLAND.minHeight = -0.1F;
            Biomes.SAVANNA_PLATEAU.minHeight = 1.0F;
            Biomes.STONE_BEACH.maxHeight = 0.5F;
            Biomes.RIVER.minHeight = -0.8F;
            Biomes.RIVER.maxHeight = 0.0F;
            */
        }
    }

    public static boolean canHaveFoothills(Biome b1) {

        if (BiomeUtils.getId(b1) > 127) {
            throw new RuntimeException("Error generating foothills biome - parent ID " + BiomeUtils.getId(b1) + " is over 127.");
        }

        if (Biome.getBiome(BiomeUtils.getId(b1) + 128) != null) {
            throw new RuntimeException("Error generating foothills biome - foothills ID " + (BiomeUtils.getId(b1) + 128) + " is taken.");
        }

        return true;
    }
}







