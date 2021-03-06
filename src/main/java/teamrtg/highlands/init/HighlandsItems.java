package teamrtg.highlands.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import teamrtg.highlands.block.BlockHighlandsLeaves;
import teamrtg.highlands.block.BlockHighlandsLog;
import teamrtg.highlands.block.BlockHighlandsPlanks;
import teamrtg.highlands.block.BlockHighlandsPlant;
import teamrtg.highlands.block.BlockHighlandsSapling;
import teamrtg.highlands.block.BlockHighlandsStair;
import teamrtg.highlands.reference.ModInfo;


public class HighlandsItems {

    public static Item[] planks;
    public static Item[] woods;
    public static Item[] leaves;
    public static Item[] saplings;

    //wood products
    public static Item[] doors;
    public static Item[] fences;
    public static Item[] slabs;
    public static Item[] doubleSlabs;
    public static Item[] stairs;

    public static Item[] plants;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        planks = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        woods = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        leaves = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        saplings = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        doors = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        fences = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        slabs = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        doubleSlabs = new Item[HighlandsBlocks.NUM_TREE_TYPES];
        stairs = new Item[HighlandsBlocks.NUM_TREE_TYPES];

        plants = new Item[HighlandsBlocks.NUM_PLANTS];
        
        for (int i = 0; i < HighlandsBlocks.NUM_TREE_TYPES; i++) {
            planks[i] = register(event, HighlandsBlocks.planks[i]);
            woods[i] = register(event, HighlandsBlocks.woods[i]);
            leaves[i] = register(event, HighlandsBlocks.leaves[i]);
            saplings[i] = register(event, HighlandsBlocks.saplings[i]);
            stairs[i] = register(event, HighlandsBlocks.stairs[i]);
        }

        for (int i = 0; i < HighlandsBlocks.NUM_PLANTS; i++) {
            plants[i] = register(event, HighlandsBlocks.plants[i]);
        }
    }

    private static Item register(RegistryEvent.Register<Item> event, Block block) {
        ResourceLocation name = block.getRegistryName();

        if(name == null) {
            throw new NullPointerException();
        }

        Item item = new ItemBlock(block);
        item.setRegistryName(name);
        item.setUnlocalizedName(block.getUnlocalizedName());
        item.setCreativeTab(HighlandsBlocks.tabHighlands);

        event.getRegistry().register(item);

        return item;
    }

    private static Item register(RegistryEvent.Register<Item> event, Item item, String name) {
        item.setRegistryName(new ResourceLocation(ModInfo.MOD_ID, name));
        item.setUnlocalizedName(ModInfo.MOD_ID + "." + name);
        item.setCreativeTab(HighlandsBlocks.tabHighlands);

        event.getRegistry().register(item);

        return item;
    }
}
