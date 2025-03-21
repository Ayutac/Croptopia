package com.epherical.croptopia.common.generator;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.epherical.croptopia.CroptopiaMod.createIdentifier;
import static com.epherical.croptopia.common.ItemNamesV2.*;
import static net.minecraft.core.registries.Registries.PLACED_FEATURE;
import static net.minecraft.resources.ResourceKey.create;

public class PlacedFeatureKeys {
    private static final String TREE_PLACED = "_tree_placed";
    public static final ResourceKey<PlacedFeature> ALMOND_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(ALMOND + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> APPLE_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(APPLE + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> APRICOT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(APRICOT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> AVOCADO_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(AVOCADO + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> BANANA_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(BANANA + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> CASHEW_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(CASHEW + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> CHERRY_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(CHERRY + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> COCONUT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(COCONUT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> DATE_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(DATE + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> DRAGONFRUIT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(DRAGONFRUIT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> FIG_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(FIG + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> GRAPEFRUIT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(GRAPEFRUIT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> KUMQUAT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(KUMQUAT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> LEMON_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(LEMON + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> LIME_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(LIME + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> MANGO_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(MANGO + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> NECTARINE_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(NECTARINE + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> NUTMEG_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(NUTMEG + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> ORANGE_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(ORANGE + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> PEACH_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(PEACH + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> PEAR_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(PEAR + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> PECAN_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(PECAN + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> PERSIMMON_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(PERSIMMON + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> PLUM_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(PLUM + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> STARFRUIT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(STARFRUIT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> WALNUT_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(WALNUT + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> CINNAMON_TREE_PLACED_KEY = create(PLACED_FEATURE, (createIdentifier(CINNAMON + TREE_PLACED)));
    public static final ResourceKey<PlacedFeature> DISK_SALT_PLACED_KEY = create(PLACED_FEATURE, createIdentifier("disk_salt_placed"));

    public static final ResourceKey<PlacedFeature> RANDOM_CROP_KEY = create(PLACED_FEATURE, createIdentifier("random_crop_placed"));
}
