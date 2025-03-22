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
    public void generateItemModels(final ItemModelGenerators gens) {
        gens.generateFlatItem(Content.AJVAR, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.AJVAR_TOAST, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ALMOND.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ALMOND_BRITTLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.APPLE_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.APPLE_PIE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.APRICOT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.APRICOT_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ARTICHOKE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ARTICHOKE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ARTICHOKE_DIP, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ASPARAGUS.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ASPARAGUS.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.AVOCADO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.AVOCADO_TOAST, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RAW_BACON, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BAKED_BEANS.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BAKED_SWEET_POTATO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BAKED_YAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BANANA.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BANANA_CREAM_PIE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BANANA_NUT_BREAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BANANA_SMOOTHIE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BARLEY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BARLEY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BASIL.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BASIL.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BEEF_JERKY, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BEEF_STEW, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BEEF_STIR_FRY, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BEEF_WELLINGTON, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BEER, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BELLPEPPER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BELLPEPPER.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BLACKBEAN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BLACKBEAN.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BLT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BLUEBERRY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BLUEBERRY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BLUEBERRY_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BROCCOLI.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BROCCOLI.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BROWNIES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BURRITO, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BUTTER, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BUTTERED_GREEN_BEANS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BUTTERED_TOAST, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CABBAGE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CABBAGE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CAESAR_SALAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CANDIED_NUTS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CANDY_CORN, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CANTALOUPE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CANTALOUPE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CARAMEL.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CARNITAS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CASHEW.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CASHEW_CHICKEN, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CAULIFLOWER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CAULIFLOWER.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CELERY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CELERY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHEESE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHEESE_CAKE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHEESE_PIZZA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHEESEBURGER, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHEESY_ASPARAGUS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHERRY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHERRY_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHERRY_PIE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHICKEN_AND_DUMPLINGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHICKEN_AND_NOODLES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHICKEN_AND_RICE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHILE_PEPPER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHILE_PEPPER.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHILI_RELLENO, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHIMICHANGA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHOCOLATE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHOCOLATE_ICE_CREAM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHOCOLATE_MILKSHAKE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CHURROS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COCONUT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COFFEE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COFFEE_BEANS.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COFFEE_BEANS.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COOKED_BACON.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COOKING_POT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CORN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CORN.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CORN_HUSK, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CORNISH_PASTY, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CRANBERRY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CRANBERRY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CRANBERRY_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CREMA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CUCUMBER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CUCUMBER.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CURRANT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CURRANT.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.DATE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.DOUGH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.DOUGHNUT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.DRAGONFRUIT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.EGG_ROLL, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.EGGPLANT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.EGGPLANT.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.EGGPLANT_PARMESAN, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ELDERBERRY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ELDERBERRY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ELDERBERRY_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ENCHILADA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ETON_MESS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FAJITAS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FIG.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FIGGY_PUDDING, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FISH_AND_CHIPS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FLOUR, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FOOD_PRESS.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRENCH_FRIES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRIED_CHICKEN, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRUIT_CAKE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRUIT_SALAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRUIT_SMOOTHIE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRYING_PAN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GARLIC.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GARLIC.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GINGER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GINGER.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRAPE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRAPE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRAPE_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRAPE_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRAPEFRUIT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GREENBEAN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GREENBEAN.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GREENONION.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GREENONION.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRILLED_CHEESE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRILLED_EGGPLANT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HAM_SANDWICH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HAMBURGER, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HONEYDEW.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HONEYDEW.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HOPS.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HOPS.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HORCHATA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KALE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KALE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KALE_CHIPS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KALE_SMOOTHIE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KIWI.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KIWI.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KIWI_SORBET, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KNIFE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.KUMQUAT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEAFY_SALAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEEK.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEEK.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEEK_SOUP, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEMON.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEMON_CHICKEN, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEMON_COCONUT_BAR, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LEMONADE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LETTUCE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LETTUCE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LIME.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.LIMEADE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MANGO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MANGO_ICE_CREAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MEAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MELON_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MILK_BOTTLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MOLASSES.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MORTAR_AND_PESTLE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MUSTARD.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MUSTARD.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.NECTARINE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.NETHER_WART_STEW, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.NOODLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.NOUGAT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.NUTMEG.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.NUTTY_COOKIE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OAT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OAT.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OATMEAL, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OLIVE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OLIVE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OLIVE_OIL, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ONION.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ONION.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ONION_RINGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ORANGE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ORANGE_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PAPRIKA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEACH.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEACH_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEANUT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEANUT.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEANUT_BUTTER, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEANUT_BUTTER_AND_JAM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEANUT_BUTTER_W_CELERY, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEAR.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PECAN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PECAN_ICE_CREAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PECAN_PIE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEPPER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEPPER.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PEPPERONI, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PERSIMMON.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PINEAPPLE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PINEAPPLE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PINEAPPLE_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PINEAPPLE_PEPPERONI_PIZZA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PIZZA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PLUM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.POPCORN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PORK_AND_BEANS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PORK_JERKY, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.POTATO_CHIPS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.POTATO_SOUP, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PROTEIN_BAR, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PUMPKIN_SPICE_LATTE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.QUESADILLA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RADISH.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RADISH.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OATMEAL_COOKIE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RAISINS.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RASPBERRY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RASPBERRY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RATATOUILLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RAVIOLI, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.REFRIED_BEANS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RHUBARB.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RHUBARB.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RHUBARB_CRISP, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RHUBARB_PIE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RICE.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROASTED_ASPARAGUS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROASTED_NUTS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROASTED_RADISHES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROASTED_SQUASH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROASTED_TURNIPS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RUM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RUM_RAISIN_ICE_CREAM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RUTABAGA.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.RUTABAGA.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SAGUARO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SAGUARO.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SAGUARO_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SALSA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SALT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SAUCY_CHIPS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SCONES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SCRAMBLED_EGGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SHEPHERDS_PIE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SNICKER_DOODLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SOY_MILK, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SOY_SAUCE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SOYBEAN.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SOYBEAN.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SPAGHETTI_SQUASH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SPINACH.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SPINACH.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SQUASH.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SQUASH.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STARFRUIT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STEAMED_BROCCOLI, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STEAMED_GREEN_BEANS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STEAMED_RICE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STICKY_TOFFEE_PUDDING, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STIR_FRY, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STRAWBERRY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STRAWBERRY.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STRAWBERRY_ICE_CREAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STRAWBERRY_JAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STRAWBERRY_SMOOTHIE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STUFFED_ARTICHOKE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STUFFED_POBLANOS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SUPREME_PIZZA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SUSHI, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SWEET_POTATO_FRIES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SWEETPOTATO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SWEETPOTATO.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TACO, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TAMALES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TEA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TEA_LEAVES.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TEA_LEAVES.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOAST.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOAST_SANDWICH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOAST_WITH_JAM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOFU, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOFU_AND_DUMPLINGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOFUBURGER, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOMATILLO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOMATILLO.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOMATO.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOMATO.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOMATO_JUICE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TORTILLA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TOSTADA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TRAIL_MIX, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TREACLE_TART, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TRES_LECHE_CAKE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TRIFLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TUNA_SANDWICH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TURMERIC.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TURMERIC.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TURNIP.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TURNIP.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.VANILLA.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.VANILLA.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.VANILLA_ICE_CREAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.VEGGIE_SALAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.WALNUT.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.WATER_BOTTLE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.WHIPPING_CREAM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.WINE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.YAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.YAM.getSeedItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.YAM_JAM, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.YOGHURT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ZUCCHINI.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ZUCCHINI.getSeedItem(), ModelTemplates.FLAT_ITEM);

        gens.generateFlatItem(Content.ROASTED_PUMPKIN_SEEDS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROASTED_SUNFLOWER_SEEDS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PUMPKIN_BARS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CORN_BREAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.PUMPKIN_SOUP, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MERINGUE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CABBAGE_ROLL, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BORSCHT, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GOULASH, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.BEETROOT_SALAD, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CANDIED_KUMQUATS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SHRIMP.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TUNA.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CALAMARI.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CRAB.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ROE.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CLAM.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.OYSTER.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COOKED_SHRIMP.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COOKED_TUNA.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COOKED_CALAMARI.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STEAMED_CRAB, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GLOWING_CALAMARI.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SEA_LETTUCE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.DEEP_FRIED_SHRIMP, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.TUNA_ROLL, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRIED_CALAMARI, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CRAB_LEGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.STEAMED_CLAMS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GRILLED_OYSTERS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ANCHOVY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.COOKED_ANCHOVY.asItem(), ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.ANCHOVY_PIZZA, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MASHED_POTATOES, ModelTemplates.FLAT_ITEM);

        gens.generateFlatItem(Content.BAKED_CREPES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CINNAMON_ROLL, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CROQUE_MADAME, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.CROQUE_MONSIEUR, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.DAUPHINE_POTATOES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FRIED_FROG_LEGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.FROG_LEGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.GROUND_PORK, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.HASHED_BROWN, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.MACARON, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.QUICHE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SAUSAGE, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SUNNY_SIDE_EGGS, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.SWEET_CREPES, ModelTemplates.FLAT_ITEM);
        gens.generateFlatItem(Content.THE_BIG_BREAKFAST, ModelTemplates.FLAT_ITEM);
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
