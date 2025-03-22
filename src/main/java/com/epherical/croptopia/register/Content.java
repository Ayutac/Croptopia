package com.epherical.croptopia.register;

import com.epherical.croptopia.common.BlockNames;
import com.epherical.croptopia.common.ItemNamesV2;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.common.Tags;
import com.epherical.croptopia.common.generator.ConfiguredFeatureKeys;
import com.epherical.croptopia.common.generator.PlacedFeatureKeys;
import com.epherical.croptopia.items.Drink;
import com.epherical.croptopia.items.ReferenceItem;
import com.epherical.croptopia.items.Soup;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Furnace;
import com.epherical.croptopia.register.helpers.IceCream;
import com.epherical.croptopia.register.helpers.Jam;
import com.epherical.croptopia.register.helpers.Juice;
import com.epherical.croptopia.register.helpers.Pie;
import com.epherical.croptopia.register.helpers.Seafood;
import com.epherical.croptopia.register.helpers.SimpleItemWrapper;
import com.epherical.croptopia.register.helpers.Smoothie;
import com.epherical.croptopia.register.helpers.Tree;
import com.epherical.croptopia.register.helpers.TreeCrop;
import com.epherical.croptopia.register.helpers.Utensil;
import com.epherical.croptopia.register.helpers.VanillaCrops;
import com.epherical.croptopia.util.FoodConstructor;
import com.epherical.croptopia.util.RegisterFunction;
import com.epherical.croptopia.util.RegistryDelay;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.material.MapColor;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.epherical.croptopia.CroptopiaMod.createGroup;
import static com.epherical.croptopia.CroptopiaMod.createIdentifier;
import static com.epherical.croptopia.util.FoodConstructor.*;

public class Content {

    public static final RegistryDelay<Item, Item> ITEM_REGISTER = new RegistryDelay<>(MiscNames.MOD_ID);
    public static final RegistryDelay<Block, Block> BLOCK_REGISTER = new RegistryDelay<>(MiscNames.MOD_ID);

    public static final FarmlandCrop ARTICHOKE = new FarmlandCrop(ItemNamesV2.ARTICHOKE, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_ARTICHOKE);
    public static final FarmlandCrop ASPARAGUS = new FarmlandCrop(ItemNamesV2.ASPARAGUS, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_ASPARAGUS);
    public static final FarmlandCrop BARLEY = new FarmlandCrop(ItemNamesV2.BARLEY, false, Tags.GRAIN, RAW_CROP_1, Tags.HAS_BARLEY);
    public static final FarmlandCrop BASIL = new FarmlandCrop(ItemNamesV2.BASIL, false, Tags.CROPS, RAW_CROP_1, Tags.HAS_BASIL);
    public static final FarmlandCrop BELLPEPPER = new FarmlandCrop(ItemNamesV2.BELLPEPPER, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_BELLPEPPER);
    public static final FarmlandCrop BLACKBEAN = new FarmlandCrop(ItemNamesV2.BLACKBEAN, true, Tags.CROPS, RAW_CROP_1, Tags.HAS_BLACKBEAN);
    public static final FarmlandCrop BLACKBERRY = new FarmlandCrop(ItemNamesV2.BLACKBERRY, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_BLACKBERRY);
    public static final FarmlandCrop BLUEBERRY = new FarmlandCrop(ItemNamesV2.BLUEBERRY, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_BLUEBERRY);
    public static final FarmlandCrop BROCCOLI = new FarmlandCrop(ItemNamesV2.BROCCOLI, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_BROCCOLI);
    public static final FarmlandCrop CABBAGE = new FarmlandCrop(ItemNamesV2.CABBAGE, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_CABBAGE);
    public static final FarmlandCrop CANTALOUPE = new FarmlandCrop(ItemNamesV2.CANTALOUPE, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_CANTALOUPE);
    public static final FarmlandCrop CAULIFLOWER = new FarmlandCrop(ItemNamesV2.CAULIFLOWER, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_CAULIFLOWER);
    public static final FarmlandCrop CELERY = new FarmlandCrop(ItemNamesV2.CELERY, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_CELERY);
    public static final FarmlandCrop CHILE_PEPPER = new FarmlandCrop(ItemNamesV2.CHILE_PEPPER, true, Tags.CROPS, RAW_CROP_1, Tags.HAS_CHILE_PEPPER);
    public static final FarmlandCrop COFFEE_BEANS = new FarmlandCrop(ItemNamesV2.COFFEE_BEANS, false, Tags.CROPS, RAW_CROP_1, Tags.HAS_COFFEE_BEANS);
    public static final FarmlandCrop CORN = new FarmlandCrop(ItemNamesV2.CORN, false, Tags.GRAIN, RAW_CROP_1, Tags.HAS_CORN);
    public static final FarmlandCrop CRANBERRY = new FarmlandCrop(ItemNamesV2.CRANBERRY, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_CRANBERRY);
    public static final FarmlandCrop CUCUMBER = new FarmlandCrop(ItemNamesV2.CUCUMBER, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_CUCUMBER);
    public static final FarmlandCrop CURRANT = new FarmlandCrop(ItemNamesV2.CURRANT, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_CURRANT);
    public static final FarmlandCrop EGGPLANT = new FarmlandCrop(ItemNamesV2.EGGPLANT, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_EGGPLANT);
    public static final FarmlandCrop ELDERBERRY = new FarmlandCrop(ItemNamesV2.ELDERBERRY, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_ELDERBERRY);
    public static final FarmlandCrop GARLIC = new FarmlandCrop(ItemNamesV2.GARLIC, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_GARLIC);
    public static final FarmlandCrop GINGER = new FarmlandCrop(ItemNamesV2.GINGER, true, Tags.VEGETABLES, null, Tags.HAS_GINGER);
    public static final FarmlandCrop GRAPE = new FarmlandCrop(ItemNamesV2.GRAPE, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_GRAPE);
    public static final FarmlandCrop GREENBEAN = new FarmlandCrop(ItemNamesV2.GREENBEAN, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_GREENBEAN);
    public static final FarmlandCrop GREENONION = new FarmlandCrop(ItemNamesV2.GREENONION, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_GREENONION);
    public static final FarmlandCrop HONEYDEW = new FarmlandCrop(ItemNamesV2.HONEYDEW, false, Tags.FRUITS, RAW_CROP_1, Tags.HAS_HONEYDEW);
    public static final FarmlandCrop HOPS = new FarmlandCrop(ItemNamesV2.HOPS, false, Tags.CROPS, null, Tags.HAS_HOPS);
    public static final FarmlandCrop KALE = new FarmlandCrop(ItemNamesV2.KALE, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_KALE);
    public static final FarmlandCrop KIWI = new FarmlandCrop(ItemNamesV2.KIWI, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_KIWI);
    public static final FarmlandCrop LEEK = new FarmlandCrop(ItemNamesV2.LEEK, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_LEEK);
    public static final FarmlandCrop LETTUCE = new FarmlandCrop(ItemNamesV2.LETTUCE, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_LETTUCE);
    public static final FarmlandCrop MUSTARD = new FarmlandCrop(ItemNamesV2.MUSTARD, false, Tags.VEGETABLES, null, Tags.HAS_MUSTARD);
    public static final FarmlandCrop OAT = new FarmlandCrop(ItemNamesV2.OAT, false, Tags.GRAIN, RAW_CROP_1, Tags.HAS_OAT);
    public static final FarmlandCrop OLIVE = new FarmlandCrop(ItemNamesV2.OLIVE, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_OLIVE);
    public static final FarmlandCrop ONION = new FarmlandCrop(ItemNamesV2.ONION, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_ONION);
    public static final FarmlandCrop PEANUT = new FarmlandCrop(ItemNamesV2.PEANUT, true, Tags.CROPS, RAW_CROP_1, Tags.HAS_PEANUT);
    public static final FarmlandCrop PEPPER = new FarmlandCrop(ItemNamesV2.PEPPER, false, Tags.CROPS, null, Tags.HAS_PEPPER);
    public static final FarmlandCrop PINEAPPLE = new FarmlandCrop(ItemNamesV2.PINEAPPLE, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_PINEAPPLE);
    public static final FarmlandCrop RADISH = new FarmlandCrop(ItemNamesV2.RADISH, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_RADISH);
    public static final FarmlandCrop RASPBERRY = new FarmlandCrop(ItemNamesV2.RASPBERRY, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_RASPBERRY);
    public static final FarmlandCrop RHUBARB = new FarmlandCrop(ItemNamesV2.RHUBARB, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_RHUBARB);
    public static final FarmlandCrop RICE = new FarmlandCrop(ItemNamesV2.RICE, false, Tags.GRAIN, REG_1, Tags.HAS_RICE);
    public static final FarmlandCrop RUTABAGA = new FarmlandCrop(ItemNamesV2.RUTABAGA, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_RUTABAGA);
    public static final FarmlandCrop SAGUARO = new FarmlandCrop(ItemNamesV2.SAGUARO, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_SAGUARO);
    public static final FarmlandCrop SOYBEAN = new FarmlandCrop(ItemNamesV2.SOYBEAN, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_SOYBEAN);
    public static final FarmlandCrop SPINACH = new FarmlandCrop(ItemNamesV2.SPINACH, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_SPINACH);
    public static final FarmlandCrop SQUASH = new FarmlandCrop(ItemNamesV2.SQUASH, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_SQUASH);
    public static final FarmlandCrop STRAWBERRY = new FarmlandCrop(ItemNamesV2.STRAWBERRY, true, Tags.FRUITS, RAW_CROP_1, Tags.HAS_STRAWBERRY);
    public static final FarmlandCrop SWEETPOTATO = new FarmlandCrop(ItemNamesV2.SWEETPOTATO, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_SWEETPOTATO);
    public static final FarmlandCrop TEA_LEAVES = new FarmlandCrop(ItemNamesV2.TEA_LEAVES, false, Tags.CROPS, null, Tags.HAS_TEA_LEAVES);
    public static final FarmlandCrop TOMATILLO = new FarmlandCrop(ItemNamesV2.TOMATILLO, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_TOMATILLO);
    public static final FarmlandCrop TOMATO = new FarmlandCrop(ItemNamesV2.TOMATO, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_TOMATO);
    public static final FarmlandCrop TURMERIC = new FarmlandCrop(ItemNamesV2.TURMERIC, false, Tags.CROPS, null, Tags.HAS_TURMERIC);
    public static final FarmlandCrop TURNIP = new FarmlandCrop(ItemNamesV2.TURNIP, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_TURNIP);
    public static final FarmlandCrop VANILLA = new FarmlandCrop(ItemNamesV2.VANILLA, false, Tags.CROPS, null, Tags.HAS_VANILLA);
    public static final FarmlandCrop YAM = new FarmlandCrop(ItemNamesV2.YAM, true, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_YAM);
    public static final FarmlandCrop ZUCCHINI = new FarmlandCrop(ItemNamesV2.ZUCCHINI, false, Tags.VEGETABLES, RAW_CROP_1, Tags.HAS_ZUCCHINI);

