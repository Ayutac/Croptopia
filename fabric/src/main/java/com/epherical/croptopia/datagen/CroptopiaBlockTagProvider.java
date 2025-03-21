package com.epherical.croptopia.datagen;

import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CroptopiaBlockTagProvider extends IntrinsicHolderTagsProvider<Block> {

    public CroptopiaBlockTagProvider(final PackOutput packOutput, final CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, Registries.BLOCK, completableFuture, block -> block.builtInRegistryHolder().key());
    }

    @Override
    protected void addTags(final HolderLookup.Provider arg) {
        generateSaplings();
        generateBarkLogs();
        generateLeaves();
        // in vanilla for bees only
        generateCrops();
        generateMisc();
    }

    protected void generateSaplings() {
        final IntrinsicTagAppender<Block> saplings = this.tag(BlockTags.SAPLINGS);
        for (final TreeCrop crop : TreeCrop.copy()) {
            saplings.add(crop.getSaplingBlock());
        }
        for (final Tree crop : Tree.copy()) {
            saplings.add(crop.getSaplingBlock());
        }
    }

    protected void generateBarkLogs() {
        final IntrinsicTagAppender<Block> burnableLog = this.tag(BlockTags.LOGS_THAT_BURN);
        for (final Tree crop : Tree.copy()) {
            // add different log types to log tag of this crop
            tag(crop.getLogBlockTag())
                    .add(crop.getLog())
                    .add(crop.getStrippedLog())
                    .add(crop.getWood())
                    .add(crop.getStrippedWood());
            // make this crop log burnable
            burnableLog.addTag(crop.getLogBlockTag());
        }
    }

    protected void generateLeaves() {
        final IntrinsicTagAppender<Block> leaves = this.tag(BlockTags.LEAVES);
        final IntrinsicTagAppender<Block> hoe = this.tag(BlockTags.MINEABLE_WITH_HOE);
        for (final TreeCrop crop : TreeCrop.TREE_CROPS) {
            leaves.add(crop.getLeaves());
            hoe.add(crop.getLeaves());
        }
        for (final Tree crop : Tree.copy()) {
            leaves.add(crop.getLeaves());
            hoe.add(crop.getLeaves());
        }
    }

    protected void generateCrops() {
        final IntrinsicTagAppender<Block> crops = this.tag(BlockTags.CROPS);
        for (final FarmlandCrop crop : FarmlandCrop.copy()) {
            crops.add(crop.asBlock());
        }
        for (final TreeCrop crop : TreeCrop.copy()) {
            crops.add(crop.asBlock());
        }
    }

    protected void generateMisc() {
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(Content.SALT_ORE_BLOCK);
        tag(BlockTags.AZALEA_ROOT_REPLACEABLE).add(Content.SALT_ORE_BLOCK);
        tag(BlockTags.DRIPSTONE_REPLACEABLE).add(Content.SALT_ORE_BLOCK);
        tag(BlockTags.ENDERMAN_HOLDABLE).add(Content.SALT_ORE_BLOCK);
    }
}
