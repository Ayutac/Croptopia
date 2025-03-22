package com.epherical.croptopia;

import com.epherical.croptopia.blocks.LeafCropBlock;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.common.PlatformAdapter;
import com.epherical.croptopia.config.CroptopiaConfig;
import com.epherical.croptopia.config.IdentifierSerializer;
import com.epherical.croptopia.config.TreeConfiguration;
import com.epherical.croptopia.register.Composter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;

public record CroptopiaMod(PlatformAdapter<?> platform, CroptopiaConfig config) {
    public static final ArrayList<Item> CROP_ITEMS = new ArrayList<>();
    public static final ArrayList<Block> CROP_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> LEAF_BLOCKS = new ArrayList<>();
    public static final ArrayList<Item> SEEDS = new ArrayList<>();

    private static CroptopiaMod mod;

    public CroptopiaMod(final PlatformAdapter<?> platform, final CroptopiaConfig config) {
        this.platform = platform;
        this.config = config;
        config.addSerializer(TreeConfiguration.class, TreeConfiguration.Serializer.INSTANCE);
        config.addSerializer(ResourceLocation.class, IdentifierSerializer.INSTANCE);
        config.loadConfig(MiscNames.MOD_ID);
        mod = this;
    }

    public void registerCompost() {
        Composter composter = new Composter();
        composter.init();
    }

    public static CroptopiaMod getInstance() {
        return mod;
    }

    public static Item.Properties createGroup() {
        return new Item.Properties();
    }

    public static ResourceLocation createIdentifier(final String name) {
        return ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, name);
    }

    public static ResourceLocation createCommonIdentifier(final String name) {
        return ResourceLocation.fromNamespaceAndPath(MiscNames.COMMON_TAG, name);
    }

    public static BlockBehaviour.Properties createCropSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP);
    }

    public static LeafCropBlock createLeavesBlock() {
        return new LeafCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).ignitedByLava().randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(CroptopiaMod::canSpawnOnLeaves).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false));
    }

    public static LeavesBlock createRegularLeavesBlock() {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).ignitedByLava().randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(CroptopiaMod::canSpawnOnLeaves).isSuffocating(CroptopiaMod::never).isViewBlocking(CroptopiaMod::never));
    }

    public static BlockBehaviour.Properties createSaplingSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS);
    }

    private static boolean never(final BlockState state, final BlockGetter world, final BlockPos pos) {
        return false;
    }

    public static boolean canSpawnOnLeaves(BlockState state, BlockGetter world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }
}