    public static final TreeCrop ALMOND = new TreeCrop(ItemNamesV2.ALMOND, true, Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, Tags.NUTS, RAW_CROP_2, 4, 3, 0,
            ConfiguredFeatureKeys.ALMOND_TREE_KEY, PlacedFeatureKeys.ALMOND_TREE_PLACED_KEY);
    public static final TreeCrop APPLE = new TreeCrop(ItemNamesV2.APPLE, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, null, 5, 3, 0,
            ConfiguredFeatureKeys.APPLE_TREE_KEY, PlacedFeatureKeys.APPLE_TREE_PLACED_KEY);
    public static final TreeCrop APRICOT = new TreeCrop(ItemNamesV2.APRICOT, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 2, 0,
            ConfiguredFeatureKeys.APRICOT_TREE_KEY, PlacedFeatureKeys.APRICOT_TREE_PLACED_KEY);
    public static final TreeCrop AVOCADO = new TreeCrop(ItemNamesV2.AVOCADO, true, Blocks.SPRUCE_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.AVOCADO_TREE_KEY, PlacedFeatureKeys.AVOCADO_TREE_PLACED_KEY);
    public static final TreeCrop BANANA = new TreeCrop(ItemNamesV2.BANANA, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 4, 8, 0,
            ConfiguredFeatureKeys.BANANA_TREE_KEY, PlacedFeatureKeys.BANANA_TREE_PLACED_KEY);
    public static final TreeCrop CASHEW = new TreeCrop(ItemNamesV2.CASHEW, true, Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, Tags.CROPS, RAW_CROP_2, 4, 3, 0,
            ConfiguredFeatureKeys.CASHEW_TREE_KEY, PlacedFeatureKeys.CASHEW_TREE_PLACED_KEY);
    public static final TreeCrop CHERRY = new TreeCrop(ItemNamesV2.CHERRY, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.CHERRY_TREE_KEY, PlacedFeatureKeys.CHERRY_TREE_PLACED_KEY);
    public static final TreeCrop COCONUT = new TreeCrop(ItemNamesV2.COCONUT, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 2, 3,
            ConfiguredFeatureKeys.COCONUT_TREE_KEY, PlacedFeatureKeys.COCONUT_TREE_PLACED_KEY);
    public static final TreeCrop DATE = new TreeCrop(ItemNamesV2.DATE, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 8, 0,
            ConfiguredFeatureKeys.DATE_TREE_KEY, PlacedFeatureKeys.DATE_TREE_PLACED_KEY);
    public static final TreeCrop DRAGONFRUIT = new TreeCrop(ItemNamesV2.DRAGONFRUIT, true, Blocks.JUNGLE_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 7, 0,
            ConfiguredFeatureKeys.DRAGON_FRUIT_TREE_KEY, PlacedFeatureKeys.DRAGONFRUIT_TREE_PLACED_KEY);
    public static final TreeCrop FIG = new TreeCrop(ItemNamesV2.FIG, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 4, 8, 0,
            ConfiguredFeatureKeys.FIG_TREE_KEY, PlacedFeatureKeys.FIG_TREE_PLACED_KEY);
    public static final TreeCrop GRAPEFRUIT = new TreeCrop(ItemNamesV2.GRAPEFRUIT, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 4, 8, 0,
            ConfiguredFeatureKeys.GRAPEFRUIT_TREE_KEY, PlacedFeatureKeys.GRAPEFRUIT_TREE_PLACED_KEY);
    public static final TreeCrop KUMQUAT = new TreeCrop(ItemNamesV2.KUMQUAT, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 4, 8, 0,
            ConfiguredFeatureKeys.KUMQUAT_TREE_KEY, PlacedFeatureKeys.KUMQUAT_TREE_PLACED_KEY);
    public static final TreeCrop LEMON = new TreeCrop(ItemNamesV2.LEMON, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.LEMON_TREE_KEY, PlacedFeatureKeys.LEMON_TREE_PLACED_KEY);
    public static final TreeCrop LIME = new TreeCrop(ItemNamesV2.LIME, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 2, 0,
            ConfiguredFeatureKeys.LIME_TREE_KEY, PlacedFeatureKeys.LIME_TREE_PLACED_KEY);
    public static final TreeCrop MANGO = new TreeCrop(ItemNamesV2.MANGO, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 8, 0,
            ConfiguredFeatureKeys.MANGO_TREE_KEY, PlacedFeatureKeys.MANGO_TREE_PLACED_KEY);
    public static final TreeCrop NECTARINE = new TreeCrop(ItemNamesV2.NECTARINE, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 4, 4, 0,
            ConfiguredFeatureKeys.NECTARINE_TREE_KEY, PlacedFeatureKeys.NECTARINE_TREE_PLACED_KEY);
    public static final TreeCrop NUTMEG = new TreeCrop(ItemNamesV2.NUTMEG, true, Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, Tags.CROPS, RAW_CROP_2, 4, 8, 0,
            ConfiguredFeatureKeys.NUTMEG_TREE_KEY, PlacedFeatureKeys.NUTMEG_TREE_PLACED_KEY);
    public static final TreeCrop ORANGE = new TreeCrop(ItemNamesV2.ORANGE, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 4, 4, 0,
            ConfiguredFeatureKeys.ORANGE_TREE_KEY, PlacedFeatureKeys.ORANGE_TREE_PLACED_KEY);
    public static final TreeCrop PEACH = new TreeCrop(ItemNamesV2.PEACH, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.PEACH_TREE_KEY, PlacedFeatureKeys.PEACH_TREE_PLACED_KEY);
    public static final TreeCrop PEAR = new TreeCrop(ItemNamesV2.PEAR, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 2, 0,
            ConfiguredFeatureKeys.PEAR_TREE_KEY, PlacedFeatureKeys.PEAR_TREE_PLACED_KEY);
    public static final TreeCrop PECAN = new TreeCrop(ItemNamesV2.PECAN, true, Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, Tags.NUTS, RAW_CROP_2, 4, 3, 0,
            ConfiguredFeatureKeys.PECAN_TREE_KEY, PlacedFeatureKeys.PECAN_TREE_PLACED_KEY);
    public static final TreeCrop PERSIMMON = new TreeCrop(ItemNamesV2.PERSIMMON, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.PERSIMMON_TREE_KEY, PlacedFeatureKeys.PERSIMMON_TREE_PLACED_KEY);
    public static final TreeCrop PLUM = new TreeCrop(ItemNamesV2.PLUM, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.PLUM_TREE_KEY, PlacedFeatureKeys.PLUM_TREE_PLACED_KEY);
    public static final TreeCrop STARFRUIT = new TreeCrop(ItemNamesV2.STARFRUIT, true, Blocks.OAK_LOG, Blocks.OAK_LEAVES, Tags.FRUITS, RAW_CROP_2, 5, 3, 0,
            ConfiguredFeatureKeys.STAR_FRUIT_TREE_KEY, PlacedFeatureKeys.STARFRUIT_TREE_PLACED_KEY);
    public static final TreeCrop WALNUT = new TreeCrop(ItemNamesV2.WALNUT, true, Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, Tags.NUTS, RAW_CROP_2, 4, 3, 0,
            ConfiguredFeatureKeys.WALNUT_TREE_KEY, PlacedFeatureKeys.WALNUT_TREE_PLACED_KEY);

    public static final Tree CINNAMON = new Tree(ItemNamesV2.CINNAMON, false, Tags.CROPS, 4, 3, 0, ConfiguredFeatureKeys.CINNAMON_TREE_KEY, PlacedFeatureKeys.CINNAMON_TREE_PLACED_KEY);

    public static final Seafood ANCHOVY = new Seafood(ItemNamesV2.ANCHOVY, true, RAW_MEAT_1);
    public static final Seafood CALAMARI = new Seafood(ItemNamesV2.CALAMARI, false, RAW_MEAT_1);
    public static final Seafood CLAM = new Seafood(ItemNamesV2.CLAM, true, RAW_MEAT_1);
    public static final Seafood CRAB = new Seafood(ItemNamesV2.CRAB, true, RAW_MEAT_1);
    public static final Seafood GLOWING_CALAMARI = new Seafood(ItemNamesV2.GLOWING_CALAMARI, false, RAW_MEAT_1);
    public static final Seafood OYSTER = new Seafood(ItemNamesV2.OYSTER, true, RAW_MEAT_1);
    public static final Seafood ROE = new Seafood(ItemNamesV2.ROE, false, RAW_MEAT_1);
    public static final Seafood SHRIMP = new Seafood(ItemNamesV2.SHRIMP, false, RAW_MEAT_1);
    public static final Seafood TUNA = new Seafood(ItemNamesV2.TUNA, false, RAW_MEAT_1);

