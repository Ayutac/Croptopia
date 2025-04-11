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

// when changing/adding recipes, remember to change the eatbig advancement as well!!
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
        final TagKey<Item> milks = commonTag("milks");
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.ALMOND_BRITTLE, 2)
                .requires(Content.BUTTER.asTag())
                .requires(Content.ALMOND.asTag())
                .requires(Items.SUGAR)
                .requires(Items.SUGAR)
                .unlockedBy(has + ItemNamesV2.ALMOND, RecipeProvider.has(Content.ALMOND.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.ARTICHOKE_DIP, 1)
                .requires(Content.ARTICHOKE.asTag())
                .requires(Content.CHEESE.asTag())
                .unlockedBy(has + ItemNamesV2.ARTICHOKE, RecipeProvider.has(Content.ARTICHOKE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BANANA_CREAM_PIE, 1)
                .requires(Content.BANANA.asTag())
                .requires(Content.VANILLA.asTag())
                .requires(Items.SUGAR)
                .requires(Items.EGG)
                .requires(milks)
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.BANANA, RecipeProvider.has(Content.BANANA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BANANA_NUT_BREAD, 2)
                .requires(Content.CINNAMON.asTag())
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .requires(Content.BANANA.asTag())
                .requires(Tags.NUTS)
                .unlockedBy(has + ItemNamesV2.BANANA, RecipeProvider.has(Content.BANANA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BEER, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.HOPS.asTag())
                .requires(Content.BARLEY.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.HOPS, RecipeProvider.has(Content.HOPS.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BLT, 1)
                .requires(Items.BREAD)
                .requires(Content.COOKED_BACON.asTag())
                .requires(Content.LETTUCE.asTag())
                .requires(Content.TOMATO.asTag())
                .unlockedBy(has + ItemNamesV2.COOKED_BACON, RecipeProvider.has(Content.COOKED_BACON.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BROWNIES, 1)
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .requires(milks)
                .requires(Items.EGG)
                .requires(Content.CHOCOLATE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.CHOCOLATE, RecipeProvider.has(Content.CHOCOLATE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BUTTER, 1)
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .requires(milks)
                .requires(Content.SALT.asTag())
                .unlockedBy("has_milk", RecipeProvider.has(milks))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.BUTTERED_TOAST, 1)
                .requires(Content.TOAST.asTag())
                .requires(Content.BUTTER.asTag())
                .unlockedBy(has + ItemNamesV2.TOAST, RecipeProvider.has(Content.TOAST.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CAESAR_SALAD, 1)
                .requires(Items.BOWL)
                .requires(Content.LETTUCE.asTag())
                .requires(Content.OLIVE.asTag())
                .requires(Content.GARLIC.asTag())
                .requires(Content.TOAST.asTag())
                .unlockedBy(has + ItemNamesV2.OLIVE, RecipeProvider.has(Content.OLIVE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CANDIED_NUTS, 4)
                .requires(Tags.NUTS)
                .requires(Tags.NUTS)
                .requires(Items.SUGAR)
                .requires(Items.SUGAR)
                .unlockedBy(has + MiscNames.NUTS, RecipeProvider.has(Tags.NUTS))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CANDY_CORN, 1)
                .requires(Items.SUGAR)
                .requires(Content.CORN.asTag())
                .requires(Items.SUGAR)
                .unlockedBy(has + ItemNamesV2.CORN, RecipeProvider.has(Content.CORN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CARNITAS, 1)
                .requires(croptopiaTag("pork_replacements"))
                .requires(Content.TORTILLA.asTag())
                .requires(Content.CABBAGE.asTag())
                .requires(Content.ONION.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.TORTILLA, RecipeProvider.has(Content.TORTILLA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CASHEW_CHICKEN, 1)
                .requires(Content.CASHEW.asTag())
                .requires(Items.COOKED_CHICKEN)
                .requires(Content.SOY_SAUCE.asTag())
                .requires(Content.CABBAGE.asTag())
                .requires(Items.CARROT)
                .unlockedBy(has + ItemNamesV2.CASHEW, RecipeProvider.has(Content.CASHEW.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHEESE, 1)
                .requires(Content.COOKING_POT.asTag())
                .requires(milks)
                .requires(Content.SALT.asTag())
                .unlockedBy("has_milk", RecipeProvider.has(milks))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHEESE_PIZZA, 1)
                .requires(Content.DOUGH.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.CHEESE, RecipeProvider.has(Content.CHEESE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHEESEBURGER, 1)
                .requires(Items.BREAD)
                .requires(Content.CHEESE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .requires(croptopiaTag("beef_replacements"))
                .unlockedBy(has + ItemNamesV2.CHEESE, RecipeProvider.has(Content.CHEESE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHICKEN_AND_DUMPLINGS, 1)
                .requires(Content.DOUGH.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(croptopiaTag("chicken_replacements"))
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.DOUGH, RecipeProvider.has(Content.DOUGH.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHICKEN_AND_NOODLES, 1)
                .requires(Content.NOODLE.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .requires(croptopiaTag("chicken_replacements"))
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.NOODLE, RecipeProvider.has(Content.NOODLE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHILI_RELLENO, 1)
                .requires(Items.EGG)
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .requires(Content.FLOUR.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.CHILE_PEPPER, RecipeProvider.has(Content.CHILE_PEPPER.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHIMICHANGA, 1)
                .requires(Content.BURRITO.asTag())
                .requires(Content.FLOUR.asTag())
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.BURRITO, RecipeProvider.has(Content.BURRITO.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHOCOLATE, 4)
                .requires(Items.COCOA_BEANS)
                .requires(Content.BUTTER.asTag())
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy("has_cocoa_beans", RecipeProvider.has(Items.COCOA_BEANS))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHOCOLATE_MILKSHAKE, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.CHOCOLATE.asTag())
                .requires(milks)
                .requires(Content.VANILLA_ICE_CREAM.asTag())
                .unlockedBy(has + ItemNamesV2.CHOCOLATE, RecipeProvider.has(Content.CHOCOLATE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CHURROS, 3)
                .requires(milks)
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .requires(Content.CINNAMON.asTag())
                .unlockedBy(has + ItemNamesV2.CINNAMON, RecipeProvider.has(Content.CINNAMON.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.COFFEE, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.COFFEE_BEANS.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.COFFEE_BEANS, RecipeProvider.has(Content.COFFEE_BEANS.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CREMA, 4)
                .requires(milks)
                .requires(Content.LIME.asTag())
                .requires(Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.LIME, RecipeProvider.has(Content.LIME.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.CUCUMBER_SALAD, 1)
                .requires(Items.BOWL)
                .requires(Content.CUCUMBER.asTag())
                .requires(Content.LETTUCE.asTag())
                .requires(Content.SPINACH.asTag())
                .unlockedBy(has + ItemNamesV2.CUCUMBER, RecipeProvider.has(Content.CUCUMBER.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.DOUGH, 1)
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.FLOUR, RecipeProvider.has(Content.FLOUR.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.DOUGHNUT, 1)
                .requires(Content.FLOUR.asTag())
                .requires(milks)
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.FLOUR, RecipeProvider.has(Content.FLOUR.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.EGG_ROLL, 1)
                .requires(Content.DOUGH.asTag())
                .requires(Content.LETTUCE.asTag())
                .requires(Items.EGG)
                .requires(croptopiaTag("meat_replacements"))
                .unlockedBy("has_egg", RecipeProvider.has(Items.EGG))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.ENCHILADA, 2)
                .requires(croptopiaTag("meat_replacements"))
                .requires(Content.TOMATO.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.TORTILLA.asTag())
                .unlockedBy(has + ItemNamesV2.TORTILLA, RecipeProvider.has(Content.TORTILLA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.FAJITAS, 2)
                .requires(croptopiaTag("meat_replacements"))
                .requires(Content.BELLPEPPER.asTag())
                .requires(Content.ONION.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.BELLPEPPER, RecipeProvider.has(Content.BELLPEPPER.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.FLOUR, 1)
                .requires(croptopiaTag("flourable"))
                .requires(croptopiaTag("flourable"))
                .unlockedBy("has_flourable", RecipeProvider.has(croptopiaTag("flourable")))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.FRENCH_FRIES, 1)
                .requires(Items.POTATO)
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .unlockedBy(has + ItemNamesV2.OLIVE_OIL, RecipeProvider.has(Content.OLIVE_OIL.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.FRIED_CHICKEN, 1)
                .requires(Content.FLOUR.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .requires(croptopiaTag("chicken_replacements"))
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy("has_chicken_replacement", RecipeProvider.has(croptopiaTag("chicken_replacements")))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.FRUIT_SALAD, 1)
                .requires(Items.BOWL)
                .requires(Content.STRAWBERRY.asTag())
                .requires(Content.BANANA.asTag())
                .requires(Content.GRAPE.asTag())
                .requires(Items.APPLE)
                .unlockedBy(has + ItemNamesV2.STRAWBERRY, RecipeProvider.has(Content.STRAWBERRY.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.FRUIT_SMOOTHIE, 2)
                .requires(Items.GLASS_BOTTLE)
                .requires(Tags.FRUITS)
                .requires(Tags.FRUITS)
                .requires(Tags.FRUITS)
                .requires(Items.ICE)
                .requires(milks)
                .unlockedBy("has_milk", RecipeProvider.has(milks))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.GRILLED_CHEESE, 1)
                .requires(Items.BREAD)
                .requires(Content.CHEESE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.CHEESE, RecipeProvider.has(Content.CHEESE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.HAM_SANDWICH, 1)
                .requires(Items.BREAD)
                .requires(Items.COOKED_PORKCHOP)
                .requires(Content.CHEESE.asTag())
                .unlockedBy("has_cooked_porkchop", RecipeProvider.has(Items.COOKED_PORKCHOP))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.HORCHATA, 1)
                .requires(Content.RICE.asTag())
                .requires(Content.ALMOND.asTag())
                .requires(Content.LIME.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .requires(Items.SUGAR)
                .requires(Content.CINNAMON.asTag())
                .unlockedBy(has + ItemNamesV2.CINNAMON, RecipeProvider.has(Content.CINNAMON.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.KALE_CHIPS, 1)
                .requires(Content.KALE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .unlockedBy(has + ItemNamesV2.KALE, RecipeProvider.has(Content.KALE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.KALE_SMOOTHIE, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.KALE.asTag())
                .requires(Items.ICE)
                .requires(milks)
                .requires(Content.MANGO.asTag())
                .requires(Content.YOGHURT.asTag())
                .requires(Content.TOMATO.asTag())
                .unlockedBy(has + ItemNamesV2.KALE, RecipeProvider.has(Content.KALE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.LEAFY_SALAD, 1)
                .requires(Items.BOWL)
                .requires(Content.LETTUCE.asTag())
                .requires(Content.SPINACH.asTag())
                .requires(Content.KALE.asTag())
                .unlockedBy(has + ItemNamesV2.SPINACH, RecipeProvider.has(Content.SPINACH.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.LEEK_SOUP, 1)
                .requires(Items.BOWL)
                .requires(Content.LEEK.asTag())
                .requires(Items.POTATO)
                .requires(milks)
                .unlockedBy(has + ItemNamesV2.LEEK, RecipeProvider.has(Content.LEEK.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.LEMON_CHICKEN, 1)
                .requires(Content.LEMON.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(croptopiaTag("chicken_replacements"))
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.LEMON, RecipeProvider.has(Content.LEMON.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.LEMONADE, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.LEMON.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.LEMON, RecipeProvider.has(Content.LEMON.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.LIMEADE, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.LIME.asTag())
                .requires(Content.LEMON.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.LIME, RecipeProvider.has(Content.LIME.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.MEAD, 1)
                .requires(Items.HONEY_BOTTLE)
                .requires(Content.WATER_BOTTLE.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_honey_bottle", RecipeProvider.has(Items.HONEY_BOTTLE))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.NOODLE, 1)
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.FLOUR, RecipeProvider.has(Content.FLOUR.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.NOUGAT, 2)
                .requires(Tags.NUTS)
                .requires(Tags.NUTS)
                .requires(Items.SUGAR)
                .requires(Items.SUGAR)
                .requires(Items.EGG)
                .requires(Items.EGG)
                .unlockedBy(has + MiscNames.NUTS, RecipeProvider.has(Tags.NUTS))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.NUTTY_COOKIE, 4)
                .requires(Tags.NUTS)
                .requires(Tags.NUTS)
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.FLOUR, RecipeProvider.has(Content.FLOUR.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.OATMEAL, 1)
                .requires(Items.BOWL)
                .requires(Content.OAT.asTag())
                .requires(milks)
                .unlockedBy(has + ItemNamesV2.OAT, RecipeProvider.has(Content.OAT.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.OLIVE_OIL, 1)
                .requires(Content.OLIVE.asTag())
                .requires(Content.OLIVE.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.OLIVE, RecipeProvider.has(Content.OLIVE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.ONION_RINGS, 1)
                .requires(Content.ONION.asTag())
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.ONION, RecipeProvider.has(Content.ONION.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PAPRIKA, 1)
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.MORTAR_AND_PESTLE.asTag())
                .unlockedBy(has + ItemNamesV2.CHILE_PEPPER, RecipeProvider.has(Content.CHILE_PEPPER.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PEANUT_BUTTER_AND_JAM, 1)
                .requires(Items.BREAD)
                .requires(Content.PEANUT_BUTTER.asTag())
                .requires(Tags.JAMS)
                .unlockedBy(has + ItemNamesV2.PEANUT_BUTTER, RecipeProvider.has(Content.PEANUT_BUTTER.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PEPPERONI, 4)
                .requires(croptopiaTag("beef_replacement"))
                .requires(croptopiaTag("pork_replacement"))
                .requires(Content.PAPRIKA.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .unlockedBy(has + ItemNamesV2.PAPRIKA, RecipeProvider.has(Content.PAPRIKA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PINEAPPLE_PEPPERONI_PIZZA, 1)
                .requires(Content.DOUGH.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(Content.PINEAPPLE.asTag())
                .requires(Content.PINEAPPLE.asTag())
                .requires(Content.PEPPERONI.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.PINEAPPLE, RecipeProvider.has(Content.PINEAPPLE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PIZZA, 1)
                .requires(Content.DOUGH.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.DOUGH, RecipeProvider.has(Content.DOUGH.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PORK_AND_BEANS, 1)
                .requires(Items.BOWL)
                .requires(Content.BLACKBEAN.asTag())
                .requires(croptopiaTag("pork_replacement"))
                .unlockedBy(has + ItemNamesV2.BLACKBEAN, RecipeProvider.has(Content.BLACKBEAN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.POTATO_CHIPS, 1)
                .requires(Items.POTATO)
                .requires(Content.FRYING_PAN.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .unlockedBy("has_potato", RecipeProvider.has(Items.POTATO))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PROTEIN_BAR, 3)
                .requires(Tags.NUTS)
                .requires(Tags.NUTS)
                .requires(Items.SUGAR)
                .requires(Content.CARAMEL.asTag())
                .requires(Content.CHOCOLATE.asTag())
                .requires(Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.CARAMEL, RecipeProvider.has(Content.CARAMEL.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.PUMPKIN_SPICE_LATTE, 1)
                .requires(Items.SUGAR)
                .requires(Content.PAPRIKA.asTag())
                .requires(milks)
                .requires(Items.PUMPKIN)
                .requires(Content.COFFEE.asTag())
                .unlockedBy(has + ItemNamesV2.COFFEE, RecipeProvider.has(Content.COFFEE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.QUESADILLA, 2)
                .requires(Content.TORTILLA.asTag())
                .requires(Content.TORTILLA.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.AVOCADO.asTag())
                .requires(croptopiaTag("chicken_replacements"))
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.TORTILLA, RecipeProvider.has(Content.TORTILLA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.OATMEAL_COOKIE, 4)
                .requires(Content.RAISINS.asTag())
                .requires(Content.OATMEAL.asTag())
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.RAISINS, RecipeProvider.has(Content.RAISINS.asTag()))
                .unlockedBy(has + ItemNamesV2.OATMEAL, RecipeProvider.has(Content.OATMEAL.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.RAVIOLI, 2)
                .requires(Content.NOODLE.asTag())
                .requires(Content.CHEESE.asTag())
                .unlockedBy(has + ItemNamesV2.NOODLE, RecipeProvider.has(Content.NOODLE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.REFRIED_BEANS, 2)
                .requires(Content.BLACKBEAN.asTag())
                .requires(Content.BLACKBEAN.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.BLACKBEAN, RecipeProvider.has(Content.BLACKBEAN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.RUM, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.MOLASSES.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .unlockedBy(has + ItemNamesV2.MOLASSES, RecipeProvider.has(Content.MOLASSES.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.RUM_RAISIN_ICE_CREAM, 1)
                .requires(Items.SUGAR)
                .requires(Content.RAISINS.asTag())
                .requires(Content.RUM.asTag())
                .requires(milks)
                .requires(Items.EGG)
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.RUM, RecipeProvider.has(Content.RUM.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SALSA, 4)
                .requires(Content.TOMATO.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.LIME.asTag())
                .requires(Content.TOMATILLO.asTag())
                .unlockedBy(has + ItemNamesV2.TOMATILLO, RecipeProvider.has(Content.TOMATILLO.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SAUCY_CHIPS, 1)
                .requires(Items.BOWL)
                .requires(croptopiaTag("sauces"))
                .requires(Content.POTATO_CHIPS.asTag())
                .unlockedBy(has + ItemNamesV2.POTATO_CHIPS, RecipeProvider.has(Content.POTATO_CHIPS.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SCRAMBLED_EGGS, 1)
                .requires(Content.FRYING_PAN.asTag())
                .requires(Items.EGG)
                .requires(Content.CHEESE.asTag())
                .unlockedBy(has + ItemNamesV2.POTATO_CHIPS, RecipeProvider.has(Content.POTATO_CHIPS.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SNICKER_DOODLE, 4)
                .requires(Content.CINNAMON.asTag())
                .requires(Items.SUGAR)
                .requires(Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.CINNAMON, RecipeProvider.has(Content.CINNAMON.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SOY_MILK, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.SOYBEAN.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.SOYBEAN, RecipeProvider.has(Content.SOYBEAN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SOY_SAUCE, 1)
                .requires(Content.FOOD_PRESS.asTag())
                .requires(Content.SOYBEAN.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .unlockedBy(has + ItemNamesV2.SOYBEAN, RecipeProvider.has(Content.SOYBEAN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SPAGHETTI_SQUASH, 1)
                .requires(Content.SQUASH.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.SQUASH, RecipeProvider.has(Content.SQUASH.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.STEAMED_RICE, 1)
                .requires(Content.RICE.asTag())
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .unlockedBy(has + ItemNamesV2.RICE, RecipeProvider.has(Content.RICE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.STUFFED_POBLANOS, 1)
                .requires(croptopiaTag("beef_replacements"))
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.BLACKBEAN.asTag())
                .requires(Content.CORN.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.RICE.asTag())
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.RICE, RecipeProvider.has(Content.RICE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SUPREME_PIZZA, 1)
                .requires(croptopiaTag("beef_replacements"))
                .requires(Content.DOUGH.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(Content.BELLPEPPER.asTag())
                .requires(Content.OLIVE.asTag())
                .requires(croptopiaTag("meat_replacements"))
                .requires(Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.BELLPEPPER, RecipeProvider.has(Content.BELLPEPPER.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SUSHI, 1)
                .requires(Items.SEAGRASS)
                .requires(croptopiaTag("fishes"))
                .requires(Content.RICE.asTag())
                .unlockedBy(has + ItemNamesV2.RICE, RecipeProvider.has(Content.RICE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.SWEET_POTATO_FRIES, 1)
                .requires(Content.SWEETPOTATO.asTag())
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.OLIVE_OIL.asTag())
                .unlockedBy(has + ItemNamesV2.SWEETPOTATO, RecipeProvider.has(Content.SWEETPOTATO.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TACO, 1)
                .requires(Content.TORTILLA.asTag())
                .requires(Content.CHEESE.asTag())
                .requires(Content.LETTUCE.asTag())
                .requires(Content.SALSA.asTag())
                .requires(croptopiaTag("meat_replacements"))
                .unlockedBy(has + ItemNamesV2.TORTILLA, RecipeProvider.has(Content.TORTILLA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TAMALES, 2)
                .requires(Content.ONION.asTag())
                .requires(Content.CORN_HUSK.asTag())
                .requires(Content.FLOUR.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.CORN_HUSK, RecipeProvider.has(Content.CORN_HUSK.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TOAST_WITH_JAM, 1)
                .requires(Content.TOAST.asTag())
                .requires(Tags.JAMS)
                .unlockedBy(has + ItemNamesV2.TOAST, RecipeProvider.has(Content.TOAST.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TOFU, 1)
                .requires(Content.COOKING_POT.asTag())
                .requires(Content.WATER_BOTTLE.asTag())
                .requires(Content.SOYBEAN.asTag())
                .unlockedBy(has + ItemNamesV2.SOYBEAN, RecipeProvider.has(Content.SOYBEAN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TOFU_AND_DUMPLINGS, 1)
                .requires(Content.DOUGH.asTag())
                .requires(Content.CHILE_PEPPER.asTag())
                .requires(Content.TOFU.asTag())
                .requires(Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.TOFU, RecipeProvider.has(Content.TOFU.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TOFUBURGER, 1)
                .requires(Items.BREAD)
                .requires(Content.LETTUCE.asTag())
                .requires(Content.FRYING_PAN.asTag())
                .requires(Content.TOFU.asTag())
                .requires(Content.ONION.asTag())
                .unlockedBy(has + ItemNamesV2.TOFU, RecipeProvider.has(Content.TOFU.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TOSTADA, 1)
                .requires(Content.BLACKBEAN.asTag())
                .requires(Content.BLACKBEAN.asTag())
                .requires(Content.TOMATO.asTag())
                .requires(Content.LETTUCE.asTag())
                .requires(Content.TORTILLA.asTag())
                .unlockedBy(has + ItemNamesV2.TORTILLA, RecipeProvider.has(Content.TORTILLA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TRAIL_MIX, 1)
                .requires(Tags.NUTS)
                .requires(Tags.NUTS)
                .requires(Tags.NUTS)
                .requires(Content.RAISINS.asTag())
                .requires(Content.SALT.asTag())
                .requires(Content.CHOCOLATE.asTag())
                .unlockedBy(has + ItemNamesV2.RAISINS, RecipeProvider.has(Content.RAISINS.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.TRES_LECHE_CAKE, 2)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .requires(milks)
                .requires(Content.FLOUR.asTag())
                .requires(Content.VANILLA.asTag())
                .requires(Content.RUM.asTag())
                .requires(Content.WHIPPING_CREAM.asTag())
                .unlockedBy(has + ItemNamesV2.RUM, RecipeProvider.has(Content.RUM.asTag()))
                .unlockedBy(has + ItemNamesV2.WHIPPING_CREAM, RecipeProvider.has(Content.WHIPPING_CREAM.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.VEGGIE_SALAD, 1)
                .requires(Items.BOWL)
                .requires(Content.CUCUMBER.asTag())
                .requires(Items.CARROT)
                .requires(Content.CORN.asTag())
                .requires(Content.LETTUCE.asTag())
                .unlockedBy(has + ItemNamesV2.CUCUMBER, RecipeProvider.has(Content.CUCUMBER.asTag()))
                .unlockedBy(has + ItemNamesV2.CORN, RecipeProvider.has(Content.CORN.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.WHIPPING_CREAM, 4)
                .requires(milks)
                .requires(Items.SUGAR)
                .requires(Content.VANILLA.asTag())
                .unlockedBy(has + ItemNamesV2.VANILLA, RecipeProvider.has(Content.VANILLA.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.WINE, 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Content.GRAPE.asTag())
                .requires(Content.GRAPE.asTag())
                .requires(Content.FOOD_PRESS.asTag())
                .unlockedBy(has + ItemNamesV2.GRAPE, RecipeProvider.has(Content.GRAPE.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.YAM_JAM, 1)
                .requires(Content.YAM.asTag())
                .requires(Content.VANILLA.asTag())
                .requires(milks)
                .requires(milks)
                .unlockedBy(has + ItemNamesV2.YAM, RecipeProvider.has(Content.YAM.asTag()))
                .save(exporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Content.YOGHURT, 1)
                .requires(Items.BOWL)
                .requires(milks)
                .requires(Content.STRAWBERRY.asTag())
                .unlockedBy("has_milk", RecipeProvider.has(milks))
                .save(exporter);
    }

    protected void generateMiscShaped(final RecipeOutput exporter) {
        final String has = "has_";
        final TagKey<Item> milks = commonTag("milks");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.AJVAR)
                .pattern("456")
                .pattern("123")
                .define('1', Content.BELLPEPPER.asTag())
                .define('2', Content.EGGPLANT.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', Content.CHILE_PEPPER.asTag())
                .define('5', Content.OLIVE_OIL.asTag())
                .define('6', Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.EGGPLANT, RecipeProvider.has(Content.EGGPLANT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.AJVAR_TOAST)
                .pattern("1")
                .pattern("2")
                .define('1', Content.AJVAR.asTag())
                .define('2', Content.TOAST.asTag())
                .unlockedBy(has + ItemNamesV2.TOAST, RecipeProvider.has(Content.TOAST.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.AVOCADO_TOAST)
                .pattern("1")
                .pattern("2")
                .define('1', Content.AVOCADO.asTag())
                .define('2', Content.TOAST.asTag())
                .unlockedBy(has + ItemNamesV2.AVOCADO, RecipeProvider.has(Content.AVOCADO.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.RAW_BACON)
                .pattern(" 2")
                .pattern("1 ")
                .define('1', Content.KNIFE.asTag())
                .define('2', Items.PORKCHOP)
                .unlockedBy("has_porkchop", RecipeProvider.has(Items.PORKCHOP))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BEEF_STEW)
                .pattern("1 4")
                .pattern("253")
                .define('1', Items.CARROT)
                .define('2', croptopiaTag("beef_replacement"))
                .define('3', Items.POTATO)
                .define('4', Items.CARROT)
                .define('5', Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.EGGPLANT, RecipeProvider.has(Content.EGGPLANT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BEEF_STIR_FRY)
                .pattern("164")
                .pattern("253")
                .define('1', Content.BROCCOLI.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', croptopiaTag("beef_replacement"))
                .define('5', Content.SOY_SAUCE.asTag())
                .define('6', Items.CARROT)
                .unlockedBy(has + ItemNamesV2.BROCCOLI, RecipeProvider.has(Content.BROCCOLI.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BEEF_WELLINGTON)
                .pattern("94 ")
                .pattern("2F3")
                .pattern("516")
                .define('F', Content.FRYING_PAN.asTag())
                .define('1', croptopiaTag("beef_replacement"))
                .define('2', Content.MUSTARD.asTag())
                .define('3', Content.PEPPER.asTag())
                .define('4', Content.ONION.asTag())
                .define('5', Items.EGG)
                .define('6', Items.BROWN_MUSHROOM)
                .define('9', Items.CARROT)
                .unlockedBy(has + ItemNamesV2.MUSTARD, RecipeProvider.has(Content.MUSTARD.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.BUTTERED_GREEN_BEANS)
                .pattern("45 ")
                .pattern("123")
                .define('1', Content.BUTTER.asTag())
                .define('2', Content.GREENBEAN.asTag())
                .define('3', Content.GINGER.asTag())
                .define('4', Content.SALT.asTag())
                .define('5', Content.PEPPER.asTag())
                .unlockedBy(has + ItemNamesV2.GREENBEAN, RecipeProvider.has(Content.GREENBEAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CHEESY_ASPARAGUS)
                .pattern(" 1 ")
                .pattern("324")
                .define('1', Content.ASPARAGUS.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.CHEESE.asTag())
                .define('4', Content.PEPPER.asTag())
                .unlockedBy(has + ItemNamesV2.ASPARAGUS, RecipeProvider.has(Content.ASPARAGUS.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CHOCOLATE_ICE_CREAM)
                .pattern(" 1 ")
                .pattern("324")
                .pattern(" 5 ")
                .define('1', Items.EGG)
                .define('2', Content.CHOCOLATE.asTag())
                .define('3', Content.MILK_BOTTLE.asTag())
                .define('4', Items.SUGAR)
                .define('5', Content.COOKING_POT.asTag())
                .unlockedBy(has + ItemNamesV2.CHOCOLATE, RecipeProvider.has(Content.CHOCOLATE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.CORNISH_PASTY)
                .pattern("567")
                .pattern("234")
                .pattern(" 1 ")
                .define('1', Content.FRYING_PAN.asTag())
                .define('2', Content.FLOUR.asTag())
                .define('3', croptopiaTag("beef_replacement"))
                .define('4', Items.POTATO)
                .define('5', Content.ONION.asTag())
                .define('6', Content.RUTABAGA.asTag())
                .define('7', Content.PEPPER.asTag())
                .unlockedBy(has + ItemNamesV2.RUTABAGA, RecipeProvider.has(Content.RUTABAGA.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.EGGPLANT_PARMESAN)
                .pattern("61 ")
                .pattern("324")
                .pattern(" 57")
                .define('1', Items.EGG)
                .define('2', Content.EGGPLANT.asTag())
                .define('3', Content.OLIVE_OIL.asTag())
                .define('4', Content.PEPPER.asTag())
                .define('5', Content.CHEESE.asTag())
                .define('6', Content.BASIL.asTag())
                .define('7', Items.BREAD)
                .unlockedBy(has + ItemNamesV2.EGGPLANT, RecipeProvider.has(Content.EGGPLANT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ETON_MESS)
                .pattern("343")
                .pattern("121")
                .define('1', Items.EGG)
                .define('2', Items.SUGAR)
                .define('3', Content.STRAWBERRY.asTag())
                .define('4', Content.WHIPPING_CREAM.asTag())
                .unlockedBy(has + ItemNamesV2.STRAWBERRY, RecipeProvider.has(Content.STRAWBERRY.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FIGGY_PUDDING)
                .pattern("456")
                .pattern("123")
                .define('1', Items.EGG)
                .define('2', Content.WATER_BOTTLE.asTag())
                .define('3', Content.WHIPPING_CREAM.asTag())
                .define('4', Content.DATE.asTag())
                .define('5', Content.FIG.asTag())
                .define('6', Items.SUGAR)
                .unlockedBy(has + ItemNamesV2.DATE, RecipeProvider.has(Content.DATE.asTag()))
                .unlockedBy(has + ItemNamesV2.FIG, RecipeProvider.has(Content.FIG.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FISH_AND_CHIPS)
                .pattern(" 4 ")
                .pattern("2F3")
                .pattern("51 ")
                .define('F', Content.FRYING_PAN.asTag())
                .define('1', Items.POTATO)
                .define('2', Content.SALT.asTag())
                .define('3', Content.PEPPER.asTag())
                .define('4', Content.FLOUR.asTag())
                .define('5', ItemTags.FISHES)
                .unlockedBy("has_fish", RecipeProvider.has(ItemTags.FISHES))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.FRUIT_CAKE, 3)
                .pattern("61 ")
                .pattern("324")
                .pattern("857")
                .define('1', Tags.FRUITS)
                .define('2', Items.SUGAR)
                .define('3', Content.LEMON.asTag())
                .define('4', Content.PECAN.asTag())
                .define('5', Content.CINNAMON.asTag())
                .define('6', Content.SALT.asTag())
                .define('7', Content.NUTMEG.asTag())
                .define('8', Items.EGG)
                .unlockedBy("has_fruits", RecipeProvider.has(Tags.FRUITS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.GRILLED_EGGPLANT)
                .pattern("625")
                .pattern("314")
                .define('1', Content.EGGPLANT.asTag())
                .define('2', Content.SALT.asTag())
                .define('3', Content.OLIVE_OIL.asTag())
                .define('4', Content.GARLIC.asTag())
                .define('5', Content.PEPPER.asTag())
                .define('6', Content.PAPRIKA.asTag())
                .unlockedBy(has + ItemNamesV2.EGGPLANT, RecipeProvider.has(Content.EGGPLANT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.KIWI_SORBET)
                .pattern("1")
                .pattern("2")
                .define('1', Content.KIWI.asTag())
                .define('2', Items.HONEY_BOTTLE)
                .unlockedBy(has + ItemNamesV2.KIWI, RecipeProvider.has(Content.KIWI.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.LEMON_COCONUT_BAR)
                .pattern("314")
                .pattern("526")
                .define('1', Content.LEMON.asTag())
                .define('2', Content.COCONUT.asTag())
                .define('3', Items.SUGAR)
                .define('4', Items.EGG)
                .define('5', Content.BUTTER.asTag())
                .define('6', Content.FLOUR.asTag())
                .unlockedBy(has + ItemNamesV2.COCONUT, RecipeProvider.has(Content.COCONUT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.MILK_BOTTLE, 16)
                .pattern("212")
                .pattern(" 2 ")
                .define('1', Items.MILK_BUCKET)
                .define('2', Items.GLASS)
                .unlockedBy("has_milk_bucket", RecipeProvider.has(Items.MILK_BUCKET))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.NETHER_WART_STEW)
                .pattern(" 1 ")
                .pattern("234")
                .define('1', Content.FLOUR.asTag())
                .define('2', Items.NETHER_WART)
                .define('3', Items.CRIMSON_FUNGUS)
                .define('4', Items.WARPED_FUNGUS)
                .unlockedBy("has_nether_wart", RecipeProvider.has(Items.NETHER_WART))
                .unlockedBy("has_crimson_fungus", RecipeProvider.has(Items.CRIMSON_FUNGUS))
                .unlockedBy("has_warped_fungus", RecipeProvider.has(Items.WARPED_FUNGUS))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PEANUT_BUTTER)
                .pattern(" 2 ")
                .pattern("212")
                .pattern(" 2 ")
                .define('1', Content.FOOD_PRESS.asTag())
                .define('2', Content.PEANUT.asTag())
                .unlockedBy(has + ItemNamesV2.PEANUT, RecipeProvider.has(Content.PEANUT.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.PEANUT_BUTTER_W_CELERY)
                .pattern(" 2")
                .pattern("1 ")
                .define('1', Content.PEANUT_BUTTER.asTag())
                .define('2', Content.CELERY.asTag())
                .unlockedBy(has + ItemNamesV2.CELERY, RecipeProvider.has(Content.CELERY.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.POTATO_SOUP)
                .pattern(" 1 ")
                .pattern("234")
                .pattern(" 5 ")
                .define('1', Items.POTATO)
                .define('2', Content.FLOUR.asTag())
                .define('3', Content.GREENONION.asTag())
                .define('4', Content.RAW_BACON.asTag())
                .define('5', Content.WATER_BOTTLE.asTag())
                .unlockedBy("has_potato", RecipeProvider.has(Items.POTATO))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.RATATOUILLE, 2)
                .pattern("364")
                .pattern("512")
                .pattern("789")
                .define('1', Content.FRYING_PAN.asTag())
                .define('2', Content.EGGPLANT.asTag())
                .define('3', Content.TOMATO.asTag())
                .define('4', Content.SQUASH.asTag())
                .define('5', Content.ZUCCHINI.asTag())
                .define('6', Content.OLIVE_OIL.asTag())
                .define('7', Content.ONION.asTag())
                .define('8', Content.BELLPEPPER.asTag())
                .define('9', Content.BASIL.asTag())
                .unlockedBy(has + ItemNamesV2.SQUASH, RecipeProvider.has(Content.SQUASH.asTag()))
                .unlockedBy(has + ItemNamesV2.ZUCCHINI, RecipeProvider.has(Content.ZUCCHINI.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.RHUBARB_CRISP)
                .pattern("456")
                .pattern("123")
                .pattern("7  ")
                .define('1', Content.RHUBARB.asTag())
                .define('2', Items.SUGAR)
                .define('3', Content.CINNAMON.asTag())
                .define('4', Content.OAT.asTag())
                .define('5', Content.FLOUR.asTag())
                .define('6', Content.BUTTER.asTag())
                .define('7', Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.RHUBARB, RecipeProvider.has(Content.RHUBARB.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_ASPARAGUS, 2)
                .pattern("213")
                .pattern("465")
                .define('1', Content.ASPARAGUS.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', Content.SALT.asTag())
                .define('5', Content.PEPPER.asTag())
                .define('6', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.ASPARAGUS, RecipeProvider.has(Content.ASPARAGUS.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_RADISHES, 2)
                .pattern("213")
                .pattern("465")
                .define('1', Content.RADISH.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', Content.SALT.asTag())
                .define('5', Content.PEPPER.asTag())
                .define('6', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.RADISH, RecipeProvider.has(Content.RADISH.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_SQUASH, 2)
                .pattern("213")
                .pattern("465")
                .define('1', Content.SQUASH.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', Content.SALT.asTag())
                .define('5', Content.PEPPER.asTag())
                .define('6', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.SQUASH, RecipeProvider.has(Content.SQUASH.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.ROASTED_TURNIPS, 2)
                .pattern("213")
                .pattern("465")
                .define('1', Content.TURNIP.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', Content.SALT.asTag())
                .define('5', Content.PEPPER.asTag())
                .define('6', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.TURNIP, RecipeProvider.has(Content.TURNIP.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SCONES, 2)
                .pattern("567")
                .pattern("234")
                .pattern(" 1 ")
                .define('1', Content.FRYING_PAN.asTag())
                .define('2', Content.FLOUR.asTag())
                .define('3', Content.SALT.asTag())
                .define('4', Items.SUGAR)
                .define('5', Items.EGG)
                .define('6', Content.VANILLA.asTag())
                .define('7', Content.BLUEBERRY.asTag())
                .unlockedBy(has + ItemNamesV2.VANILLA, RecipeProvider.has(Content.VANILLA.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.SHEPHERDS_PIE)
                .pattern("213")
                .pattern("4F5")
                .pattern("678")
                .define('F', Content.FRYING_PAN.asTag())
                .define('1', croptopiaTag("beef_mutton"))
                .define('2', Content.SALT.asTag())
                .define('3', Content.PEPPER.asTag())
                .define('4', Items.POTATO)
                .define('5', Content.TOMATO.asTag())
                .define('6', Content.CORN.asTag())
                .define('7', Content.GARLIC.asTag())
                .define('8', Content.ONION.asTag())
                .unlockedBy("has_beef_mutton", RecipeProvider.has(croptopiaTag("beef_mutton")))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STEAMED_BROCCOLI)
                .pattern("121")
                .define('1', Content.BROCCOLI.asTag())
                .define('2', Content.WATER_BOTTLE.asTag())
                .unlockedBy(has + ItemNamesV2.BROCCOLI, RecipeProvider.has(Content.BROCCOLI.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STEAMED_GREEN_BEANS)
                .pattern("121")
                .define('1', Content.GREENBEAN.asTag())
                .define('2', Content.WATER_BOTTLE.asTag())
                .unlockedBy(has + ItemNamesV2.GREENBEAN, RecipeProvider.has(Content.GREENBEAN.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STICKY_TOFFEE_PUDDING)
                .pattern("7 8")
                .pattern("456")
                .pattern("123")
                .define('1', Items.EGG)
                .define('2', Content.WATER_BOTTLE.asTag())
                .define('3', Content.VANILLA.asTag())
                .define('4', Content.WHIPPING_CREAM.asTag())
                .define('5', Items.SUGAR)
                .define('6', Content.BUTTER.asTag())
                .define('7', Content.DATE.asTag())
                .define('8', Content.SALT.asTag())
                .unlockedBy(has + ItemNamesV2.DATE, RecipeProvider.has(Content.DATE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STIR_FRY)
                .pattern("314")
                .pattern("526")
                .define('1', Content.BROCCOLI.asTag())
                .define('2', Content.OLIVE_OIL.asTag())
                .define('3', Content.GARLIC.asTag())
                .define('4', Content.GREENONION.asTag())
                .define('5', Content.BELLPEPPER.asTag())
                .define('6', Items.CARROT)
                .unlockedBy("has_carrot", RecipeProvider.has(Items.CARROT))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.STUFFED_ARTICHOKE)
                .pattern("456")
                .pattern("123")
                .pattern("7 8")
                .define('1', Content.ARTICHOKE.asTag())
                .define('2', Content.PEPPER.asTag())
                .define('3', Content.LEMON.asTag())
                .define('4', Items.BREAD)
                .define('5', Content.CHEESE.asTag())
                .define('6', Content.OLIVE_OIL.asTag())
                .define('7', Content.SALT.asTag())
                .define('8', Content.FRYING_PAN.asTag())
                .unlockedBy(has + ItemNamesV2.ARTICHOKE, RecipeProvider.has(Content.ARTICHOKE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.TEA)
                .pattern("2")
                .pattern("1")
                .define('1', Content.WATER_BOTTLE.asTag())
                .define('2', Content.TEA_LEAVES.asTag())
                .unlockedBy(has + ItemNamesV2.TEA_LEAVES, RecipeProvider.has(Content.TEA_LEAVES.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.TOAST_SANDWICH, 2)
                .pattern("121")
                .define('1', Items.BREAD)
                .define('2', Content.BUTTERED_TOAST.asTag())
                .unlockedBy(has + ItemNamesV2.BUTTERED_TOAST, RecipeProvider.has(Content.BUTTERED_TOAST.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.TREACLE_TART, 3)
                .pattern("234")
                .pattern("111")
                .define('1', Items.BREAD)
                .define('2', Items.HONEY_BOTTLE)
                .define('3', Content.LEMON.asTag())
                .define('4', Content.WHIPPING_CREAM.asTag())
                .unlockedBy(has + ItemNamesV2.WHIPPING_CREAM, RecipeProvider.has(Content.WHIPPING_CREAM.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.TRIFLE)
                .pattern(" 5 ")
                .pattern("647")
                .pattern("123")
                .define('1', Items.EGG)
                .define('2', milks)
                .define('3', Content.VANILLA.asTag())
                .define('4', Content.WINE.asTag())
                .define('5', Content.STRAWBERRY.asTag())
                .define('6', Items.BREAD)
                .define('7', Content.BUTTER.asTag())
                .unlockedBy(has + ItemNamesV2.WINE, RecipeProvider.has(Content.WINE.asTag()))
                .save(exporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Content.WATER_BOTTLE)
                .pattern("212")
                .pattern(" 2 ")
                .define('1', Items.WATER_BUCKET)
                .define('2', Items.GLASS)
                .unlockedBy("has_water_bucket", RecipeProvider.has(Items.WATER_BUCKET))
                .save(exporter);
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
