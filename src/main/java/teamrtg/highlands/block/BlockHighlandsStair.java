package teamrtg.highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import teamrtg.highlands.init.HighlandsBlocks;

public class BlockHighlandsStair extends BlockStairs {
    private HighlandsBlocks.EnumTypeTree treeType;

    public BlockHighlandsStair(HighlandsBlocks.EnumTypeTree type, Block base) {

        super(base.getDefaultState());
        setHardness(2.0F);
        setResistance(0.5F);
        setSoundType(SoundType.WOOD);

        this.setCreativeTab(HighlandsBlocks.tabHighlands);

        treeType = type;
    }
}
