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
        final TagKey<Item> saltTag = commonTag("salts");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DEAD_BUSH)
                .requires(saltTag).requires(ItemTags.SAPLINGS)
                .unlockedBy("has_salts", RecipeProvider.has(saltTag))
                .save(exporter);
        final TagKey<Item> kumquatTag = commonTag(Content.KUMQUAT.getPlural());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CANDIED_KUMQUATS, 7)
                .requires(kumquatTag)
                .requires(kumquatTag)
                .requires(kumquatTag)
                .requires(kumquatTag)
                .requires(kumquatTag)
                .requires(kumquatTag)
                .requires(kumquatTag)
                .requires(commonTag("vanilla"))
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy("has_kumquat", RecipeProvider.has(Content.KUMQUAT))
                .save(exporter);
        final TagKey<Item> turmericTag = commonTag(Content.TURMERIC.getPlural());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE, 2)
                .requires(turmericTag)
                .requires(turmericTag)
                .requires(turmericTag)
                .unlockedBy("has_turmeric", RecipeProvider.has(Content.TURMERIC))
                .save(exporter);
        final TagKey<Item> grapeTag = commonTag(Content.GRAPE.getPlural());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 2)
                .requires(grapeTag)
                .requires(grapeTag)
                .requires(grapeTag)
                .unlockedBy("has_grape", RecipeProvider.has(Content.GRAPE))
                .save(exporter);
    }

    protected void generateMiscShaped(final RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_PUMPKIN_SEEDS)
                .pattern("123")
                .pattern(" 4 ")
                .define('1', Items.PUMPKIN_SEEDS)
                .define('3', Content.PEPPER.asItem())
                .define('2', commonTag("salts"))
                .define('4', Content.FRYING_PAN)
                .unlockedBy("has_pumpkin_seed", RecipeProvider.has(Items.PUMPKIN_SEEDS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_SUNFLOWER_SEEDS)
                .pattern("123")
                .pattern(" 4 ")
                .define('1', Items.SUNFLOWER)
                .define('3', Content.PEPPER.asItem())
                .define('2', commonTag("salts"))
                .define('4', Content.FRYING_PAN)
                .unlockedBy("has_sunflower", RecipeProvider.has(Items.SUNFLOWER))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PUMPKIN_BARS, 3)
                .pattern("586")
                .pattern("124")
                .pattern("373")
                .define('1', Items.EGG)
                .define('2', Items.SUGAR)
                .define('3', Items.PUMPKIN)
                .define('4', commonTag("flour"))
                .define('5', Content.CINNAMON)
                .define('6', commonTag("salts"))
                .define('7', commonTag("butters"))
                .define('8', commonTag("vanilla"))
                .unlockedBy("has_pumpkin", RecipeProvider.has(Items.PUMPKIN))
                .unlockedBy("has_cinnamon", RecipeProvider.has(Content.CINNAMON))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CORN_BREAD)
                .pattern("111")
                .define('1', commonTag("corn"))
                .unlockedBy("has_corn", RecipeProvider.has(Content.CORN.asItem()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PUMPKIN_SOUP, 2)
                .pattern("123")
                .pattern(" 5 ")
                .pattern("464")
                .define('1', commonTag("onions"))
                .define('2', commonTag("garlic"))
                .define('3', Content.PEPPER.asItem())
                .define('4', Items.PUMPKIN)
                .define('5', commonTag("salts"))
                .define('6', Content.COOKING_POT)
                .unlockedBy("has_pumpkin", RecipeProvider.has(Items.PUMPKIN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MERINGUE, 2)
                .pattern("243")
                .pattern("111")
                .define('1', Items.EGG)
                .define('2', commonTag("salts"))
                .define('3', Items.SUGAR)
                .define('4', commonTag("vanilla"))
                .unlockedBy("has_egg", RecipeProvider.has(Items.EGG))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CABBAGE_ROLL, 2)
                .pattern("121")
                .pattern("456")
                .pattern("585")
                .define('8', Content.FRYING_PAN)
                .define('1', croptopiaTag("beef_replacements"))
                .define('2', commonTag("onions"))
                .define('6', commonTag("rice"))
                .define('4', commonTag("salts"))
                .define('5', commonTag("cabbage"))
                .unlockedBy("has_cabbage", RecipeProvider.has(Content.CABBAGE.asItem()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BORSCHT, 2)
                .pattern("123")
                .pattern("456")
                .pattern("789")
                .define('1', Items.CARROT)
                .define('2', Items.POTATO)
                .define('3', Items.BEETROOT)
                .define('4', commonTag("onions"))
                .define('5', commonTag("tomatoes"))
                .define('6', commonTag("water_bottles"))
                .define('8', Content.COOKING_POT)
                .define('7', commonTag("cabbage"))
                .define('9', commonTag("garlic"))
                .unlockedBy("has_cabbage", RecipeProvider.has(Content.CABBAGE.asItem()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GOULASH)
                .pattern("123")
                .pattern("454")
                .pattern("183")
                .define('8', Content.FRYING_PAN)
                .define('1', croptopiaTag("pork_replacements"))
                .define('3', croptopiaTag("beef_replacements"))
                .define('2', commonTag("onions"))
                .define('4', commonTag("cabbage"))
                .define('5', commonTag("tomatoes"))
                .unlockedBy("has_cabbage", RecipeProvider.has(Content.CABBAGE.asItem()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BEETROOT_SALAD)
                .pattern("111")
                .pattern("745")
                .pattern(" 6 ")
                .define('1', Items.BEETROOT)
                .define('4', commonTag("cheeses"))
                .define('5', commonTag("lemons"))
                .define('6', Content.COOKING_POT)
                .define('7', commonTag("lettuce"))
                .unlockedBy("has_beetroot", RecipeProvider.has(Items.BEETROOT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STEAMED_CRAB)
                .pattern("1")
                .pattern("2")
                .pattern("3")
                .define('1', commonTag("crabs"))
                .define('2', commonTag("water_bottles"))
                .define('3', Content.COOKING_POT)
                .unlockedBy("has_crab", RecipeProvider.has(Content.CRAB))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.DEEP_FRIED_SHRIMP, 2)
                .pattern("111")
                .pattern("456")
                .define('1', commonTag("shrimp"))
                .define('4', Items.EGG)
                .define('6', Items.BREAD)
                .define('5', Content.FRYING_PAN)
                .unlockedBy("has_shrimp", RecipeProvider.has(Content.SHRIMP))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.TUNA_ROLL, 2)
                .pattern("234")
                .pattern(" 1 ")
                .define('1', commonTag("tuna"))
                .define('2', Items.DRIED_KELP)
                .define('3', commonTag("rice"))
                .define('4', commonTag("onions"))
                .unlockedBy("has_tuna", RecipeProvider.has(Content.TUNA))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FRIED_CALAMARI, 2)
                .pattern("123")
                .pattern("456")
                .define('1', commonTag("calamari"))
                .define('2', commonTag("lemons"))
                .define('3', commonTag("olive_oils"))
                .define('4', commonTag("flour"))
                .define('5', Content.FRYING_PAN)
                .define('6', commonTag("sea_lettuce"))
                .unlockedBy("has_calamari", RecipeProvider.has(Content.CALAMARI))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CRAB_LEGS, 2)
                .pattern("123")
                .pattern("455")
                .pattern(" 7 ")
                .define('5', commonTag("crabs"))
                .define('1', commonTag("butters"))
                .define('2', commonTag("garlic"))
                .define('3', commonTag("salts"))
                .define('4', Content.PEPPER.asItem())
                .define('7', Content.FRYING_PAN)
                .unlockedBy("has_crab", RecipeProvider.has(Content.CRAB))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STEAMED_CLAMS, 2)
                .pattern("123")
                .pattern("455")
                .pattern(" 7 ")
                .define('5', commonTag("clams"))
                .define('1', commonTag("butters"))
                .define('2', commonTag("garlic"))
                .define('3', commonTag("salts"))
                .define('4', Content.PEPPER.asItem())
                .define('7', Content.FRYING_PAN)
                .unlockedBy("has_clams", RecipeProvider.has(Content.CLAM))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GRILLED_OYSTERS, 2)
                .pattern("121")
                .pattern("456")
                .pattern(" 7 ")
                .define('1', commonTag("oysters"))
                .define('2', commonTag("cheeses"))
                .define('4', commonTag("lemons"))
                .define('5', commonTag("garlic"))
                .define('6', commonTag("salts"))
                .define('7', Content.FRYING_PAN)
                .unlockedBy("has_oysters", RecipeProvider.has(Content.GRILLED_OYSTERS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ANCHOVY_PIZZA, 1)
                .pattern("123")
                .pattern(" 4 ")
                .pattern(" 7 ")
                .define('1', commonTag("tomatoes"))
                .define('2', commonTag("anchovies"))
                .define('3', commonTag("cheeses"))
                .define('4', commonTag("doughs"))
                .define('7', Content.FRYING_PAN)
                .unlockedBy("has_anchovies", RecipeProvider.has(Content.ANCHOVY))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MASHED_POTATOES, 1)
                .pattern("1 ")
                .pattern("24")
                .pattern("3 ")
                .define('1', commonTag("potatoes"))
                .define('2', commonTag("salts"))
                .define('3', Content.MORTAR_AND_PESTLE)
                .define('4', commonTag("milks"))
                .unlockedBy("has_milk", RecipeProvider.has(Items.MILK_BUCKET))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TORTILLA, 2)
                .requires(commonTag("flour"))
                .requires(Content.FRYING_PAN)
                .requires(commonTag("water_bottles"))
                .unlockedBy("took_flour", RecipeProvider.has(commonTag("flour")))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SWEET_CREPES, 1)
                .pattern("123")
                .pattern("4 5")
                .pattern(" 6 ")
                .define('1', commonTag("flour"))
                .define('2', Items.EGG)
                .define('3', commonTag("milks"))
                .define('4', commonTag("jams"))
                .define('5', Items.SUGAR)
                .define('6', Content.FRYING_PAN)
                .unlockedBy("took_flour", RecipeProvider.has(commonTag("flour")))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BAKED_CREPES, 1)
                .pattern("121")
                .pattern("356")
                .pattern(" 7 ")
                .define('1', Items.EGG)
                .define('2', commonTag("flour"))
                .define('3', commonTag("milks"))
                .define('7', Content.FRYING_PAN)
                .define('6', commonTag("cheeses"))
                .define('5', commonTag("spinach"))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.QUICHE, 1)
                .pattern(" 1 ")
                .pattern("234")
                .pattern("5 6")
                .define('1', Content.FRYING_PAN)
                .define('5', commonTag("flour"))
                .define('6', commonTag("onions"))
                .define('2', commonTag("milks"))
                .define('3', Items.EGG)
                .define('4', commonTag("spinach"))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.DAUPHINE_POTATOES, 1)
                .pattern("213")
                .pattern("456")
                .define('1', Content.FRYING_PAN)
                .define('2', commonTag("water_bottles"))
                .define('3', commonTag("milks"))
                .define('4', commonTag("butters"))
                .define('5', commonTag("flour"))
                .define('6', commonTag("olive_oils"))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CROQUE_MONSIEUR, 1)
                .pattern(" 1 ")
                .pattern(" 26")
                .pattern("435")
                .define('1', Content.FRYING_PAN)
                .define('2', Items.BREAD)
                .define('3', commonTag("cheeses"))
                .define('4', croptopiaTag("pork_replacements"))
                .define('5', commonTag("butters"))
                .define('6', commonTag("flour"))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CROQUE_MADAME, 1)
                .pattern(" 1 ")
                .pattern("726")
                .pattern("435")
                .define('1', Content.FRYING_PAN)
                .define('2', Items.BREAD)
                .define('3', commonTag("cheeses"))
                .define('4', croptopiaTag("pork_replacements"))
                .define('5', commonTag("butters"))
                .define('6', commonTag("flour"))
                .define('7', Items.EGG)
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SUNNY_SIDE_EGGS, 2)
                .pattern("121")
                .define('2', Content.FRYING_PAN)
                .define('1', Items.EGG)
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MACARON, 2)
                .pattern("122")
                .pattern("565")
                .define('1', Items.EGG)
                .define('2', Items.SUGAR)
                .define('5', commonTag("almonds"))
                .define('6', Content.FOOD_PRESS)
                .unlockedBy("has_food_press", RecipeProvider.has(Content.FOOD_PRESS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.THE_BIG_BREAKFAST, 1)
                .pattern("123")
                .pattern("736")
                .pattern(" 45")
                .define('7', Content.FRYING_PAN)
                .define('1', Items.EGG)
                .define('2', Content.RAW_BACON)
                .define('3', Content.HASHED_BROWN)
                .define('4', Content.BAKED_BEANS)
                .define('5', commonTag("sausages"))
                .define('6', Content.TOAST)
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GROUND_PORK, 2)
                .pattern("1")
                .pattern("2")
                .define('1', croptopiaTag("pork_replacements"))
                .define('2', Content.FOOD_PRESS)
                .unlockedBy("has_food_press", RecipeProvider.has(Content.FOOD_PRESS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SAUSAGE, 1)
                .pattern("1")
                .pattern("2")
                .pattern("3")
                .define('1', commonTag("ground_pork"))
                .define('2', commonTag("salts"))
                .define('3', commonTag("paprika"))
                .unlockedBy("has_ground_pork", RecipeProvider.has(Content.GROUND_PORK))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CINNAMON_ROLL, 3)
                .pattern("123")
                .pattern("456")
                .pattern("798")
                .define('1', commonTag("milks"))
                .define('2', commonTag("doughs"))
                .define('3', Items.EGG)
                .define('4', commonTag("butters"))
                .define('5', commonTag("salts"))
                .define('6', Items.SUGAR)
                .define('7', commonTag("cinnamon"))
                .define('8', Content.WHIPPING_CREAM)
                .define('9', Content.FRYING_PAN)
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.HASHED_BROWN, 4)
                .pattern("123")
                .pattern(" 4 ")
                .define('4', Content.KNIFE)
                .define('1', commonTag("potatoes"))
                .define('2', Content.FRYING_PAN)
                .define('3', commonTag("olive_oils"))
                .unlockedBy("has_frying_pan", RecipeProvider.has(Content.FRYING_PAN))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Content.BEEF_JERKY, 14)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .define('1', Items.BEEF)
                .define('2', commonTag("salts"))
                .unlockedBy("has_salt", RecipeProvider.has(Content.SALT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Content.PORK_JERKY, 14)
                .pattern("111")
                .pattern("121")
                .pattern("111")
                .define('1', Items.PORKCHOP)
                .define('2', commonTag("salts"))
                .unlockedBy("has_salt", RecipeProvider.has(Content.SALT))
                .save(exporter);
        //cooked frog leg	furnace

    }

    private TagKey<Item> croptopiaTag(final String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MiscNames.MOD_ID, name));
    }

    public static TagKey<Item> commonTag(final String name) {
        IdentifierAccessor accessor = (IdentifierAccessor) CroptopiaMod.createCommonIdentifier(name);
        return TagKey.create(Registries.ITEM, (ResourceLocation) accessor);
    }

}
