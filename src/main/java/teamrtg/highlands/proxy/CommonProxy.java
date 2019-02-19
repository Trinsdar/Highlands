package teamrtg.highlands.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import teamrtg.highlands.Config;
import teamrtg.highlands.FuelManager;
import teamrtg.highlands.HLEventManager;
import teamrtg.highlands.HighlandsRecipes;
import teamrtg.highlands.HighlandsSettings;
import teamrtg.highlands.init.HighlandsBiomes;
import teamrtg.highlands.init.HighlandsBlocks;
import teamrtg.highlands.generator.GeneratePlants;
import teamrtg.highlands.generator.GenerateRiverRapids;
import teamrtg.highlands.generator.GenerateTrees;

import java.io.File;

public class CommonProxy {

    public static Configuration config;

    HLEventManager eventMgr = new HLEventManager();
    GenerateTrees genTrees = new GenerateTrees();
    GeneratePlants genPlants = new GeneratePlants();
    GenerateRiverRapids genRRapids = new GenerateRiverRapids();


    public void preInit(FMLPreInitializationEvent event) {

        MinecraftForge.TERRAIN_GEN_BUS.register(eventMgr);
        MinecraftForge.EVENT_BUS.register(eventMgr);

        MinecraftForge.EVENT_BUS.register(HighlandsBlocks.class);

        config = new Configuration(new File(event.getModConfigurationDirectory() + File.separator + "highlands.cfg"));
        config.load();
        Config.setUpConfig(config);
        config.save();


    }

    public void init(FMLInitializationEvent event) {

        GameRegistry.registerWorldGenerator(genTrees, 10);
        GameRegistry.registerWorldGenerator(genPlants, 10);
        GameRegistry.registerWorldGenerator(genRRapids, 10);

        HighlandsSettings.constructSettings();

        HighlandsBiomes.constructBiomes();
        HighlandsBiomes.setUpAllSubBiomes();
        HighlandsBiomes.setUpBiomeManager();
        HighlandsBiomes.modifyVanillaBiomes();

        if (event.getSide().equals(Side.CLIENT)) {
            HighlandsBlocks.registerRenders();
        }

        HighlandsRecipes.init();

        GameRegistry.registerFuelHandler(new FuelManager());
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
