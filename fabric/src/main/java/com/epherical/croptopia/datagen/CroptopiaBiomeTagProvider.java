package com.epherical.croptopia.datagen;

import com.epherical.croptopia.common.Tags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;


public class CroptopiaBiomeTagProvider extends TagsProvider<Biome> {

    protected CroptopiaBiomeTagProvider(PackOutput dataGenerator, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(dataGenerator, Registries.BIOME, completableFuture);
    }

    private static @NotNull Set<BiomeTagPair> getBiomeTagPairs() {
        final Set<BiomeTagPair> set = new HashSet<>();
        set.add(new BiomeTagPair(Tags.HAS_ARTICHOKE, ConventionalBiomeTags.IS_SWAMP));
        set.add(new BiomeTagPair(Tags.HAS_ASPARAGUS, ConventionalBiomeTags.IS_SWAMP));
        set.add(new BiomeTagPair(Tags.HAS_BELLPEPPER, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_BLACKBEAN, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_BLACKBERRY, ConventionalBiomeTags.IS_FOREST, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_BLUEBERRY, ConventionalBiomeTags.IS_FOREST, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_BROCCOLI, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_CABBAGE, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_CANTALOUPE, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_CAULIFLOWER, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_CELERY, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_COFFEE_BEANS, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_CORN, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_CRANBERRY, ConventionalBiomeTags.IS_SWAMP));
        set.add(new BiomeTagPair(Tags.HAS_CUCUMBER, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_CURRANT, ConventionalBiomeTags.IS_SWAMP));
        set.add(new BiomeTagPair(Tags.HAS_EGGPLANT, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_ELDERBERRY, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_GARLIC, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_GRAPE, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_GREENBEAN, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_GREENONION, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_HONEYDEW, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_HOPS, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_KALE, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_KIWI, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_LEEK, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_LETTUCE, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_OLIVE, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_ONION, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_PEANUT, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_PINEAPPLE, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_RADISH, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_RASPBERRY, ConventionalBiomeTags.IS_FOREST, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_RHUBARB, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_RICE, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_RUTABAGA, ConventionalBiomeTags.IS_SAVANNA, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_SAGUARO, ConventionalBiomeTags.IS_DESERT));
        set.add(new BiomeTagPair(Tags.HAS_SPINACH, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_SQUASH, ConventionalBiomeTags.IS_SAVANNA, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_STRAWBERRY, ConventionalBiomeTags.IS_FOREST, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_SWEETPOTATO, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_TOMATILLO, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_TOMATO, ConventionalBiomeTags.IS_FOREST));
        set.add(new BiomeTagPair(Tags.HAS_TURNIP, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_YAM, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_ZUCCHINI, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_MUSTARD, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_CHILE_PEPPER, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_TURMERIC, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_GINGER, ConventionalBiomeTags.IS_SAVANNA));
        set.add(new BiomeTagPair(Tags.HAS_BASIL, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_OAT, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_BARLEY, ConventionalBiomeTags.IS_PLAINS, ConventionalBiomeTags.IS_TAIGA));
        set.add(new BiomeTagPair(Tags.HAS_SOYBEAN, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_VANILLA, ConventionalBiomeTags.IS_JUNGLE));
        set.add(new BiomeTagPair(Tags.HAS_PEPPER, ConventionalBiomeTags.IS_PLAINS));
        set.add(new BiomeTagPair(Tags.HAS_TEA_LEAVES, ConventionalBiomeTags.IS_FOREST));
        return set;
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        final Set<BiomeTagPair> biomePairs = getBiomeTagPairs();

        for (final BiomeTagPair biomePair : biomePairs) {
            for (final TagKey<Biome> category : biomePair.categories()) {
                tag(biomePair.biome()).addOptionalTag(category.location());
            }
        }
    }

    protected record BiomeTagPair(TagKey<Biome> biome, TagKey<Biome>... categories) {
        // nothing else needed
    }


}
