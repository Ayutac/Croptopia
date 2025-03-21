package com.epherical.croptopia.common.generator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static com.epherical.croptopia.CroptopiaMod.createIdentifier;
import static com.epherical.croptopia.common.ItemNamesV2.*;
import static net.minecraft.core.registries.Registries.*;
import static net.minecraft.resources.ResourceKey.*;

public class ConfiguredFeatureKeys {
    private static final String TREE = "_tree";
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALMOND_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(ALMOND + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(APPLE + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> APRICOT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(APRICOT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(AVOCADO + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(BANANA + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CASHEW_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(CASHEW + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(CHERRY + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> COCONUT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(COCONUT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DATE_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(DATE + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRAGON_FRUIT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(DRAGONFRUIT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIG_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(FIG + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAPEFRUIT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(GRAPEFRUIT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> KUMQUAT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(KUMQUAT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(LEMON + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIME_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(LIME + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(MANGO + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NECTARINE_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(NECTARINE + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> NUTMEG_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(NUTMEG + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(ORANGE + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEACH_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(PEACH + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(PEAR + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PECAN_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(PECAN + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PERSIMMON_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(PERSIMMON + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUM_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(PLUM + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> STAR_FRUIT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(STARFRUIT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WALNUT_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(WALNUT + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON_TREE_KEY = create(CONFIGURED_FEATURE, (createIdentifier(CINNAMON + TREE)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_SALT_KEY = create(CONFIGURED_FEATURE, (createIdentifier("disk_salt")));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RANDOM_CROP_KEY = create(CONFIGURED_FEATURE, (createIdentifier("random_crop")));

}