    public static final Furnace BAKED_BEANS = new Furnace(ItemNamesV2.BAKED_BEANS, false, FURNACE_5);
    public static final Furnace BAKED_SWEET_POTATO = new Furnace(ItemNamesV2.BAKED_SWEET_POTATO, true, FURNACE_5);
    public static final Furnace BAKED_YAM = new Furnace(ItemNamesV2.BAKED_YAM, true, FURNACE_5);
    public static final Furnace CARAMEL = new Furnace(ItemNamesV2.CARAMEL, false, null);
    public static final Furnace COOKED_ANCHOVY = new Furnace(ItemNamesV2.COOKED_ANCHOVY, true, FURNACE_4);
    public static final Furnace COOKED_BACON = new Furnace(ItemNamesV2.COOKED_BACON, false, FURNACE_7);
    public static final Furnace COOKED_CALAMARI = new Furnace(ItemNamesV2.COOKED_CALAMARI, false, FURNACE_5);
    public static final Furnace COOKED_SHRIMP = new Furnace(ItemNamesV2.COOKED_SHRIMP, false, FURNACE_5);
    public static final Furnace COOKED_TUNA = new Furnace(ItemNamesV2.COOKED_TUNA, false, REG_6);
    public static final Furnace MOLASSES = new Furnace(ItemNamesV2.MOLASSES, false, null);
    public static final Furnace POPCORN = new Furnace(ItemNamesV2.POPCORN, false, FURNACE_3);
    public static final Furnace RAISINS = new Furnace(ItemNamesV2.RAISINS, false, FURNACE_3);
    public static final Furnace TOAST = new Furnace(ItemNamesV2.TOAST, true, FURNACE_7);

    public static final Juice APPLE_JUICE = new Juice(ItemNamesV2.APPLE_JUICE, APPLE);
    public static final Juice CRANBERRY_JUICE = new Juice(ItemNamesV2.CRANBERRY_JUICE, CRANBERRY);
    public static final Juice GRAPE_JUICE = new Juice(ItemNamesV2.GRAPE_JUICE, GRAPE);
    public static final Juice MELON_JUICE = new Juice(ItemNamesV2.MELON_JUICE, VanillaCrops.MELON);
    public static final Juice ORANGE_JUICE = new Juice(ItemNamesV2.ORANGE_JUICE, ORANGE);
    public static final Juice PINEAPPLE_JUICE = new Juice(ItemNamesV2.PINEAPPLE_JUICE, PINEAPPLE);
    public static final Juice SAGUARO_JUICE = new Juice(ItemNamesV2.SAGUARO_JUICE, SAGUARO);
    public static final Juice TOMATO_JUICE = new Juice(ItemNamesV2.TOMATO_JUICE, TOMATO, false);

    public static final Jam APRICOT_JAM = new Jam(ItemNamesV2.APRICOT_JAM, APRICOT);
    public static final Jam BLACKBERRY_JAM = new Jam(ItemNamesV2.BLACKBERRY_JAM, BLACKBERRY);
    public static final Jam BLUEBERRY_JAM = new Jam(ItemNamesV2.BLUEBERRY_JAM, BLUEBERRY);
    public static final Jam CHERRY_JAM = new Jam(ItemNamesV2.CHERRY_JAM, CHERRY);
    public static final Jam ELDERBERRY_JAM = new Jam(ItemNamesV2.ELDERBERRY_JAM, ELDERBERRY);
    public static final Jam GRAPE_JAM = new Jam(ItemNamesV2.GRAPE_JAM, GRAPE);
    public static final Jam PEACH_JAM = new Jam(ItemNamesV2.PEACH_JAM, PEACH);
    public static final Jam RASPBERRY_JAM = new Jam(ItemNamesV2.RASPBERRY_JAM, RASPBERRY);
    public static final Jam STRAWBERRY_JAM = new Jam(ItemNamesV2.STRAWBERRY_JAM, STRAWBERRY);

    public static final Smoothie BANANA_SMOOTHIE = new Smoothie(ItemNamesV2.BANANA_SMOOTHIE, BANANA);
    public static final Smoothie STRAWBERRY_SMOOTHIE = new Smoothie(ItemNamesV2.STRAWBERRY_SMOOTHIE, STRAWBERRY);

    public static final IceCream MANGO_ICE_CREAM = new IceCream(ItemNamesV2.MANGO_ICE_CREAM, MANGO);
    public static final IceCream PECAN_ICE_CREAM = new IceCream(ItemNamesV2.PECAN_ICE_CREAM, PECAN);
    public static final IceCream STRAWBERRY_ICE_CREAM = new IceCream(ItemNamesV2.STRAWBERRY_ICE_CREAM, STRAWBERRY);
    public static final IceCream VANILLA_ICE_CREAM = new IceCream(ItemNamesV2.VANILLA_ICE_CREAM, VANILLA);

    public static final Pie APPLE_PIE = new Pie(ItemNamesV2.APPLE_PIE, APPLE);
    public static final Pie CHERRY_PIE = new Pie(ItemNamesV2.CHERRY_PIE, CHERRY);
    public static final Pie PECAN_PIE = new Pie(ItemNamesV2.PECAN_PIE, PECAN);
    public static final Pie RHUBARB_PIE = new Pie(ItemNamesV2.RHUBARB_PIE, RHUBARB);

    public static final Utensil COOKING_POT = new Utensil(ItemNamesV2.COOKING_POT, true);
    public static final Utensil FOOD_PRESS = new Utensil(ItemNamesV2.FOOD_PRESS, false);
    public static final Utensil FRYING_PAN = new Utensil(ItemNamesV2.FRYING_PAN, true);
    public static final Utensil KNIFE = new Utensil(ItemNamesV2.KNIFE, true);
    public static final Utensil MORTAR_AND_PESTLE = new Utensil(ItemNamesV2.MORTAR_AND_PESTLE, true);

    // Spices
    public static SimpleItemWrapper PAPRIKA; // TODO need recipe to make paprika in future update
    public static SimpleItemWrapper SALT;

    // secondary ingredients?
    public static SimpleItemWrapper OLIVE_OIL;
    public static SimpleItemWrapper CHEESE;
    public static SimpleItemWrapper FLOUR;
    public static SimpleItemWrapper BUTTER;
    public static SimpleItemWrapper NOODLE;
    public static SimpleItemWrapper TOFU;
    public static SimpleItemWrapper CHOCOLATE;
    public static SimpleItemWrapper TORTILLA;
    public static SimpleItemWrapper SOY_SAUCE;
    public static SimpleItemWrapper DOUGH;
    public static SimpleItemWrapper RAVIOLI;
    public static SimpleItemWrapper SALSA;
    public static SimpleItemWrapper ARTICHOKE_DIP;
    public static SimpleItemWrapper PEPPERONI;

    // drinks
    public static SimpleItemWrapper COFFEE;
    public static SimpleItemWrapper LEMONADE;
    public static SimpleItemWrapper LIMEADE;
    public static SimpleItemWrapper SOY_MILK;

    public static SimpleItemWrapper KALE_SMOOTHIE;
    public static SimpleItemWrapper FRUIT_SMOOTHIE;

    public static SimpleItemWrapper CHOCOLATE_MILKSHAKE;

    public static SimpleItemWrapper BEER;
    public static SimpleItemWrapper WINE;
    public static SimpleItemWrapper MEAD;
    public static SimpleItemWrapper RUM;
    public static SimpleItemWrapper PUMPKIN_SPICE_LATTE;

    // snacks?
    public static SimpleItemWrapper BEEF_JERKY;
    public static SimpleItemWrapper PORK_JERKY;
    public static SimpleItemWrapper KALE_CHIPS;
    public static SimpleItemWrapper POTATO_CHIPS;
    public static SimpleItemWrapper STEAMED_RICE;
    public static SimpleItemWrapper FRENCH_FRIES;
    public static SimpleItemWrapper SWEET_POTATO_FRIES;
    public static SimpleItemWrapper ONION_RINGS;
    public static SimpleItemWrapper DOUGHNUT;
    public static SimpleItemWrapper CUCUMBER_SALAD;
    public static SimpleItemWrapper CAESAR_SALAD;
    public static SimpleItemWrapper LEAFY_SALAD;
    public static SimpleItemWrapper FRUIT_SALAD;
    public static SimpleItemWrapper VEGGIE_SALAD;
    public static SimpleItemWrapper PORK_AND_BEANS;
    public static SimpleItemWrapper OATMEAL;
    public static SimpleItemWrapper LEEK_SOUP;
    public static SimpleItemWrapper YOGHURT;
    public static SimpleItemWrapper SAUCY_CHIPS;
    public static SimpleItemWrapper ROASTED_NUTS;
    public static SimpleItemWrapper TRAIL_MIX;
    public static SimpleItemWrapper PROTEIN_BAR;
    public static SimpleItemWrapper NOUGAT;

    // breakfast
    public static SimpleItemWrapper SCRAMBLED_EGGS;
    public static SimpleItemWrapper BUTTERED_TOAST;
    public static SimpleItemWrapper TOAST_WITH_JAM;


