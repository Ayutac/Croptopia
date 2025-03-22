package com.epherical.croptopia.datagen;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.common.ItemNamesV2;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.common.Tags;
import com.epherical.croptopia.mixin.datagen.IdentifierAccessor;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.CroptopiaItem;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.IceCream;
import com.epherical.croptopia.register.helpers.Jam;
import com.epherical.croptopia.register.helpers.Juice;
import com.epherical.croptopia.register.helpers.Pie;
import com.epherical.croptopia.register.helpers.Smoothie;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.Util;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class CroptopiaRecipeProvider extends FabricRecipeProvider {

    public CroptopiaRecipeProvider(final FabricDataOutput output) {
        super(output, CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor()));
    }

    @Override
    public void buildRecipes(final RecipeOutput exporter) {
        generateSeeds(exporter);
        generateSaplings(exporter);
        generateBarkWood(exporter);
        generateJams(exporter);
        generateJuices(exporter);
        generateSmoothies(exporter);
        generateIceCream(exporter);
        generatePie(exporter);
        generateFurnace(exporter);
        generateUtensil(exporter);
        generateMiscShapeless(exporter);
        generateMiscShaped(exporter);
    }

    protected void generateSeeds(final RecipeOutput exporter) {
        for (final FarmlandCrop crop : FarmlandCrop.INSTANCES) {
            TagKey<Item> tag = commonTag(crop.getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, crop.getSeedItem())
                    .requires(tag)
                    .unlockedBy("has_" + crop.getLowercaseName(), RecipeProvider.has(crop))
                    .save( exporter);
        }
    }

    protected void generateSaplings(final RecipeOutput exporter) {
        for (final TreeCrop crop : TreeCrop.INSTANCES) {
            TagKey<Item> tag = commonTag(crop.getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, crop.getSaplingItem())
                    .requires(tag).requires(tag).requires(ItemTags.SAPLINGS)
                    .unlockedBy("has_" + crop.getLowercaseName(), RecipeProvider.has(crop))
                    .save(exporter);
        }
        // Bark saplings come from the leaves, not the crop
    }

    protected void generateBarkWood(final RecipeOutput exporter) {
        for (final Tree crop : Tree.INSTANCES) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, crop.getWood())
                    .pattern("##")
                    .pattern("##")
                    .define('#', crop.getLog())
                    .unlockedBy("has_" + crop.getLowercaseName() + "_log", RecipeProvider.has(crop.getLog()))
                    .save(exporter);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, crop.getStrippedWood())
                    .pattern("##")
                    .pattern("##")
                    .define('#', crop.getStrippedLog())
                    .unlockedBy("has_stripped" + crop.getLowercaseName() + "_log", RecipeProvider.has(crop.getStrippedLog()))
                    .save(exporter);
        }
    }

    protected void generateJams(final RecipeOutput exporter) {
        for (final Jam jam : Jam.INSTANCES) {
            final TagKey<Item> tag = commonTag(jam.getCrop().getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, jam)
                    .requires(tag).requires(Items.SUGAR).requires(Content.COOKING_POT)
                    .unlockedBy("has_" + jam.getCrop().getLowercaseName(), RecipeProvider.has(tag))
                    .save(exporter);
        }
    }

    protected void generateJuices(final RecipeOutput exporter) {
        for (final Juice juice : Juice.INSTANCES) {
            final TagKey<Item> tag = commonTag(juice.getCrop().getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, juice)
                    .requires(tag).requires(Content.FOOD_PRESS).requires(Items.GLASS_BOTTLE)
                    .unlockedBy("has_" + juice.getCrop().getLowercaseName(), RecipeProvider.has(tag))
                    .save(exporter);
        }
    }

    protected void generateSmoothies(final RecipeOutput exporter) {
        for (final Smoothie smoothie : Smoothie.INSTANCES) {
            final TagKey<Item> tag = commonTag(smoothie.getCrop().getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, smoothie)
                    .requires(tag).requires(Items.ICE).requires(commonTag("milks")).requires(Items.GLASS_BOTTLE)
                    .unlockedBy("has_" + smoothie.getCrop().getLowercaseName(), RecipeProvider.has(tag))
                    .save(exporter);
        }
    }

    protected void generateIceCream(final RecipeOutput exporter) {
        for (final IceCream iceCream : IceCream.INSTANCES) {
            final TagKey<Item> tag = commonTag(iceCream.getCrop().getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, iceCream)
                    .requires(tag).requires(Items.SUGAR).requires(Items.EGG).requires(commonTag("milks")).requires(Content.COOKING_POT)
                    .unlockedBy("has_" + iceCream.getCrop().getLowercaseName(), RecipeProvider.has(tag))
                    .save(exporter);
        }
    }

    protected void generatePie(final RecipeOutput exporter) {
        for (final Pie pie : Pie.INSTANCES) {
            final TagKey<Item> tag = commonTag(pie.getCrop().getPlural());
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pie)
                    .requires(tag).requires(Items.SUGAR).requires(Items.EGG).requires(commonTag("flour")).requires(commonTag("doughs")).requires(Content.FRYING_PAN)
                    .unlockedBy("has_" + pie.getCrop().getLowercaseName(), RecipeProvider.has(tag))
                    .save(exporter);
        }
    }

    protected void generateFurnace(final RecipeOutput exporter) {
        var cookingList = new ImmutableMap.Builder<CroptopiaItem, ItemLike>()
                .put(Content.BLACKBEAN, Content.BAKED_BEANS)
                .put(Content.SWEETPOTATO, Content.BAKED_SWEET_POTATO)
                .put(Content.YAM, Content.BAKED_YAM)
                .put(Content.ANCHOVY, Content.COOKED_ANCHOVY)
                .put(Content.CALAMARI, Content.COOKED_CALAMARI)
                .put(Content.GLOWING_CALAMARI, Content.COOKED_CALAMARI)
                .put(Content.SHRIMP, Content.COOKED_SHRIMP)
                .put(Content.TUNA, Content.COOKED_TUNA)
                .put(Content.CORN, Content.POPCORN)
                .put(Content.GRAPE, Content.RAISINS)
                .put(Content.RAW_BACON, Content.COOKED_BACON)
                .build();
        cookingList.forEach((input, output) -> offerFoodCookingRecipe(exporter, input, output));
        // the nuts
        offerFoodCookingRecipe(exporter, Ingredient.of(Tags.NUTS), "nuts", Content.ROASTED_NUTS, RecipeProvider.has(Tags.NUTS));
        // now the vanilla ingredients
        offerFoodCookingRecipe(exporter, Items.SUGAR, "sugar", Content.CARAMEL);
        offerFoodCookingRecipe(exporter, Items.SUGAR_CANE, "sugar_cane", Content.MOLASSES);
        offerFoodCookingRecipe(exporter, Items.BREAD, "bread", Content.TOAST);
        // only salt missing
        offerSmeltingRecipe(exporter, Ingredient.of(Content.WATER_BOTTLE), ItemNamesV2.WATER_BOTTLE, Content.SALT, RecipeCategory.MISC, 800, 0.1f, RecipeProvider.has(Content.WATER_BOTTLE.asTag()));
    }

    protected void offerFoodCookingRecipe(final RecipeOutput exporter, final Ingredient input, final String inputName, final ItemLike output, final Criterion<?> criterion) {
        final int time = 200; // default vanilla time
        final float exp = 0.35f; // default vanilla experience
        offerSmeltingRecipe(exporter, input, inputName, output, RecipeCategory.FOOD, time, exp, criterion);
        offerSmokerRecipe(exporter, input, inputName, output, time / 2, exp, criterion);
        offerCampfireRecipe(exporter, input, inputName, output, time * 3, exp, criterion);
    }

    protected void offerFoodCookingRecipe(final RecipeOutput exporter, final CroptopiaItem input, final ItemLike output) {
        offerFoodCookingRecipe(exporter, Ingredient.of(input.asTag()), input.getLowercaseName(), output, RecipeProvider.has(input.asTag()));
    }

    protected void offerFoodCookingRecipe(final RecipeOutput exporter, final Item input, final String inputName, final ItemLike output) {
        offerFoodCookingRecipe(exporter, Ingredient.of(input), inputName, output, RecipeProvider.has(input));
    }

    protected void offerSmeltingRecipe(final RecipeOutput exporter, final Ingredient input, final String inputName, final ItemLike output, final RecipeCategory category, final int time, final float exp, final Criterion<?> criterion) {
        SimpleCookingRecipeBuilder.smelting(input, category, output, exp, time)
                .unlockedBy("has_" + inputName, criterion)
                .save(exporter, RecipeProvider.getItemName(output) + "_from_" + inputName);
    }

    protected void offerSmokerRecipe(final RecipeOutput exporter, final Ingredient input, final String inputName, final ItemLike output, final int time, final float exp, final Criterion<?> criterion) {
        SimpleCookingRecipeBuilder.smoking(input, RecipeCategory.FOOD, output, exp, time)
                .unlockedBy("has_" + inputName, criterion)
                .save(exporter, RecipeProvider.getItemName(output) + "_from_smoking_" + inputName);
    }

    protected void offerCampfireRecipe(final RecipeOutput exporter, final Ingredient input, final String inputName, final ItemLike output, final int time, final float exp, final Criterion<?> criterion) {
        SimpleCookingRecipeBuilder.campfireCooking(input, RecipeCategory.FOOD, output, exp, time)
                .unlockedBy("has_" + inputName, criterion)
                .save(exporter, RecipeProvider.getItemName(output) + "_from_campfire_" + inputName);
    }

    protected void generateUtensil(final RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.COOKING_POT)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_iron", RecipeProvider.has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FOOD_PRESS)
                .pattern("I")
                .pattern("H")
                .pattern("I")
                .define('I', Items.PISTON).define('H', Items.HOPPER)
                .unlockedBy("has_piston", RecipeProvider.has(Items.PISTON))
                .unlockedBy("has_hopper", RecipeProvider.has(Items.HOPPER))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FRYING_PAN)
                .pattern("#  ")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', Items.IRON_INGOT)
                .unlockedBy("has_iron", RecipeProvider.has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.KNIFE)
                .pattern(" #")
                .pattern("i ")
                .define('i', Items.STICK).define('#', Items.IRON_INGOT)
                .unlockedBy("has_iron", RecipeProvider.has(Items.IRON_INGOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MORTAR_AND_PESTLE)
                .pattern("i")
                .pattern("#")
                .define('i', Items.STICK).define('#', Items.BOWL)
                .unlockedBy("has_bowl", RecipeProvider.has(Items.BOWL))
                .save(exporter);
    }

    protected void generateMiscShapeless(final RecipeOutput exporter) {
        final String has = "has_";
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DEAD_BUSH)
                .requires(Content.SALT.asTag()).requires(ItemTags.SAPLINGS)
                .unlockedBy(has + ItemNamesV2.SALT, RecipeProvider.has(Content.SALT.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CANDIED_KUMQUATS, 7)
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.KUMQUAT.asTag())
                .requires(Content.VANILLA.asTag())
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy(has + ItemNamesV2.KUMQUAT, RecipeProvider.has(Content.KUMQUAT.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE, 2)
                .requires(Content.TURMERIC.asTag())
                .requires(Content.TURMERIC.asTag())
                .requires(Content.TURMERIC.asTag())
                .unlockedBy(has + ItemNamesV2.TURMERIC, RecipeProvider.has(Content.TURMERIC.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 2)
                .requires(Content.GRAPE.asTag())
                .requires(Content.GRAPE.asTag())
                .requires(Content.GRAPE.asTag())
                .unlockedBy(has + ItemNamesV2.GRAPE, RecipeProvider.has(Content.GRAPE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TORTILLA, 2)
                .requires(Content.FLOUR.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .unlockedBy(has + ItemNamesV2.FLOUR, RecipeProvider.has(Content.FLOUR.asTag()))
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
    }

    protected void generateMiscShaped(final RecipeOutput exporter) {
        final String has = "has_";
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_PUMPKIN_SEEDS)
                .pattern("123")
                .pattern(" 4 ")
                .define('1', Items.PUMPKIN_SEEDS)
                .define('3', Content.PEPPER.asTag())
                .define('2', Content.SALT.asTag())
                .define('4', Content.FRYING_PAN.asTag())
                .unlockedBy("has_pumpkin_seed", RecipeProvider.has(Items.PUMPKIN_SEEDS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_SUNFLOWER_SEEDS)
                .pattern("123")
                .pattern(" 4 ")
                .define('1', Items.SUNFLOWER)
                .define('3', Content.PEPPER.asTag())
                .define('2', Content.SALT.asTag())
                .define('4', Content.FRYING_PAN.asTag())
                .unlockedBy("has_sunflower", RecipeProvider.has(Items.SUNFLOWER))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PUMPKIN_BARS, 3)
                .pattern("586")
                .pattern("124")
                .pattern("373")
                .define('1', Items.EGG)
                .define('2', Items.SUGAR)
                .define('3', Items.PUMPKIN)
                .define('4', Content.FLOUR.asTag())
                .define('5', Content.CINNAMON.asTag())
                .define('6', Content.SALT.asTag())
                .define('7', Content.BUTTER.asTag())
                .define('8', Content.VANILLA.asTag())
                .unlockedBy("has_pumpkin", RecipeProvider.has(Items.PUMPKIN))
                .unlockedBy(has + ItemNamesV2.CINNAMON, RecipeProvider.has(Content.CINNAMON.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CORN_BREAD)
                .pattern("111")
                .define('1', Content.CORN.asTag())
                .unlockedBy(has + ItemNamesV2.CORN, RecipeProvider.has(Content.CORN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PUMPKIN_SOUP, 2)
                .pattern("123")
                .pattern(" 5 ")
                .pattern("464")
                .define('1', Content.ONION.asTag())
                .define('2', Content.GARLIC.asTag())
                .define('3', Content.PEPPER.asTag())
                .define('4', Items.PUMPKIN)
                .define('5', Content.SALT.asTag())
                .define('6', Content.COOKING_POT)
                .unlockedBy("has_pumpkin", RecipeProvider.has(Items.PUMPKIN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MERINGUE, 2)
                .pattern("243")
                .pattern("111")
                .define('1', Items.EGG)
                .define('2', Content.SALT.asTag())
                .define('3', Items.SUGAR)
                .define('4', Content.VANILLA.asTag())
                .unlockedBy("has_egg", RecipeProvider.has(Items.EGG))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CABBAGE_ROLL, 2)
                .pattern("121")
                .pattern("456")
                .pattern("585")
                .define('8', Content.FRYING_PAN)
                .define('1', croptopiaTag("beef_replacements"))
                .define('2', Content.ONION.asTag())
                .define('6', Content.RICE.asTag())
                .define('4', Content.SALT.asTag())
                .define('5', Content.CABBAGE.asTag())
                .unlockedBy(has + ItemNamesV2.CABBAGE, RecipeProvider.has(Content.CABBAGE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BORSCHT, 2)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .define('1', Items.CARROT)
                .define('2', Items.POTATO)
                .define('3', Items.BEETROOT)
                .define('4', Content.ONION.asTag())
                .define('5', Content.TOMATO.asTag())
                .define('6', Content.WATER_BOTTLE.asTag())
                .define('8', Content.COOKING_POT.asTag())
                .define('7', Content.CABBAGE.asTag())
                .define('9', Content.GARLIC.asTag())
                .unlockedBy("has_beetroot", RecipeProvider.has(Items.BEETROOT))
                .unlockedBy(has + ItemNamesV2.CABBAGE, RecipeProvider.has(Content.CABBAGE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GOULASH)
                .pattern("123")
                .pattern("454")
                .pattern("183")
                .define('8', Content.FRYING_PAN.asTag())
                .define('1', croptopiaTag("pork_replacements"))
                .define('3', croptopiaTag("beef_replacements"))
                .define('2', Content.ONION.asTag())
                .define('4', Content.CABBAGE.asTag())
                .define('5', Content.TOMATO.asTag())
                .unlockedBy(has + ItemNamesV2.CABBAGE, RecipeProvider.has(Content.CABBAGE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BEETROOT_SALAD)
                .pattern("111")
                .pattern("745")
                .pattern(" 6 ")
                .define('1', Items.BEETROOT)
                .define('4', Content.CHEESE.asTag())
                .define('5', Content.LEMON.asTag())
                .define('6', Content.COOKING_POT.asTag())
                .define('7', Content.LETTUCE.asTag())
                .unlockedBy("has_beetroot", RecipeProvider.has(Items.BEETROOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STEAMED_CRAB)
                .pattern("1")
                .pattern("2")
                .pattern("3")
                .define('1', Content.CRAB.asTag())
                .define('2', Content.WATER_BOTTLE.asTag())
                .define('3', Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.CRAB, RecipeProvider.has(Content.CRAB.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.DEEP_FRIED_SHRIMP, 2)
                .pattern("111")
                .pattern("456")
                .define('1', Content.SHRIMP.asTag())
                .define('4', Items.EGG)
                .define('6', Items.BREAD)
                .define('5', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.SHRIMP, RecipeProvider.has(Content.SHRIMP.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.TUNA_ROLL, 2)
                .pattern("234")
                .pattern(" 1 ")
                .define('1', Content.TUNA.asTag())
                .define('2', Items.DRIED_KELP)
                .define('3', Content.RICE.asTag())
                .define('4', Content.ONION.asTag())
                .unlockedBy(has + ItemNamesV2.TUNA, RecipeProvider.has(Content.TUNA.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FRIED_CALAMARI, 2)
                .pattern("123")
                .pattern("456")
                .define('1', Content.CALAMARI.asTag())
                .define('2', Content.LEMON.asTag())
                .define('3', Content.OLIVE_OIL.asTag())
                .define('4', Content.FLOUR.asTag())
                .define('5', Content.FRYING_PAN.asTag())
                .define('6', Content.SEA_LETTUCE.asTag())
                .unlockedBy(has + ItemNamesV2.CALAMARI, RecipeProvider.has(Content.CALAMARI.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CRAB_LEGS, 2)
                .pattern("123")
                .pattern("455")
                .pattern(" 7 ")
                .define('5', Content.CRAB.asTag())
                .define('1', Content.BUTTER.asTag())
                .define('2', Content.GARLIC.asTag())
                .define('3', Content.SALT.asTag())
                .define('4', Content.PEPPER.asTag())
                .define('7', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.CRAB, RecipeProvider.has(Content.CRAB.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STEAMED_CLAMS, 2)
                .pattern("123")
                .pattern("455")
                .pattern(" 7 ")
                .define('5', Content.CLAM.asTag())
                .define('1', Content.BUTTER.asTag())
                .define('2', Content.GARLIC.asTag())
                .define('3', Content.SALT.asTag())
                .define('4', Content.PEPPER.asTag())
                .define('7', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.CLAM, RecipeProvider.has(Content.CLAM.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GRILLED_OYSTERS, 2)
                .pattern("121")
                .pattern("456")
                .pattern(" 7 ")
                .define('1', Content.OYSTER.asTag())
                .define('2', Content.CHEESE.asTag())
                .define('4', Content.LEMON.asTag())
                .define('5', Content.GARLIC.asTag())
                .define('6', Content.SALT.asTag())
                .define('7', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.OYSTER, RecipeProvider.has(Content.GRILLED_OYSTERS.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ANCHOVY_PIZZA, 1)
                .pattern("123")
                .pattern(" 4 ")
                .pattern(" 7 ")
                .define('1', Content.TOMATO.asTag())
                .define('2', Content.ANCHOVY.asTag())
                .define('3', Content.CHEESE.asTag())
                .define('4', Content.DOUGH.asTag())
                .define('7', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.ANCHOVY, RecipeProvider.has(Content.ANCHOVY.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MASHED_POTATOES, 1)
                .pattern("1 ")
                .pattern("24")
                .pattern("3 ")
                .define('1', commonTag("potatoes"))
                .define('2', Content.SALT.asTag())
                .define('3', Content.MORTAR_AND_PESTLE.asTag())
                .define('4', commonTag("milks"))
                .unlockedBy("has_milk", RecipeProvider.has(Items.MILK_BUCKET))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SWEET_CREPES, 1)
                .pattern("123")
                .pattern("4 5")
                .pattern(" 6 ")
                .define('1', Content.FLOUR.asTag())
                .define('2', Items.EGG)
                .define('3', commonTag("milks"))
                .define('4', Tags.JAMS)
                .define('5', Items.SUGAR)
                .define('6', Content.FRYING_PAN.asTag())
                .unlockedBy("has_jam", RecipeProvider.has(Tags.JAMS))
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BAKED_CREPES, 1)
                .pattern("121")
                .pattern("356")
                .pattern(" 7 ")
                .define('1', Items.EGG)
                .define('2', Content.FLOUR.asTag())
                .define('3', commonTag("milks"))
                .define('7', Content.FRYING_PAN.asTag())
                .define('6', Content.CHEESE.asTag())
                .define('5', Content.SPINACH.asTag())
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.QUICHE, 1)
                .pattern(" 1 ")
                .pattern("234")
                .pattern("5 6")
                .define('1', Content.FRYING_PAN)
                .define('5', Content.FLOUR.asTag())
                .define('6', Content.ONION.asTag())
                .define('2', commonTag("milks"))
                .define('3', Items.EGG)
                .define('4', Content.SPINACH.asTag())
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.DAUPHINE_POTATOES, 1)
                .pattern("213")
                .pattern("456")
                .define('1', Content.FRYING_PAN.asTag())
                .define('2', Content.WATER_BOTTLE.asTag())
                .define('3', commonTag("milks"))
                .define('4', Content.BUTTER.asTag())
                .define('5', Content.FLOUR.asTag())
                .define('6', Content.OLIVE_OIL.asTag())
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CROQUE_MONSIEUR, 1)
                .pattern(" 1 ")
                .pattern(" 26")
                .pattern("435")
                .define('1', Content.FRYING_PAN)
                .define('2', Items.BREAD)
                .define('3', Content.CHEESE.asTag())
                .define('4', croptopiaTag("pork_replacements"))
                .define('5', Content.BUTTER.asTag())
                .define('6', Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CROQUE_MADAME, 1)
                .pattern(" 1 ")
                .pattern("726")
                .pattern("435")
                .define('1', Content.FRYING_PAN.asTag())
                .define('2', Items.BREAD)
                .define('3', Content.CHEESE.asTag())
                .define('4', croptopiaTag("pork_replacements"))
                .define('5', Content.BUTTER.asTag())
                .define('6', Content.FLOUR.asTag())
                .define('7', Items.EGG)
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SUNNY_SIDE_EGGS, 2)
                .pattern("121")
                .define('2', Content.FRYING_PAN.asTag())
                .define('1', Items.EGG)
                .unlockedBy("has_egg", RecipeProvider.has(Items.EGG))
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MACARON, 2)
                .pattern("122")
                .pattern("565")
                .define('1', Items.EGG)
                .define('2', Items.SUGAR)
                .define('5', Content.ALMOND.asTag())
                .define('6', Content.FOOD_PRESS)
                .unlockedBy(has + ItemNamesV2.FOOD_PRESS, RecipeProvider.has(Content.FOOD_PRESS.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.THE_BIG_BREAKFAST, 1)
                .pattern("123")
                .pattern("736")
                .pattern(" 45")
                .define('7', Content.FRYING_PAN.asTag())
                .define('1', Items.EGG)
                .define('2', Content.RAW_BACON.asTag())
                .define('3', Content.HASHED_BROWN.asTag())
                .define('4', Content.BAKED_BEANS.asTag())
                .define('5', Content.SAUSAGE.asTag())
                .define('6', Content.TOAST.asTag())
                .unlockedBy(has + ItemNamesV2.SAUSAGE, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GROUND_PORK, 2)
                .pattern("1")
                .pattern("2")
                .define('1', croptopiaTag("pork_replacements"))
                .define('2', Content.FOOD_PRESS)
                .unlockedBy(has + ItemNamesV2.FOOD_PRESS, RecipeProvider.has(Content.FOOD_PRESS.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SAUSAGE, 1)
                .pattern("1")
                .pattern("2")
                .pattern("3")
                .define('1', Content.GROUND_PORK.asTag())
                .define('2', Content.SALT.asTag())
                .define('3', Content.PAPRIKA.asTag())
                .unlockedBy(has + ItemNamesV2.GROUND_PORK, RecipeProvider.has(Content.GROUND_PORK.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CINNAMON_ROLL, 3)
                .pattern("123")
                .pattern("456")
                .pattern("798")
                .define('1', commonTag("milks"))
                .define('2', Content.DOUGH.asTag())
                .define('3', Items.EGG)
                .define('4', Content.BUTTER.asTag())
                .define('5', Content.SALT.asTag())
                .define('6', Items.SUGAR)
                .define('7', Content.CINNAMON.asTag())
                .define('8', Content.WHIPPING_CREAM.asTag())
                .define('9', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.HASHED_BROWN, 4)
                .pattern("123")
                .pattern(" 4 ")
                .define('4', Content.KNIFE.asTag())
                .define('1', commonTag("potatoes"))
                .define('2', Content.FRYING_PAN.asTag())
                .define('3', Content.OLIVE_OIL.asTag())
                .unlockedBy(has + ItemNamesV2.FRYING_PAN, RecipeProvider.has(Content.FRYING_PAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BEEF_JERKY, 14)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .define('1', Items.BEEF)
                .define('2', Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.SALT, RecipeProvider.has(Content.SALT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PORK_JERKY, 14)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .define('1', Items.PORKCHOP)
                .define('2', Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.SALT, RecipeProvider.has(Content.SALT.asTag()))
                .save(exporter);
    }

    private TagKey<Item> croptopiaTag(final String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, name));
    }

    public static TagKey<Item> commonTag(final String name) {
        IdentifierAccessor accessor = (IdentifierAccessor) CroptopiaMod.createCommonIdentifier(name);
        return TagKey.create(Registries.ITEM, (ResourceLocation) accessor);
    }

}
