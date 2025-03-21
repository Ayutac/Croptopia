package com.epherical.croptopia.datagen;

import com.epherical.croptopia.blocks.CroptopiaCropBlock;
import com.epherical.croptopia.blocks.LeafCropBlock;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.TreeCrop;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Optional;
import java.util.function.UnaryOperator;

public class CroptopiaModelProvider extends FabricModelProvider {

    public CroptopiaModelProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockModelGenerators gens) {
        generateTreeCropModels(gens);
        generateFarmlandCropModels(gens);
        generateMisc(gens);
    }

    private void generateTreeCropModels(final BlockModelGenerators gens) {
        final String oakLeaves = "oak_leaves";
        final String darkOakLeaves = "dark_oak_leaves";
        final String jungleLeaves = "jungle_leaves";
        final String white = "white";
        final String yellow = "yellow";
        final String pink = "pink";
        createTreeCropBlock(gens, Content.ALMOND, darkOakLeaves, white);
        createTreeCropBlock(gens, Content.APPLE, oakLeaves, white);
        createTreeCropBlock(gens, Content.APRICOT, oakLeaves, white);
        createTreeCropBlock(gens, Content.AVOCADO, oakLeaves, yellow);
        createTreeCropBlock(gens, Content.BANANA, jungleLeaves, pink);
        createTreeCropBlock(gens, Content.CASHEW, darkOakLeaves, pink);
        createTreeCropBlock(gens, Content.CHERRY, oakLeaves, pink);
        createTreeCropBlock(gens, Content.COCONUT, jungleLeaves, yellow);
        createTreeCropBlock(gens, Content.DATE, jungleLeaves, yellow);
        createTreeCropBlock(gens, Content.DRAGONFRUIT, jungleLeaves, white);
        createTreeCropBlock(gens, Content.FIG, jungleLeaves, pink);
        createTreeCropBlock(gens, Content.GRAPEFRUIT, jungleLeaves, white);
        createTreeCropBlock(gens, Content.KUMQUAT, jungleLeaves, white);
        createTreeCropBlock(gens, Content.LEMON, oakLeaves, white);
        createTreeCropBlock(gens, Content.LIME, oakLeaves, white);
        createTreeCropBlock(gens, Content.MANGO, jungleLeaves, yellow);
        createTreeCropBlock(gens, Content.NECTARINE, oakLeaves, pink);
        createTreeCropBlock(gens, Content.NUTMEG, jungleLeaves, white);
        createTreeCropBlock(gens, Content.ORANGE, oakLeaves, white);
        createTreeCropBlock(gens, Content.PEACH, oakLeaves, pink);
        createTreeCropBlock(gens, Content.PEAR, oakLeaves, white);
        createTreeCropBlock(gens, Content.PECAN, darkOakLeaves, yellow);
        createTreeCropBlock(gens, Content.PERSIMMON, oakLeaves, yellow);
        createTreeCropBlock(gens, Content.PLUM, oakLeaves, white);
        createTreeCropBlock(gens, Content.STARFRUIT, oakLeaves, pink);
        createTreeCropBlock(gens, Content.WALNUT, darkOakLeaves, yellow);
    }

    private void generateFarmlandCropModels(final BlockModelGenerators gens) {
        createFarmlandCropBlock(gens, Content.ARTICHOKE, CrossType.SIMPLE);
        createFarmlandCropBlock(gens, Content.ASPARAGUS, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BARLEY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BASIL, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BELLPEPPER, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BLACKBEAN, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BLACKBERRY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BLUEBERRY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.BROCCOLI, CrossType.SIMPLE);
        createFarmlandCropBlock(gens, Content.CABBAGE, CrossType.SIMPLE);
        createFarmlandCropBlock(gens, Content.CANTALOUPE, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.CAULIFLOWER, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.CELERY, CrossType.SIMPLE);
        createFarmlandCropBlock(gens, Content.CHILE_PEPPER, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.COFFEE_BEANS, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.CORN, CrossType.DOUBLE);
        createFarmlandCropBlock(gens, Content.CRANBERRY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.CUCUMBER, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.CURRANT, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.EGGPLANT, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.ELDERBERRY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.GARLIC, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.GINGER, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.GRAPE, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.GREENBEAN, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.GREENONION, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.HONEYDEW, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.HOPS, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.KALE, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.KIWI, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.LEEK, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.LETTUCE, CrossType.SIMPLE);
        createFarmlandCropBlock(gens, Content.MUSTARD, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.OAT, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.OLIVE, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.ONION, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.PEANUT, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.PEPPER, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.PINEAPPLE, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.RADISH, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.RASPBERRY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.RHUBARB, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.RICE, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.RUTABAGA, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.SAGUARO, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.SOYBEAN, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.SPINACH, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.SQUASH, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.STRAWBERRY, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.SWEETPOTATO, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.TEA_LEAVES, CrossType.SIMPLE);
        createFarmlandCropBlock(gens, Content.TOMATILLO, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.TOMATO, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.TURMERIC, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.TURNIP, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.VANILLA, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.YAM, CrossType.NONE);
        createFarmlandCropBlock(gens, Content.ZUCCHINI, CrossType.NONE);
    }

    private void generateMisc(final BlockModelGenerators gens) {
        gens.createTrivialCube(Content.SALT_ORE_BLOCK);
    }

    @Override
    public void generateItemModels(final ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(Content.ROASTED_PUMPKIN_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.ROASTED_SUNFLOWER_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.PUMPKIN_BARS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CORN_BREAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.PUMPKIN_SOUP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.MERINGUE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CABBAGE_ROLL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.BORSCHT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.GOULASH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.BEETROOT_SALAD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CANDIED_KUMQUATS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.SHRIMP.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.TUNA.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CALAMARI.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CRAB.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.ROE.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CLAM.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.OYSTER.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.COOKED_SHRIMP.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.COOKED_TUNA.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.COOKED_CALAMARI.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.STEAMED_CRAB, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.GLOWING_CALAMARI.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.SEA_LETTUCE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.DEEP_FRIED_SHRIMP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.TUNA_ROLL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.FRIED_CALAMARI, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CRAB_LEGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.STEAMED_CLAMS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.GRILLED_OYSTERS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.ANCHOVY.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.COOKED_ANCHOVY.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.ANCHOVY_PIZZA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.MASHED_POTATOES, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(Content.BAKED_CREPES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CINNAMON_ROLL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CROQUE_MADAME, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.CROQUE_MONSIEUR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.DAUPHINE_POTATOES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.FRIED_FROG_LEGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.FROG_LEGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.GROUND_PORK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.HASHED_BROWN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.MACARON, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.QUICHE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.SAUSAGE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.SUNNY_SIDE_EGGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.SWEET_CREPES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Content.THE_BIG_BREAKFAST, ModelTemplates.FLAT_ITEM);
    }

    protected void createTreeCropBlock(final BlockModelGenerators gens, final TreeCrop treeCrop, final String vanillaLeafType, final String flowerColor) {
        final TextureMapping texture0 = new TextureMapping();
        texture0.put(TextureSlot.ALL, ResourceLocation.withDefaultNamespace("block/" + vanillaLeafType));
        texture0.put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + flowerColor + "_tree_bud"));
        final TextureMapping texture1 = new TextureMapping();
        texture1.put(TextureSlot.ALL, ResourceLocation.withDefaultNamespace("block/" + vanillaLeafType));
        texture1.put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + flowerColor + "_tree_flower"));
        final TextureMapping texture2 = new TextureMapping();
        texture2.put(TextureSlot.ALL, ResourceLocation.withDefaultNamespace("block/" + vanillaLeafType));
        texture2.put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + treeCrop.name() + "_unripe"));
        final TextureMapping texture3 = new TextureMapping();
        texture3.put(TextureSlot.ALL, ResourceLocation.withDefaultNamespace("block/" + vanillaLeafType));
        texture3.put(TextureSlot.CROP, ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + treeCrop.name() + "_ripe"));
        final ModelTemplate modelTemplate = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/croptopia_leaves")), Optional.empty(), TextureSlot.ALL, TextureSlot.CROP);
        final Property<Integer> ageProperty = ((LeafCropBlock)treeCrop.asBlock()).getAgeProperty();
        // the following is mainly copied from BlockModelGenerators#createCropBlock
        final Int2ObjectMap<ResourceLocation> int2ObjectMap = new Int2ObjectOpenHashMap<>();
        final PropertyDispatch propertyDispatch = PropertyDispatch.property(ageProperty).generate((integer) -> {
            final ResourceLocation resourceLocation = int2ObjectMap.computeIfAbsent(integer, (j) -> gens.createSuffixedVariant(treeCrop.asBlock(), "_stage" + integer, modelTemplate,
                    rl -> {
                        if (rl.getPath().endsWith("_stage0")) {
                            return texture0;
                        }
                        if (rl.getPath().endsWith("_stage1")) {
                            return texture1;
                        }
                        if (rl.getPath().endsWith("_stage2")) {
                            return texture2;
                        }
                        if (rl.getPath().endsWith("_stage3")) {
                            return texture3;
                        }
                        throw new IllegalArgumentException("Unknown Identifier: " + rl);
                    }));
            return Variant.variant().with(VariantProperties.MODEL, resourceLocation);
        });
        gens.blockStateOutput.accept(MultiVariantGenerator.multiVariant(treeCrop.asBlock()).with(propertyDispatch));
        gens.createCrossBlockWithDefaultItem(treeCrop.getSaplingBlock(), BlockModelGenerators.TintState.TINTED);
    }

    protected enum CrossType {
        NONE,
        SIMPLE,
        DOUBLE
    }

    protected void createFarmlandCropBlock(final BlockModelGenerators gens, final FarmlandCrop farmlandCrop, final CrossType cross) {
        final TextureMapping texture0 = cross == CrossType.NONE
                ? TextureMapping.crop(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage0"))
                : TextureMapping.cross(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage0"));
        final TextureMapping texture1 = cross == CrossType.NONE
                ? TextureMapping.crop(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage1"))
                : TextureMapping.cross(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage1"));
        final TextureMapping texture2 = cross == CrossType.NONE
                ? TextureMapping.crop(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage2"))
                : TextureMapping.cross(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage2"));
        final TextureMapping texture3 = cross == CrossType.NONE
                ? TextureMapping.crop(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage3"))
                : TextureMapping.cross(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/" + farmlandCrop.name() + "_crop_stage3"));
        final ModelTemplate modelTemplate = switch (cross) {
            case NONE -> ModelTemplates.CROP;
            case SIMPLE -> new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/crop_cross")), Optional.empty(), TextureSlot.CROSS);
            case DOUBLE -> new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, "block/crop_cross_double")), Optional.empty(), TextureSlot.CROSS);
        };
        final Property<Integer> ageProperty = ((CroptopiaCropBlock)farmlandCrop.asBlock()).getAgeProperty();
        // the following is mainly copied from BlockModelGenerators#createCropBlock
        final Int2ObjectMap<ResourceLocation> int2ObjectMap = new Int2ObjectOpenHashMap<>();
        final UnaryOperator<Integer> ageReduction = age -> switch (age) {
            case 0 -> 0;
            case 1, 2, 3 -> 1;
            case 4, 5, 6 -> 2;
            case 7 -> 3;
            default -> throw new IllegalArgumentException("Unsupported age: " + age);
        };
        final PropertyDispatch propertyDispatch = PropertyDispatch.property(ageProperty).generate((integer) -> {
            final int reducedAge = ageReduction.apply(integer);
            final ResourceLocation resourceLocation = int2ObjectMap.computeIfAbsent(reducedAge, (j) -> gens.createSuffixedVariant(farmlandCrop.asBlock(), "_stage" + reducedAge, modelTemplate,
                    rl -> {
                        if (rl.getPath().endsWith("_stage0")) {
                            return texture0;
                        }
                        if (rl.getPath().endsWith("_stage1")) {
                            return texture1;
                        }
                        if (rl.getPath().endsWith("_stage2")) {
                            return texture2;
                        }
                        if (rl.getPath().endsWith("_stage3")) {
                            return texture3;
                        }
                        throw new IllegalArgumentException("Unknown Identifier: " + rl);
                    }));
            return Variant.variant().with(VariantProperties.MODEL, resourceLocation);
        });
        gens.blockStateOutput.accept(MultiVariantGenerator.multiVariant(farmlandCrop.asBlock()).with(propertyDispatch));
        gens.skipAutoItemBlock(farmlandCrop.asBlock());
    }
}
