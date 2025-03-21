package com.epherical.croptopia.items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CroptopiaSaplingItem extends ItemNameBlockItem {

    private final Block saplingFruitLeafBlock;
    private final Block vanillaLeafBlock;

    public CroptopiaSaplingItem(final Block block, final Block saplingFruitLeafBlock, final Block vanillaLeafBlock, final Properties settings) {
        super(block, settings);
        this.saplingFruitLeafBlock = saplingFruitLeafBlock;
        this.vanillaLeafBlock = vanillaLeafBlock;
    }

    @Override
    public InteractionResult useOn(final UseOnContext context) {
        BlockState atPos = context.getLevel().getBlockState(context.getClickedPos());
        if (atPos.getBlock() == vanillaLeafBlock) {
            if (!context.getPlayer().isCreative()) {
                context.getItemInHand().shrink(1);
            }
            context.getLevel().setBlockAndUpdate(context.getClickedPos(), saplingFruitLeafBlock.defaultBlockState());
            return InteractionResult.CONSUME;
        }
        return super.useOn(context);
    }
}
