package com.epherical.croptopia.generator;

import com.epherical.croptopia.Croptopia;
import com.epherical.croptopia.common.generator.PlacedFeatureKeys;
import com.epherical.croptopia.config.TreeConfiguration;
import com.epherical.croptopia.datagen.WorldGenFeatures;
import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BiomeModifiers {

    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init(final Croptopia croptopia) {

        // generate in ALL biomes
        BiomeModifications.addFeature(context -> true,
                GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatureKeys.RANDOM_CROP_KEY);

        final List<TreeConfiguration> trees = Croptopia.mod.config().treeConfigurations;
        for (final TreeConfiguration tree : trees) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(tree.getTreesAllowedInBiome()),
                    GenerationStep.Decoration.VEGETAL_DECORATION, tree.getFeatureKey());
        }

        final Collection<ResourceKey<Biome>> exclusion = Arrays.asList(Biomes.SWAMP, Biomes.SWAMP);

        if (Croptopia.mod.config().generateSaltInWorld) {
            BiomeModifications.addFeature(BiomeSelectors.excludeByKey(exclusion),
                    GenerationStep.Decoration.UNDERGROUND_ORES, PlacedFeatureKeys.DISK_SALT_PLACED_KEY);
        }
    }
}