    // meals
    public static SimpleItemWrapper HAM_SANDWICH;
    public static SimpleItemWrapper PEANUT_BUTTER_AND_JAM;
    public static SimpleItemWrapper BLT;
    public static SimpleItemWrapper GRILLED_CHEESE;
    public static SimpleItemWrapper TUNA_SANDWICH;
    public static SimpleItemWrapper CHEESEBURGER;
    public static SimpleItemWrapper HAMBURGER;
    public static SimpleItemWrapper TOFUBURGER;
    public static SimpleItemWrapper PIZZA;
    public static SimpleItemWrapper SUPREME_PIZZA;
    public static SimpleItemWrapper CHEESE_PIZZA;
    public static SimpleItemWrapper PINEAPPLE_PEPPERONI_PIZZA;
    public static SimpleItemWrapper LEMON_CHICKEN;
    public static SimpleItemWrapper FRIED_CHICKEN;
    public static SimpleItemWrapper CHICKEN_AND_NOODLES;
    public static SimpleItemWrapper CHICKEN_AND_DUMPLINGS;
    public static SimpleItemWrapper TOFU_AND_DUMPLINGS;
    public static SimpleItemWrapper SPAGHETTI_SQUASH;
    public static SimpleItemWrapper CHICKEN_AND_RICE;
    public static SimpleItemWrapper TACO;
    public static SimpleItemWrapper SUSHI;
    public static SimpleItemWrapper EGG_ROLL;
    public static SimpleItemWrapper CASHEW_CHICKEN;

    // desert block?
    //public static final SimpleItemWrapper coffeeCake;
    //public static final SimpleItemWrapper chocolateCake;
    //public static final SimpleItemWrapper strawberryShortCake;
    //public static final SimpleItemWrapper carrotCake;
    //public static final SimpleItemWrapper turtleCake;

    // desert SimpleItemWrapper
    public static SimpleItemWrapper YAM_JAM;
    public static SimpleItemWrapper BANANA_CREAM_PIE;
    public static SimpleItemWrapper CANDY_CORN;
    public static SimpleItemWrapper RUM_RAISIN_ICE_CREAM;
    public static SimpleItemWrapper CHEESE_CAKE;
    public static SimpleItemWrapper BROWNIES;
    public static SimpleItemWrapper SNICKER_DOODLE;
    public static SimpleItemWrapper BANANA_NUT_BREAD;
    public static SimpleItemWrapper CANDIED_NUTS;
    public static SimpleItemWrapper ALMOND_BRITTLE;
    public static SimpleItemWrapper OATMEAL_COOKIE;
    public static SimpleItemWrapper NUTTY_COOKIE;
    //public static final SimpleItemWrapper praline = new SimpleItemWrapper(createGroup().food(EDIBLE_5));

    public static SimpleItemWrapper BURRITO;
    public static SimpleItemWrapper TOSTADA;
    public static SimpleItemWrapper HORCHATA;
    public static SimpleItemWrapper CARNITAS;
    public static SimpleItemWrapper FAJITAS;
    public static SimpleItemWrapper ENCHILADA;
    public static SimpleItemWrapper CHURROS;
    public static SimpleItemWrapper TAMALES;
    public static SimpleItemWrapper TRES_LECHE_CAKE;
    public static SimpleItemWrapper STUFFED_POBLANOS;
    public static SimpleItemWrapper CHILI_RELLENO;
    public static SimpleItemWrapper CREMA;
    public static SimpleItemWrapper REFRIED_BEANS;
    public static SimpleItemWrapper CHIMICHANGA;
    public static SimpleItemWrapper QUESADILLA;

    public static SimpleItemWrapper CORN_HUSK;
    public static SimpleItemWrapper WHIPPING_CREAM;

    // 1.4.0
    public static SimpleItemWrapper SHEPHERDS_PIE;
    public static SimpleItemWrapper BEEF_WELLINGTON;
    public static SimpleItemWrapper FISH_AND_CHIPS;
    public static SimpleItemWrapper ETON_MESS;
    public static SimpleItemWrapper TEA;
    public static SimpleItemWrapper CORNISH_PASTY;
    public static SimpleItemWrapper SCONES;
    public static SimpleItemWrapper FIGGY_PUDDING;
    public static SimpleItemWrapper TREACLE_TART;
    public static SimpleItemWrapper STICKY_TOFFEE_PUDDING;
    public static SimpleItemWrapper TRIFLE;
    public static SimpleItemWrapper WATER_BOTTLE;
    public static SimpleItemWrapper MILK_BOTTLE;

    // 1.7.0
    public static SimpleItemWrapper AJVAR;
    public static SimpleItemWrapper AJVAR_TOAST;
    public static SimpleItemWrapper AVOCADO_TOAST;
    public static SimpleItemWrapper BEEF_STEW;
    public static SimpleItemWrapper BEEF_STIR_FRY;
    public static SimpleItemWrapper BUTTERED_GREEN_BEANS;
    public static SimpleItemWrapper CHEESY_ASPARAGUS;
    public static SimpleItemWrapper CHOCOLATE_ICE_CREAM;
    public static SimpleItemWrapper EGGPLANT_PARMESAN;
    public static SimpleItemWrapper FRUIT_CAKE;
    public static SimpleItemWrapper GRILLED_EGGPLANT;
    public static SimpleItemWrapper KIWI_SORBET;
    public static SimpleItemWrapper LEMON_COCONUT_BAR;
    public static SimpleItemWrapper NETHER_WART_STEW;
    public static SimpleItemWrapper PEANUT_BUTTER;
    public static SimpleItemWrapper PEANUT_BUTTER_W_CELERY;
    public static SimpleItemWrapper POTATO_SOUP;
    public static SimpleItemWrapper RATATOUILLE;
    public static SimpleItemWrapper RAW_BACON;
    public static SimpleItemWrapper RHUBARB_CRISP;
    public static SimpleItemWrapper ROASTED_ASPARAGUS;
    public static SimpleItemWrapper ROASTED_RADISHES;
    public static SimpleItemWrapper ROASTED_SQUASH;
    public static SimpleItemWrapper ROASTED_TURNIPS;
    public static SimpleItemWrapper STEAMED_BROCCOLI;
    public static SimpleItemWrapper STEAMED_GREEN_BEANS;
    public static SimpleItemWrapper STIR_FRY;
    public static SimpleItemWrapper STUFFED_ARTICHOKE;
    public static SimpleItemWrapper TOAST_SANDWICH;

    // 2.0.0
    public static SimpleItemWrapper ROASTED_PUMPKIN_SEEDS;
    public static SimpleItemWrapper ROASTED_SUNFLOWER_SEEDS;
    public static SimpleItemWrapper PUMPKIN_BARS;
    public static SimpleItemWrapper CORN_BREAD;
    public static SimpleItemWrapper PUMPKIN_SOUP;
    public static SimpleItemWrapper MERINGUE;
    public static SimpleItemWrapper CABBAGE_ROLL;
    public static SimpleItemWrapper BORSCHT;
    public static SimpleItemWrapper GOULASH;
    public static SimpleItemWrapper BEETROOT_SALAD;
    public static SimpleItemWrapper CANDIED_KUMQUATS;
    public static SimpleItemWrapper STEAMED_CRAB;
    public static SimpleItemWrapper SEA_LETTUCE;
    public static SimpleItemWrapper DEEP_FRIED_SHRIMP;
    public static SimpleItemWrapper TUNA_ROLL;
    public static SimpleItemWrapper FRIED_CALAMARI;
    public static SimpleItemWrapper CRAB_LEGS;
    public static SimpleItemWrapper STEAMED_CLAMS;
    public static SimpleItemWrapper GRILLED_OYSTERS;
    public static SimpleItemWrapper ANCHOVY_PIZZA;
    public static SimpleItemWrapper MASHED_POTATOES;

    // 2.1.0
    public static SimpleItemWrapper BAKED_CREPES;
    public static SimpleItemWrapper CINNAMON_ROLL; // 3
    public static SimpleItemWrapper CROQUE_MADAME;
    public static SimpleItemWrapper CROQUE_MONSIEUR;
    public static SimpleItemWrapper DAUPHINE_POTATOES;
    public static SimpleItemWrapper FRIED_FROG_LEGS;
    public static SimpleItemWrapper FROG_LEGS;
    public static SimpleItemWrapper GROUND_PORK;
    public static SimpleItemWrapper HASHED_BROWN;
    public static SimpleItemWrapper MACARON;
    public static SimpleItemWrapper QUICHE;
    public static SimpleItemWrapper SAUSAGE;
    public static SimpleItemWrapper SUNNY_SIDE_EGGS;
    public static SimpleItemWrapper SWEET_CREPES;
    public static SimpleItemWrapper THE_BIG_BREAKFAST;

    // V-3.0.0
    /*public static final SimpleItemWrapper CARROT_CAKE;
    public static final SimpleItemWrapper PICKLED_CUCUMBER;
    public static final SimpleItemWrapper PICKLED_BEETS;
    public static final SimpleItemWrapper PICKLED_RADISH;
    public static final SimpleItemWrapper PICKLED_GARLIC;
    public static final SimpleItemWrapper PICKLED_ONIONS;
    public static final SimpleItemWrapper PICKLED_GINGER;
    public static final SimpleItemWrapper KIMCHI;
    public static final SimpleItemWrapper SAUERKRAUT;
    public static final SimpleItemWrapper PICKLED_ANCHOVIES;
    public static final SimpleItemWrapper PICKLED_EGGS;

    public static final SimpleItemWrapper BIBIMBAP;
    public static final SimpleItemWrapper TTEOKBOKKI;
    public static final SimpleItemWrapper BIBIM_NENGMYUM;

    public static final SimpleItemWrapper EGG_FRIED_RICE; // rice, egg, soy sauce, salt,
    public static final SimpleItemWrapper FRIED_RICE; // rice, soy sauce, <MIXED INGREDIENT (beef, pork, shrimp, tofu)>, salt,
    public static final SimpleItemWrapper VEGGIE_FRIED_RICE; // rice, soy sauce, green onion, carrot, green beans, salt

    public static final SimpleItemWrapper SESAME_CHICKEN;
    public static final SimpleItemWrapper ORANGE_CHICKEN;
    public static final SimpleItemWrapper PINEAPPLE_CHICKEN;
    public static final SimpleItemWrapper BEEF_AND_BROCCOLI;
    public static final SimpleItemWrapper EGG_FU_YUNG;
    public static final SimpleItemWrapper TERYAKI_CHICKEN;

    public static final SimpleItemWrapper COOKING_OIL; // crafted by using (avocado/walnut/almond/corn/vegetables/w/e else for oils)
    public static final FarmlandCrop FLAX;*/



