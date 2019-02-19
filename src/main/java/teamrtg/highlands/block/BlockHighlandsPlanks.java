package teamrtg.highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import teamrtg.highlands.init.HighlandsBlocks;

public class BlockHighlandsPlanks extends Block {

    private HighlandsBlocks.EnumTypeTree treeType;

    public BlockHighlandsPlanks(HighlandsBlocks.EnumTypeTree type) {

        super(Material.WOOD);
        setHardness(2.0F);
        setResistance(0.5F);
        setSoundType(SoundType.WOOD);

        this.setCreativeTab(HighlandsBlocks.tabHighlands);

        treeType = type;
    }
}