    public static Block SALT_ORE_BLOCK;
    public static Item SALT_ORE;

    public static Item GUIDE;

    public static void registerBlocks(RegisterFunction<Block> register) {
        for (Consumer<RegisterFunction<Block>> entry : BLOCK_REGISTER.getEntries()) {
            entry.accept(register);
        }

        SALT_ORE_BLOCK = register.register(createIdentifier(BlockNames.SALT_ORE), () ->new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.5F).sound(SoundType.SAND)));
    }


    public static void registerItems(RegisterFunction<Item> register) {
        for (Consumer<RegisterFunction<Item>> entry : ITEM_REGISTER.getEntries()) {
            entry.accept(register);
        }

        PAPRIKA = new SimpleItemWrapper(ItemNamesV2.PAPRIKA, false, register.register(createIdentifier(ItemNamesV2.PAPRIKA), () -> new Item(createGroup())));
        SALT = new SimpleItemWrapper(ItemNamesV2.SALT, true, register.register(createIdentifier(ItemNamesV2.SALT), () -> new Item(createGroup())));
        OLIVE_OIL = new SimpleItemWrapper(ItemNamesV2.OLIVE_OIL, true, register.register(createIdentifier(ItemNamesV2.OLIVE_OIL), () -> new Item(createGroup())));
        CHEESE = new SimpleItemWrapper(ItemNamesV2.CHEESE, true, register.register(createIdentifier(ItemNamesV2.CHEESE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_3)))));
        FLOUR = new SimpleItemWrapper(ItemNamesV2. FLOUR, false, register.register(createIdentifier(ItemNamesV2.FLOUR), () -> new Item(createGroup())));
        BUTTER = new SimpleItemWrapper(ItemNamesV2.BUTTER, true, register.register(createIdentifier(ItemNamesV2.BUTTER), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_3)))));
        NOODLE = new SimpleItemWrapper(ItemNamesV2.NOODLE, true, register.register(createIdentifier(ItemNamesV2.NOODLE), () -> new Item(createGroup())));
        TOFU = new SimpleItemWrapper(ItemNamesV2.TOFU, false, register.register(createIdentifier(ItemNamesV2.TOFU), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        CHOCOLATE = new SimpleItemWrapper(ItemNamesV2.CHOCOLATE, true, register.register(createIdentifier(ItemNamesV2.CHOCOLATE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        TORTILLA = new SimpleItemWrapper(ItemNamesV2.TORTILLA, true, register.register(createIdentifier(ItemNamesV2.TORTILLA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        SOY_SAUCE = new SimpleItemWrapper(ItemNamesV2.SOY_SAUCE, true, register.register(createIdentifier(ItemNamesV2.SOY_SAUCE), () -> new Item(createGroup())));
        DOUGH = new SimpleItemWrapper(ItemNamesV2.DOUGH, true, register.register(createIdentifier(ItemNamesV2.DOUGH), () -> new Item(createGroup())));
        RAVIOLI = new SimpleItemWrapper(ItemNamesV2.RAVIOLI, false, register.register(createIdentifier(ItemNamesV2.RAVIOLI), () -> new Item(createGroup())));
        SALSA = new SimpleItemWrapper(ItemNamesV2.SALSA, true, register.register(createIdentifier(ItemNamesV2.SALSA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        ARTICHOKE_DIP = new SimpleItemWrapper(ItemNamesV2.ARTICHOKE_DIP, true, register.register(createIdentifier(ItemNamesV2.ARTICHOKE_DIP), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        PEPPERONI = new SimpleItemWrapper(ItemNamesV2.PEPPERONI, false, register.register(createIdentifier(ItemNamesV2.PEPPERONI), () -> new Item(createGroup().food(FoodConstructor.createBuilder(REG_5).build()))));
        COFFEE = new SimpleItemWrapper(ItemNamesV2.COFFEE, true, register.register(createIdentifier(ItemNamesV2.COFFEE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_5).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        LEMONADE = new SimpleItemWrapper(ItemNamesV2.LEMONADE, true, register.register(createIdentifier(ItemNamesV2.LEMONADE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_5).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        LIMEADE = new SimpleItemWrapper(ItemNamesV2.LIMEADE, true, register.register(createIdentifier(ItemNamesV2.LIMEADE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_5).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        SOY_MILK = new SimpleItemWrapper(ItemNamesV2.SOY_MILK, true, register.register(createIdentifier(ItemNamesV2.SOY_MILK), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_5).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        KALE_SMOOTHIE = new SimpleItemWrapper(ItemNamesV2.KALE_SMOOTHIE, true, register.register(createIdentifier(ItemNamesV2.KALE_SMOOTHIE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_14).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        FRUIT_SMOOTHIE = new SimpleItemWrapper(ItemNamesV2.FRUIT_SMOOTHIE, true, register.register(createIdentifier(ItemNamesV2.FRUIT_SMOOTHIE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_7).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        CHOCOLATE_MILKSHAKE = new SimpleItemWrapper(ItemNamesV2.CHOCOLATE_MILKSHAKE, true, register.register(createIdentifier(ItemNamesV2.CHOCOLATE_MILKSHAKE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_7).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        BEER = new SimpleItemWrapper(ItemNamesV2.BEER, true, register.register(createIdentifier(ItemNamesV2.BEER), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_7).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        WINE = new SimpleItemWrapper(ItemNamesV2.WINE, true, register.register(createIdentifier(ItemNamesV2.WINE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_7).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        MEAD = new SimpleItemWrapper(ItemNamesV2.MEAD, true, register.register(createIdentifier(ItemNamesV2.MEAD), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_7).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        RUM = new SimpleItemWrapper(ItemNamesV2.RUM, true, register.register(createIdentifier(ItemNamesV2.RUM), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_7).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE))));
        PUMPKIN_SPICE_LATTE = new SimpleItemWrapper(ItemNamesV2.PUMPKIN_SPICE_LATTE, true, register.register(createIdentifier(ItemNamesV2.PUMPKIN_SPICE_LATTE), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_14).alwaysEdible().build()))));
        BEEF_JERKY = new SimpleItemWrapper(ItemNamesV2.BEEF_JERKY, true, register.register(createIdentifier(ItemNamesV2.BEEF_JERKY), () -> new Item(createGroup().food(FoodConstructor.createBuilder(REG_5).build()))));
        PORK_JERKY = new SimpleItemWrapper(ItemNamesV2.PORK_JERKY, true, register.register(createIdentifier(ItemNamesV2.PORK_JERKY), () -> new Item(createGroup().food(FoodConstructor.createBuilder(REG_5).build()))));
        KALE_CHIPS = new SimpleItemWrapper(ItemNamesV2.KALE_CHIPS, false, register.register(createIdentifier(ItemNamesV2.KALE_CHIPS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        POTATO_CHIPS = new SimpleItemWrapper(ItemNamesV2.POTATO_CHIPS, false, register.register(createIdentifier(ItemNamesV2.POTATO_CHIPS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        STEAMED_RICE = new SimpleItemWrapper(ItemNamesV2.STEAMED_RICE, true, register.register(createIdentifier(ItemNamesV2.STEAMED_RICE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        FRENCH_FRIES = new SimpleItemWrapper(ItemNamesV2.FRENCH_FRIES, false, register.register(createIdentifier(ItemNamesV2.FRENCH_FRIES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        SWEET_POTATO_FRIES = new SimpleItemWrapper(ItemNamesV2.SWEET_POTATO_FRIES, false, register.register(createIdentifier(ItemNamesV2.SWEET_POTATO_FRIES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        ONION_RINGS = new SimpleItemWrapper(ItemNamesV2.ONION_RINGS, false, register.register(createIdentifier(ItemNamesV2.ONION_RINGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        DOUGHNUT = new SimpleItemWrapper(ItemNamesV2.DOUGHNUT, true, register.register(createIdentifier(ItemNamesV2.DOUGHNUT), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        CUCUMBER_SALAD = new SimpleItemWrapper(ItemNamesV2.CUCUMBER_SALAD, true, register.register(createIdentifier(ItemNamesV2.CUCUMBER_SALAD), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_10)))));
        CAESAR_SALAD = new SimpleItemWrapper(ItemNamesV2.CAESAR_SALAD, true, register.register(createIdentifier(ItemNamesV2.CAESAR_SALAD), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_10)))));
        LEAFY_SALAD = new SimpleItemWrapper(ItemNamesV2.LEAFY_SALAD, true, register.register(createIdentifier(ItemNamesV2.LEAFY_SALAD), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_10)))));
        FRUIT_SALAD = new SimpleItemWrapper(ItemNamesV2.FRUIT_SALAD, true, register.register(createIdentifier(ItemNamesV2.FRUIT_SALAD), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_10)))));
        VEGGIE_SALAD = new SimpleItemWrapper(ItemNamesV2.VEGGIE_SALAD, true, register.register(createIdentifier(ItemNamesV2.VEGGIE_SALAD), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_10)))));
        PORK_AND_BEANS = new SimpleItemWrapper(ItemNamesV2.PORK_AND_BEANS, false, register.register(createIdentifier(ItemNamesV2.PORK_AND_BEANS), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_10)))));
        OATMEAL = new SimpleItemWrapper(ItemNamesV2.OATMEAL, true, register.register(createIdentifier(ItemNamesV2.OATMEAL), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_7)))));
        LEEK_SOUP = new SimpleItemWrapper(ItemNamesV2.LEEK_SOUP, true, register.register(createIdentifier(ItemNamesV2.LEEK_SOUP), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_7)))));
        YOGHURT = new SimpleItemWrapper(ItemNamesV2.YOGHURT, true, register.register(createIdentifier(ItemNamesV2.YOGHURT), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_5)))));
        SAUCY_CHIPS = new SimpleItemWrapper(ItemNamesV2.SAUCY_CHIPS, false, register.register(createIdentifier(ItemNamesV2.SAUCY_CHIPS), () -> new Soup(createGroup().food(FoodConstructor.createFoodBowl(REG_7)))));
        ROASTED_NUTS = new SimpleItemWrapper(ItemNamesV2.ROASTED_NUTS, false, register.register(createIdentifier(ItemNamesV2.ROASTED_NUTS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        TRAIL_MIX = new SimpleItemWrapper(ItemNamesV2.TRAIL_MIX, true, register.register(createIdentifier(ItemNamesV2.TRAIL_MIX), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        PROTEIN_BAR = new SimpleItemWrapper(ItemNamesV2.PROTEIN_BAR, true, register.register(createIdentifier(ItemNamesV2.PROTEIN_BAR), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        NOUGAT = new SimpleItemWrapper(ItemNamesV2.NOUGAT, true, register.register(createIdentifier(ItemNamesV2.NOUGAT), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        SCRAMBLED_EGGS = new SimpleItemWrapper(ItemNamesV2.SCRAMBLED_EGGS, false, register.register(createIdentifier(ItemNamesV2.SCRAMBLED_EGGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        BUTTERED_TOAST = new SimpleItemWrapper(ItemNamesV2.BUTTERED_TOAST, true, register.register(createIdentifier(ItemNamesV2.BUTTERED_TOAST), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_9)))));
        TOAST_WITH_JAM = new SimpleItemWrapper(ItemNamesV2.TOAST_WITH_JAM, false, register.register(createIdentifier(ItemNamesV2.TOAST_WITH_JAM), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_9)))));
        HAM_SANDWICH = new SimpleItemWrapper(ItemNamesV2.HAM_SANDWICH, true, register.register(createIdentifier(ItemNamesV2.HAM_SANDWICH), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        PEANUT_BUTTER_AND_JAM = new SimpleItemWrapper(ItemNamesV2.PEANUT_BUTTER_AND_JAM, false, register.register(createIdentifier(ItemNamesV2.PEANUT_BUTTER_AND_JAM), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        BLT = new SimpleItemWrapper(ItemNamesV2.BLT, true, register.register(createIdentifier(ItemNamesV2.BLT), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        GRILLED_CHEESE = new SimpleItemWrapper(ItemNamesV2.GRILLED_CHEESE, true, register.register(createIdentifier(ItemNamesV2.GRILLED_CHEESE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        TUNA_SANDWICH = new SimpleItemWrapper(ItemNamesV2.TUNA_SANDWICH, true, register.register(createIdentifier(ItemNamesV2.TUNA_SANDWICH), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHEESEBURGER = new SimpleItemWrapper(ItemNamesV2.CHEESEBURGER, true, register.register(createIdentifier(ItemNamesV2.CHEESEBURGER), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        HAMBURGER = new SimpleItemWrapper(ItemNamesV2.HAMBURGER, true, register.register(createIdentifier(ItemNamesV2.HAMBURGER), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TOFUBURGER = new SimpleItemWrapper(ItemNamesV2.TOFUBURGER, true, register.register(createIdentifier(ItemNamesV2.TOFUBURGER), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        PIZZA = new SimpleItemWrapper(ItemNamesV2.PIZZA, true, register.register(createIdentifier(ItemNamesV2.PIZZA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        SUPREME_PIZZA = new SimpleItemWrapper(ItemNamesV2.SUPREME_PIZZA, true, register.register(createIdentifier(ItemNamesV2.SUPREME_PIZZA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        CHEESE_PIZZA = new SimpleItemWrapper(ItemNamesV2.CHEESE_PIZZA, true, register.register(createIdentifier(ItemNamesV2.CHEESE_PIZZA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        PINEAPPLE_PEPPERONI_PIZZA = new SimpleItemWrapper(ItemNamesV2.PINEAPPLE_PEPPERONI_PIZZA, true, register.register(createIdentifier(ItemNamesV2.PINEAPPLE_PEPPERONI_PIZZA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        LEMON_CHICKEN = new SimpleItemWrapper(ItemNamesV2.LEMON_CHICKEN, true, register.register(createIdentifier(ItemNamesV2.LEMON_CHICKEN), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        FRIED_CHICKEN = new SimpleItemWrapper(ItemNamesV2.FRIED_CHICKEN, true, register.register(createIdentifier(ItemNamesV2.FRIED_CHICKEN), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHICKEN_AND_NOODLES = new SimpleItemWrapper(ItemNamesV2.CHICKEN_AND_NOODLES, false, register.register(createIdentifier(ItemNamesV2.CHICKEN_AND_NOODLES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHICKEN_AND_DUMPLINGS = new SimpleItemWrapper(ItemNamesV2.CHICKEN_AND_DUMPLINGS, false, register.register(createIdentifier(ItemNamesV2.CHICKEN_AND_DUMPLINGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TOFU_AND_DUMPLINGS = new SimpleItemWrapper(ItemNamesV2.TOFU_AND_DUMPLINGS, false, register.register(createIdentifier(ItemNamesV2.TOFU_AND_DUMPLINGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        SPAGHETTI_SQUASH = new SimpleItemWrapper(ItemNamesV2.SPAGHETTI_SQUASH, true, register.register(createIdentifier(ItemNamesV2.SPAGHETTI_SQUASH), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHICKEN_AND_RICE = new SimpleItemWrapper(ItemNamesV2.CHICKEN_AND_RICE, false, register.register(createIdentifier(ItemNamesV2.CHICKEN_AND_RICE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TACO = new SimpleItemWrapper(ItemNamesV2.TACO, true, register.register(createIdentifier(ItemNamesV2.TACO), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        SUSHI = new SimpleItemWrapper(ItemNamesV2.SUSHI, true, register.register(createIdentifier(ItemNamesV2.SUSHI), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        EGG_ROLL = new SimpleItemWrapper(ItemNamesV2.EGG_ROLL, true, register.register(createIdentifier(ItemNamesV2.EGG_ROLL), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CASHEW_CHICKEN = new SimpleItemWrapper(ItemNamesV2.CASHEW_CHICKEN, true, register.register(createIdentifier(ItemNamesV2.CASHEW_CHICKEN), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        YAM_JAM = new SimpleItemWrapper(ItemNamesV2.YAM_JAM, false, register.register(createIdentifier(ItemNamesV2.YAM_JAM), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        BANANA_CREAM_PIE = new SimpleItemWrapper(ItemNamesV2.BANANA_CREAM_PIE, true, register.register(createIdentifier(ItemNamesV2.BANANA_CREAM_PIE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        CANDY_CORN = new SimpleItemWrapper(ItemNamesV2.CANDY_CORN, true, register.register(createIdentifier(ItemNamesV2.CANDY_CORN), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        RUM_RAISIN_ICE_CREAM = new SimpleItemWrapper(ItemNamesV2.RUM_RAISIN_ICE_CREAM, true, register.register(createIdentifier(ItemNamesV2.RUM_RAISIN_ICE_CREAM), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        CHEESE_CAKE = new SimpleItemWrapper(ItemNamesV2.CHEESE_CAKE, true, register.register(createIdentifier(ItemNamesV2.CHEESE_CAKE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        BROWNIES = new SimpleItemWrapper(ItemNamesV2.BROWNIES, false, register.register(createIdentifier(ItemNamesV2.BROWNIES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        SNICKER_DOODLE = new SimpleItemWrapper(ItemNamesV2.SNICKER_DOODLE, true, register.register(createIdentifier(ItemNamesV2.SNICKER_DOODLE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        BANANA_NUT_BREAD = new SimpleItemWrapper(ItemNamesV2.BANANA_NUT_BREAD, true, register.register(createIdentifier(ItemNamesV2.BANANA_NUT_BREAD), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CANDIED_NUTS = new SimpleItemWrapper(ItemNamesV2.CANDIED_NUTS, false, register.register(createIdentifier(ItemNamesV2.CANDIED_NUTS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        ALMOND_BRITTLE = new SimpleItemWrapper(ItemNamesV2.ALMOND_BRITTLE, true, register.register(createIdentifier(ItemNamesV2.ALMOND_BRITTLE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        OATMEAL_COOKIE = new SimpleItemWrapper(ItemNamesV2.RAISIN_OATMEAL_COOKIE, true, register.register(createIdentifier(ItemNamesV2.RAISIN_OATMEAL_COOKIE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        NUTTY_COOKIE = new SimpleItemWrapper(ItemNamesV2.NUTTY_COOKIE, true, register.register(createIdentifier(ItemNamesV2.NUTTY_COOKIE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        BURRITO = new SimpleItemWrapper(ItemNamesV2.BURRITO, true, register.register(createIdentifier(ItemNamesV2.BURRITO), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TOSTADA = new SimpleItemWrapper(ItemNamesV2.TOSTADA, true, register.register(createIdentifier(ItemNamesV2.TOSTADA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        HORCHATA = new SimpleItemWrapper(ItemNamesV2.HORCHATA, true, register.register(createIdentifier(ItemNamesV2.HORCHATA), () -> new Drink(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CARNITAS = new SimpleItemWrapper(ItemNamesV2.CARNITAS, false, register.register(createIdentifier(ItemNamesV2.CARNITAS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        FAJITAS = new SimpleItemWrapper(ItemNamesV2.FAJITAS, false, register.register(createIdentifier(ItemNamesV2.FAJITAS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        ENCHILADA = new SimpleItemWrapper(ItemNamesV2.ENCHILADA, true, register.register(createIdentifier(ItemNamesV2.ENCHILADA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHURROS = new SimpleItemWrapper(ItemNamesV2.CHURROS, false, register.register(createIdentifier(ItemNamesV2.CHURROS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        TAMALES = new SimpleItemWrapper(ItemNamesV2.TAMALES, false, register.register(createIdentifier(ItemNamesV2.TAMALES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        TRES_LECHE_CAKE = new SimpleItemWrapper(ItemNamesV2.TRES_LECHE_CAKE, true, register.register(createIdentifier(ItemNamesV2.TRES_LECHE_CAKE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        STUFFED_POBLANOS = new SimpleItemWrapper(ItemNamesV2.STUFFED_POBLANOS, false, register.register(createIdentifier(ItemNamesV2.STUFFED_POBLANOS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        CHILI_RELLENO = new SimpleItemWrapper(ItemNamesV2.CHILI_RELLENO, true, register.register(createIdentifier(ItemNamesV2.CHILI_RELLENO), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        CREMA = new SimpleItemWrapper(ItemNamesV2.CREMA, false, register.register(createIdentifier(ItemNamesV2.CREMA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_3)))));
        REFRIED_BEANS = new SimpleItemWrapper(ItemNamesV2.REFRIED_BEANS, false, register.register(createIdentifier(ItemNamesV2.REFRIED_BEANS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        CHIMICHANGA = new SimpleItemWrapper(ItemNamesV2.CHIMICHANGA, true, register.register(createIdentifier(ItemNamesV2.CHIMICHANGA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        QUESADILLA = new SimpleItemWrapper(ItemNamesV2.QUESADILLA, true, register.register(createIdentifier(ItemNamesV2.QUESADILLA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CORN_HUSK = new SimpleItemWrapper(ItemNamesV2.CORN_HUSK, true, register.register(createIdentifier(ItemNamesV2.CORN_HUSK), () -> new Item(createGroup())));
        WHIPPING_CREAM = new SimpleItemWrapper(ItemNamesV2.WHIPPING_CREAM, false, register.register(createIdentifier(ItemNamesV2.WHIPPING_CREAM), () -> new Item(createGroup())));
        SHEPHERDS_PIE = new SimpleItemWrapper(ItemNamesV2.SHEPHERDS_PIE, false, register.register(createIdentifier(ItemNamesV2.SHEPHERDS_PIE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        BEEF_WELLINGTON = new SimpleItemWrapper(ItemNamesV2.BEEF_WELLINGTON, false, register.register(createIdentifier(ItemNamesV2.BEEF_WELLINGTON), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        FISH_AND_CHIPS = new SimpleItemWrapper(ItemNamesV2.FISH_AND_CHIPS, false, register.register(createIdentifier(ItemNamesV2.FISH_AND_CHIPS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        ETON_MESS = new SimpleItemWrapper(ItemNamesV2.ETON_MESS, false, register.register(createIdentifier(ItemNamesV2.ETON_MESS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TEA = new SimpleItemWrapper(ItemNamesV2.TEA, false, register.register(createIdentifier(ItemNamesV2.TEA), () -> new Drink(createGroup().food(FoodConstructor.createBuilder(REG_5).alwaysEdible().build()))));
        CORNISH_PASTY = new SimpleItemWrapper(ItemNamesV2.CORNISH_PASTY, false, register.register(createIdentifier(ItemNamesV2.CORNISH_PASTY), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        SCONES = new SimpleItemWrapper(ItemNamesV2.SCONES, false, register.register(createIdentifier(ItemNamesV2.SCONES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        FIGGY_PUDDING = new SimpleItemWrapper(ItemNamesV2.FIGGY_PUDDING, false, register.register(createIdentifier(ItemNamesV2.FIGGY_PUDDING), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TREACLE_TART = new SimpleItemWrapper(ItemNamesV2.TREACLE_TART, true, register.register(createIdentifier(ItemNamesV2.TREACLE_TART), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        STICKY_TOFFEE_PUDDING = new SimpleItemWrapper(ItemNamesV2.STICKY_TOFFEE_PUDDING, false, register.register(createIdentifier(ItemNamesV2.STICKY_TOFFEE_PUDDING), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        TRIFLE = new SimpleItemWrapper(ItemNamesV2.TRIFLE, false, register.register(createIdentifier(ItemNamesV2.TRIFLE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        WATER_BOTTLE = new SimpleItemWrapper(ItemNamesV2.WATER_BOTTLE, true, register.register(createIdentifier(ItemNamesV2.WATER_BOTTLE), () -> new Item(createGroup())));
        MILK_BOTTLE = new SimpleItemWrapper(ItemNamesV2.MILK_BOTTLE, true, register.register(createIdentifier(ItemNamesV2.MILK_BOTTLE), () -> new Item(createGroup())));
        AJVAR = new SimpleItemWrapper(ItemNamesV2.AJVAR, false, register.register(createIdentifier(ItemNamesV2.AJVAR), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        AJVAR_TOAST = new SimpleItemWrapper(ItemNamesV2.AJVAR_TOAST, true, register.register(createIdentifier(ItemNamesV2.AJVAR_TOAST), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        AVOCADO_TOAST = new SimpleItemWrapper(ItemNamesV2.AVOCADO_TOAST, true, register.register(createIdentifier(ItemNamesV2.AVOCADO_TOAST), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        BEEF_STEW = new SimpleItemWrapper(ItemNamesV2.BEEF_STEW, false, register.register(createIdentifier(ItemNamesV2.BEEF_STEW), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        BEEF_STIR_FRY = new SimpleItemWrapper(ItemNamesV2.BEEF_STIR_FRY, true, register.register(createIdentifier(ItemNamesV2.BEEF_STIR_FRY), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        BUTTERED_GREEN_BEANS = new SimpleItemWrapper(ItemNamesV2.BUTTERED_GREEN_BEANS, false, register.register(createIdentifier(ItemNamesV2.BUTTERED_GREEN_BEANS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHEESY_ASPARAGUS = new SimpleItemWrapper(ItemNamesV2.CHEESY_ASPARAGUS, false, register.register(createIdentifier(ItemNamesV2.CHEESY_ASPARAGUS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CHOCOLATE_ICE_CREAM = new SimpleItemWrapper(ItemNamesV2.CHOCOLATE_ICE_CREAM, true, register.register(createIdentifier(ItemNamesV2.CHOCOLATE_ICE_CREAM), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        EGGPLANT_PARMESAN = new SimpleItemWrapper(ItemNamesV2.EGGPLANT_PARMESAN, false, register.register(createIdentifier(ItemNamesV2.EGGPLANT_PARMESAN), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        FRUIT_CAKE = new SimpleItemWrapper(ItemNamesV2.FRUIT_CAKE, true, register.register(createIdentifier(ItemNamesV2.FRUIT_CAKE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        GRILLED_EGGPLANT = new SimpleItemWrapper(ItemNamesV2.GRILLED_EGGPLANT, true, register.register(createIdentifier(ItemNamesV2.GRILLED_EGGPLANT), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        KIWI_SORBET = new SimpleItemWrapper(ItemNamesV2.KIWI_SORBET, true, register.register(createIdentifier(ItemNamesV2.KIWI_SORBET), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        LEMON_COCONUT_BAR = new SimpleItemWrapper(ItemNamesV2.LEMON_COCONUT_BAR, true, register.register(createIdentifier(ItemNamesV2.LEMON_COCONUT_BAR), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        NETHER_WART_STEW = new SimpleItemWrapper(ItemNamesV2.NETHER_WART_STEW, true, register.register(createIdentifier(ItemNamesV2.NETHER_WART_STEW), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        PEANUT_BUTTER = new SimpleItemWrapper(ItemNamesV2.PEANUT_BUTTER, false, register.register(createIdentifier(ItemNamesV2.PEANUT_BUTTER), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        PEANUT_BUTTER_W_CELERY = new SimpleItemWrapper(ItemNamesV2.PEANUT_BUTTER_W_CELERY, true, register.register(createIdentifier(ItemNamesV2.PEANUT_BUTTER_W_CELERY), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        POTATO_SOUP = new SimpleItemWrapper(ItemNamesV2.POTATO_SOUP, false, register.register(createIdentifier(ItemNamesV2.POTATO_SOUP), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        RATATOUILLE = new SimpleItemWrapper(ItemNamesV2.RATATOUILLE, true, register.register(createIdentifier(ItemNamesV2.RATATOUILLE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        RAW_BACON = new SimpleItemWrapper(ItemNamesV2.RAW_BACON, false, register.register(createIdentifier(ItemNamesV2.RAW_BACON), () -> new Item(createGroup().food(FoodConstructor.createBuilder(REG_1).build()))));
        RHUBARB_CRISP = new SimpleItemWrapper(ItemNamesV2.RHUBARB_CRISP, true, register.register(createIdentifier(ItemNamesV2.RHUBARB_CRISP), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        ROASTED_ASPARAGUS = new SimpleItemWrapper(ItemNamesV2.ROASTED_ASPARAGUS, false, register.register(createIdentifier(ItemNamesV2.ROASTED_ASPARAGUS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        ROASTED_RADISHES = new SimpleItemWrapper(ItemNamesV2.ROASTED_RADISHES, false, register.register(createIdentifier(ItemNamesV2.ROASTED_RADISHES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        ROASTED_SQUASH = new SimpleItemWrapper(ItemNamesV2.ROASTED_SQUASH, true, register.register(createIdentifier(ItemNamesV2.ROASTED_SQUASH), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        ROASTED_TURNIPS = new SimpleItemWrapper(ItemNamesV2.ROASTED_TURNIPS, false, register.register(createIdentifier(ItemNamesV2.ROASTED_TURNIPS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        STEAMED_BROCCOLI = new SimpleItemWrapper(ItemNamesV2.STEAMED_BROCCOLI, true, register.register(createIdentifier(ItemNamesV2.STEAMED_BROCCOLI), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        STEAMED_GREEN_BEANS = new SimpleItemWrapper(ItemNamesV2.STEAMED_GREEN_BEANS, false, register.register(createIdentifier(ItemNamesV2.STEAMED_GREEN_BEANS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_7)))));
        STIR_FRY = new SimpleItemWrapper(ItemNamesV2.STIR_FRY, false, register.register(createIdentifier(ItemNamesV2.STIR_FRY), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_12)))));
        STUFFED_ARTICHOKE = new SimpleItemWrapper(ItemNamesV2.STUFFED_ARTICHOKE, true, register.register(createIdentifier(ItemNamesV2.STUFFED_ARTICHOKE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_18)))));
        TOAST_SANDWICH = new SimpleItemWrapper(ItemNamesV2.TOAST_SANDWICH, true, register.register(createIdentifier(ItemNamesV2.TOAST_SANDWICH), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        ROASTED_PUMPKIN_SEEDS = new SimpleItemWrapper(ItemNamesV2.ROASTED_PUMPKIN_SEEDS, false, register.register(createIdentifier(ItemNamesV2.ROASTED_PUMPKIN_SEEDS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_4)))));
        ROASTED_SUNFLOWER_SEEDS = new SimpleItemWrapper(ItemNamesV2.ROASTED_SUNFLOWER_SEEDS, false, register.register(createIdentifier(ItemNamesV2.ROASTED_SUNFLOWER_SEEDS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_4)))));
        PUMPKIN_BARS = new SimpleItemWrapper(ItemNamesV2.PUMPKIN_BARS, false, register.register(createIdentifier(ItemNamesV2.PUMPKIN_BARS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_6)))));
        CORN_BREAD = new SimpleItemWrapper(ItemNamesV2.CORN_BREAD, true, register.register(createIdentifier(ItemNamesV2.CORN_BREAD), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        PUMPKIN_SOUP = new SimpleItemWrapper(ItemNamesV2.PUMPKIN_SOUP, true, register.register(createIdentifier(ItemNamesV2.PUMPKIN_SOUP), () -> new Soup(createGroup().food(FoodConstructor.createFood(REG_10)))));
        MERINGUE = new SimpleItemWrapper(ItemNamesV2.MERINGUE, false, register.register(createIdentifier(ItemNamesV2.MERINGUE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_6)))));
        CABBAGE_ROLL = new SimpleItemWrapper(ItemNamesV2.CABBAGE_ROLL, true, register.register(createIdentifier(ItemNamesV2.CABBAGE_ROLL), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        BORSCHT = new SimpleItemWrapper(ItemNamesV2.BORSCHT, false, register.register(createIdentifier(ItemNamesV2.BORSCHT), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_12)))));
        GOULASH = new SimpleItemWrapper(ItemNamesV2.GOULASH, true, register.register(createIdentifier(ItemNamesV2.GOULASH), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_16)))));
        BEETROOT_SALAD = new SimpleItemWrapper(ItemNamesV2.BEETROOT_SALAD, true, register.register(createIdentifier(ItemNamesV2.BEETROOT_SALAD), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CANDIED_KUMQUATS = new SimpleItemWrapper(ItemNamesV2.CANDIED_KUMQUATS, false, register.register(createIdentifier(ItemNamesV2.CANDIED_KUMQUATS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_6)))));
        STEAMED_CRAB = new SimpleItemWrapper(ItemNamesV2.STEAMED_CRAB, true, register.register(createIdentifier(ItemNamesV2.STEAMED_CRAB), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_6)))));
        SEA_LETTUCE = new SimpleItemWrapper(ItemNamesV2.SEA_LETTUCE, false, register.register(createIdentifier(ItemNamesV2.SEA_LETTUCE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_1)))));
        DEEP_FRIED_SHRIMP = new SimpleItemWrapper(ItemNamesV2.DEEP_FRIED_SHRIMP, false, register.register(createIdentifier(ItemNamesV2.DEEP_FRIED_SHRIMP), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        TUNA_ROLL = new SimpleItemWrapper(ItemNamesV2.TUNA_ROLL, true, register.register(createIdentifier(ItemNamesV2.TUNA_ROLL), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        FRIED_CALAMARI = new SimpleItemWrapper(ItemNamesV2.FRIED_CALAMARI, false, register.register(createIdentifier(ItemNamesV2.FRIED_CALAMARI), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_10)))));
        CRAB_LEGS = new SimpleItemWrapper(ItemNamesV2.CRAB_LEGS, false, register.register(createIdentifier(ItemNamesV2.CRAB_LEGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_11)))));
        STEAMED_CLAMS = new SimpleItemWrapper(ItemNamesV2.STEAMED_CLAMS, false, register.register(createIdentifier(ItemNamesV2.STEAMED_CLAMS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_11)))));
        GRILLED_OYSTERS = new SimpleItemWrapper(ItemNamesV2.GRILLED_OYSTERS, false, register.register(createIdentifier(ItemNamesV2.GRILLED_OYSTERS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_11)))));
        ANCHOVY_PIZZA = new SimpleItemWrapper(ItemNamesV2.ANCHOVY_PIZZA, true, register.register(createIdentifier(ItemNamesV2.ANCHOVY_PIZZA), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_15)))));
        MASHED_POTATOES = new SimpleItemWrapper(ItemNamesV2.MASHED_POTATOES, false, register.register(createIdentifier(ItemNamesV2.MASHED_POTATOES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_9)))));

        BAKED_CREPES = new SimpleItemWrapper(ItemNamesV2.BAKED_CREPES, false, register.register(createIdentifier(ItemNamesV2.BAKED_CREPES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_12)))));
        CINNAMON_ROLL = new SimpleItemWrapper(ItemNamesV2.CINNAMON_ROLL, true, register.register(createIdentifier(ItemNamesV2.CINNAMON_ROLL), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_8)))));
        CROQUE_MADAME = new SimpleItemWrapper(ItemNamesV2.CROQUE_MADAME, false, register.register(createIdentifier(ItemNamesV2.CROQUE_MADAME), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_14)))));
        CROQUE_MONSIEUR = new SimpleItemWrapper(ItemNamesV2.CROQUE_MONSIEUR, false, register.register(createIdentifier(ItemNamesV2.CROQUE_MONSIEUR), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_13)))));
        DAUPHINE_POTATOES = new SimpleItemWrapper(ItemNamesV2.DAUPHINE_POTATOES, false, register.register(createIdentifier(ItemNamesV2.DAUPHINE_POTATOES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_12)))));
        FRIED_FROG_LEGS = new SimpleItemWrapper(ItemNamesV2.FRIED_FROG_LEGS, false, register.register(createIdentifier(ItemNamesV2.FRIED_FROG_LEGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_6)))));
        FROG_LEGS = new SimpleItemWrapper(ItemNamesV2.FROG_LEGS, false, register.register(createIdentifier(ItemNamesV2.FROG_LEGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_3)))));
        GROUND_PORK = new SimpleItemWrapper(ItemNamesV2.GROUND_PORK, false, register.register(createIdentifier(ItemNamesV2.GROUND_PORK), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_1)))));
        HASHED_BROWN = new SimpleItemWrapper(ItemNamesV2.HASHED_BROWN, false, register.register(createIdentifier(ItemNamesV2.HASHED_BROWN), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_2)))));
        MACARON = new SimpleItemWrapper(ItemNamesV2.MACARON, false, register.register(createIdentifier(ItemNamesV2.MACARON), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        QUICHE = new SimpleItemWrapper(ItemNamesV2.QUICHE, false, register.register(createIdentifier(ItemNamesV2.QUICHE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_12)))));
        SAUSAGE = new SimpleItemWrapper(ItemNamesV2.SAUSAGE, true, register.register(createIdentifier(ItemNamesV2.SAUSAGE), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_3)))));
        SUNNY_SIDE_EGGS = new SimpleItemWrapper(ItemNamesV2.SUNNY_SIDE_EGGS, false, register.register(createIdentifier(ItemNamesV2.SUNNY_SIDE_EGGS), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_5)))));
        SWEET_CREPES = new SimpleItemWrapper(ItemNamesV2.SWEET_CREPES, false, register.register(createIdentifier(ItemNamesV2.SWEET_CREPES), () -> new Item(createGroup().food(FoodConstructor.createFood(REG_8)))));
        THE_BIG_BREAKFAST = new SimpleItemWrapper(ItemNamesV2.THE_BIG_BREAKFAST, false, register.register(createIdentifier(ItemNamesV2.THE_BIG_BREAKFAST), () -> new ReferenceItem(createGroup().food(FoodConstructor.createFood(REG_20)),
                Component.literal("Patricia! Daddy want the Big Breakfast").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)))));

        SALT_ORE = register.register(createIdentifier(ItemNamesV2.SALT_ORE), () ->  new ItemNameBlockItem(SALT_ORE_BLOCK, createGroup()));
    }

    public static Stream<Item> createCropStream() {
        return Stream.concat(
                Arrays.stream(FarmlandCrop.INSTANCES.toArray(new FarmlandCrop[0])),
                Stream.concat(Arrays.stream(TreeCrop.INSTANCES.toArray(new TreeCrop[0])), Arrays.stream(Tree.INSTANCES.toArray(Tree[]::new)))
        ).map(ItemLike::asItem);
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(ResourceLocation id, ConfiguredFeature<FC, F> feature) {
        return Holder.direct(feature);
    }
}
