package com.epherical.croptopia.datagen;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.common.ItemNamesV2;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.items.Drink;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Jam;
import com.epherical.croptopia.register.helpers.Seafood;
import com.epherical.croptopia.register.helpers.TreeCrop;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CroptopiaAdvancementProvider extends FabricAdvancementProvider {

    private static final String HAS = "has_";

    protected CroptopiaAdvancementProvider(final FabricDataOutput output, final CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(final HolderLookup.Provider registryLookup, final Consumer<AdvancementHolder> consumer) {
        final String hasSeedsStr = HAS + "seeds";
        final Criterion<?> hasSeeds = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TagKey.create(Registries.ITEM, CroptopiaMod.createIdentifier("seeds"))));
        final String hasSaplingsStr = HAS + "saplings";
        final Criterion<?> hasSaplings = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(TagKey.create(Registries.ITEM, CroptopiaMod.createIdentifier("saplings"))));
        final String hasSaltStr = HAS + ItemNamesV2.SALT;
        final Criterion<?> hasSalt = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.SALT));
        final String hasCinnamonStr = HAS + ItemNamesV2.CINNAMON;
        final Criterion<?> hasCinnamon = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.CINNAMON));
        final String hasMortarStr = HAS + ItemNamesV2.MORTAR_AND_PESTLE;
        final Criterion<?> hasMortar = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.MORTAR_AND_PESTLE));
        final String hasKnifeStr = HAS + ItemNamesV2.KNIFE;
        final Criterion<?> hasKnife = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.KNIFE));
        final String hasPotStr = HAS + ItemNamesV2.COOKING_POT;
        final Criterion<?> hasPot = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.COOKING_POT));
        final String hasFryingPanStr = HAS + ItemNamesV2.FRYING_PAN;
        final Criterion<?> hasFryingPan = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.FRYING_PAN));
        final String hasFoodPressStr = HAS + ItemNamesV2.FOOD_PRESS;
        final Criterion<?> hasFoodPress = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Content.FOOD_PRESS));
        final String hasHoeStr = HAS + "hoe";
        final Criterion<?> hasHoe = InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTags.HOES));

        // root advancement
        final String rootStr = "root";
        final AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        Content.COFFEE,
                        Component.literal("Croptopia"),
                        Component.translatable(desc(rootStr)),
                        CroptopiaMod.createIdentifier("textures/block/salt_ore.png"),
                        AdvancementType.TASK,
                        true, // show toast
                        false, // announce to chat
                        false) // hide
                .addCriterion(hasHoeStr, hasHoe)
                .addCriterion(hasSeedsStr, hasSeeds)
                .addCriterion(hasSaplingsStr, hasSaplings)
                .addCriterion(hasSaltStr, hasSalt)
                .addCriterion(hasCinnamonStr, hasCinnamon)
                .addCriterion(hasMortarStr, hasMortar)
                .addCriterion(hasKnifeStr, hasKnife)
                .addCriterion(hasPotStr, hasPot)
                .addCriterion(hasFryingPanStr, hasFryingPan)
                .addCriterion(hasFoodPressStr, hasFoodPress)
                .requirements(AdvancementRequirements.anyOf(List.of(hasHoeStr, hasSeedsStr, hasSaplingsStr, hasSaltStr, hasCinnamonStr, hasMortarStr, hasKnifeStr, hasPotStr, hasFryingPanStr, hasFoodPressStr)))
                .build(CroptopiaMod.createIdentifier(rootStr));
        consumer.accept(root);

        // salt advancement
        final AdvancementHolder salt = simpleAdvancement("salt", Content.SALT, hasSaltStr, hasSalt, root);
        consumer.accept(salt);

        // cinnamon advancement
        final AdvancementHolder cinnamon = simpleAdvancement("cinnamon", Content.CINNAMON, hasCinnamonStr, hasCinnamon, salt);
        consumer.accept(cinnamon);

        // mortar and pestle advancement
        final AdvancementHolder mortar = simpleAdvancement("mortar_and_pestle", Content.MORTAR_AND_PESTLE, hasMortarStr, hasMortar, root);
        consumer.accept(mortar);

        // knife advancement
        final AdvancementHolder knife = simpleAdvancement("knife", Content.KNIFE, hasKnifeStr, hasKnife, mortar);
        consumer.accept(knife);

        // pot advancement
        final AdvancementHolder pot = simpleAdvancement("pot", Content.COOKING_POT, hasPotStr, hasPot, knife);
        consumer.accept(pot);

        // frying pan advancement
        final AdvancementHolder fryingPan = simpleAdvancement("frying_pan", Content.FRYING_PAN, hasFryingPanStr, hasFryingPan, pot);
        consumer.accept(fryingPan);

        // food press advancement
        final AdvancementHolder foodPress = simpleAdvancement("food_press", Content.FOOD_PRESS, hasFoodPressStr, hasFoodPress, fryingPan);
        consumer.accept(foodPress);

        // getseed advancement
        final AdvancementHolder seedAny = simpleAdvancement("getseed", Content.BASIL.getSeedItem(), hasSeedsStr, hasSeeds, root);
        consumer.accept(seedAny);

        // get all farmland crops from Content automatically
        final List<FarmlandCrop> allCrops = Arrays.stream(Content.class.getDeclaredFields())
                .filter(field -> Modifier.isStatic(field.getModifiers()) && field.getType() == FarmlandCrop.class)
                .map(CroptopiaAdvancementProvider::farmlandCrop)
                .filter(Objects::nonNull)
                .toList();
        final Set<CroptopiaBiomeTagProvider.BiomeTagPair> biomeTagPairs = CroptopiaBiomeTagProvider.getBiomeTagPairs();
        // a bit of magic to group the right conditions together
        final Map<String, Criterion<?>> plainsMap = createTriggerMapForBiome(allCrops, biomeTagPairs, ConventionalBiomeTags.IS_PLAINS);
        final Map<String, Criterion<?>> desertMap = createTriggerMapForBiome(allCrops, biomeTagPairs, ConventionalBiomeTags.IS_DESERT);
        final Map<String, Criterion<?>> forestMap = createTriggerMapForBiome(allCrops, biomeTagPairs, ConventionalBiomeTags.IS_FOREST);
        final Map<String, Criterion<?>> savannaMap = createTriggerMapForBiome(allCrops, biomeTagPairs, ConventionalBiomeTags.IS_SAVANNA);
        final Map<String, Criterion<?>> jungleMap = createTriggerMapForBiome(allCrops, biomeTagPairs, ConventionalBiomeTags.IS_JUNGLE);
        final Map<String, Criterion<?>> swampMap = createTriggerMapForBiome(allCrops, biomeTagPairs, ConventionalBiomeTags.IS_SWAMP);

        // gather plains advancement
        final AdvancementHolder gatherPlains = collectorAdvancement("gather_plains", Content.BROCCOLI.getSeedItem(), plainsMap, seedAny);
        consumer.accept(gatherPlains);

        // gather desert advancement
        final AdvancementHolder gatherDesert = collectorAdvancement("gather_desert", Content.SAGUARO.getSeedItem(), desertMap, gatherPlains);
        consumer.accept(gatherDesert);

        // gather forest advancement
        final AdvancementHolder gatherForest = collectorAdvancement("gather_forest", Content.CELERY.getSeedItem(), forestMap, gatherDesert);
        consumer.accept(gatherForest);

        // gather savanna advancement
        final AdvancementHolder gatherSavanna = collectorAdvancement("gather_savanna", Content.YAM.getSeedItem(), savannaMap, gatherForest);
        consumer.accept(gatherSavanna);

        // gather jungle advancement
        final AdvancementHolder gatherJungle = collectorAdvancement("gather_jungle", Content.COFFEE_BEANS.getSeedItem(), jungleMap, gatherSavanna);
        consumer.accept(gatherJungle);

        // gather swamp advancement
        final AdvancementHolder gatherSwamp = collectorAdvancement("gather_swamp", Content.CRANBERRY.getSeedItem(), swampMap, gatherJungle);
        consumer.accept(gatherSwamp);

        // gather all advancement
        final String gatherAllStr = "gather_all";
        final Advancement.Builder gatherAllBuilder = Advancement.Builder.advancement()
                .parent(gatherSwamp)
                .display(
                        Content.TURNIP.getSeedItem(),
                        Component.translatable(title(gatherAllStr)),
                        Component.translatable(desc(gatherAllStr)),
                        null,
                        AdvancementType.GOAL,
                        true, // show toast
                        false, // announce to chat
                        false); // hide
        for (final FarmlandCrop crop : allCrops) {
            gatherAllBuilder.addCriterion(HAS + crop.name() + "_seed", InventoryChangeTrigger.TriggerInstance.hasItems(crop.getSeedItem()));
        }
        gatherAllBuilder.requirements(AdvancementRequirements.allOf(allCrops.stream().map(crop -> HAS + crop.name() + "_seed").toList()));
        final AdvancementHolder gatherAll = gatherAllBuilder.build(CroptopiaMod.createIdentifier(gatherAllStr));
        consumer.accept(gatherAll);

        // getsapling advancement
        final AdvancementHolder saplingAny = simpleAdvancement("getsapling", Content.MANGO.getSaplingItem(), hasSaplingsStr, hasSaplings, root);
        consumer.accept(saplingAny);

        // gather dark forest trees
        final Map<String, Criterion<?>> treeDarkForestMap = Map.ofEntries(
                Map.entry(HAS + "almond_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.ALMOND.getSaplingItem())),
                Map.entry(HAS + "cashew_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.CASHEW.getSaplingItem())),
                Map.entry(HAS + "pecan_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.PECAN.getSaplingItem())),
                Map.entry(HAS + "walnut_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.WALNUT.getSaplingItem()))
        );
        final AdvancementHolder gatherTreeDarkForest = collectorAdvancement("gather_tree_dark_forest", Content.CASHEW.getSaplingItem(), treeDarkForestMap, saplingAny);
        consumer.accept(gatherTreeDarkForest);

        // gather jungle trees
        final Map<String, Criterion<?>> treeJungleMap = Map.ofEntries(
                Map.entry(HAS + "date_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.DATE.getSaplingItem())),
                Map.entry(HAS + "dragonfruit_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.DRAGONFRUIT.getSaplingItem())),
                Map.entry(HAS + "mango_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.MANGO.getSaplingItem())),
                Map.entry(HAS + "nutmeg_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.NUTMEG.getSaplingItem())),
                Map.entry(HAS + "coconut_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.COCONUT.getSaplingItem())),
                Map.entry(HAS + "kumquat_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.KUMQUAT.getSaplingItem())),
                Map.entry(HAS + "fig_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.FIG.getSaplingItem())),
                Map.entry(HAS + "grapefruit_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.GRAPEFRUIT.getSaplingItem())),
                Map.entry(HAS + "banana_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.BANANA.getSaplingItem())),
                Map.entry(HAS + "cinnamon_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.CINNAMON.getSapling()))
        );
        final AdvancementHolder gatherTreeJungle = collectorAdvancement("gather_tree_jungle", Content.BANANA.getSaplingItem(), treeJungleMap, gatherTreeDarkForest);
        consumer.accept(gatherTreeJungle);

        // gather plains trees
        final Map<String, Criterion<?>> treePlainsMap = Map.ofEntries(
                Map.entry(HAS + "apple_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.APPLE.getSaplingItem())),
                Map.entry(HAS + "orange_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.ORANGE.getSaplingItem())),
                Map.entry(HAS + "peach_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.PEACH.getSaplingItem()))
        );
        final AdvancementHolder gatherTreePlains = collectorAdvancement("gather_tree_plains", Content.APPLE.getSaplingItem(), treePlainsMap, gatherTreeJungle);
        consumer.accept(gatherTreePlains);

        // gather forest trees
        final Map<String, Criterion<?>> treeForestMap = Map.ofEntries(
                Map.entry(HAS + "apricot_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.APRICOT.getSaplingItem())),
                Map.entry(HAS + "avocado_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.AVOCADO.getSaplingItem())),
                Map.entry(HAS + "cherry_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.CHERRY.getSaplingItem())),
                Map.entry(HAS + "lemon_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.LEMON.getSaplingItem())),
                Map.entry(HAS + "lime_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.LIME.getSaplingItem())),
                Map.entry(HAS + "nectarine_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.NECTARINE.getSaplingItem())),
                Map.entry(HAS + "orange_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.ORANGE.getSaplingItem())),
                Map.entry(HAS + "persimmon_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.PERSIMMON.getSaplingItem())),
                Map.entry(HAS + "plum_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.PLUM.getSaplingItem())),
                Map.entry(HAS + "pear_sapling", InventoryChangeTrigger.TriggerInstance.hasItems(Content.PEAR.getSaplingItem()))
        );
        final AdvancementHolder gatherTreeForest = collectorAdvancement("gather_tree_forest", Content.CHERRY.getSaplingItem(), treeForestMap, gatherTreePlains);
        consumer.accept(gatherTreeForest);

        // gather all trees advancement
        final Map<String, Criterion<?>> treeMap = new HashMap<>();
        treeMap.putAll(treeDarkForestMap);
        treeMap.putAll(treeJungleMap);
        treeMap.putAll(treePlainsMap);
        treeMap.putAll(treeForestMap);
        final String gatherTreeAllStr = "gather_tree_all";
        final Advancement.Builder gatherTreeAllBuilder = Advancement.Builder.advancement()
                .parent(gatherTreeForest)
                .display(
                        Content.COCONUT.getSaplingItem(),
                        Component.translatable(title(gatherTreeAllStr)),
                        Component.translatable(desc(gatherTreeAllStr)),
                        null,
                        AdvancementType.GOAL,
                        true, // show toast
                        false, // announce to chat
                        false); // hide
        treeMap.forEach(gatherTreeAllBuilder::addCriterion);
        gatherTreeAllBuilder.requirements(AdvancementRequirements.allOf(treeMap.keySet()));
        final AdvancementHolder gatherTreeAll = gatherTreeAllBuilder.build(CroptopiaMod.createIdentifier(gatherTreeAllStr));
        consumer.accept(gatherTreeAll);

        // collect all drinks
        final Map<String, Criterion<?>> drinkMap = Arrays.stream(Content.class.getDeclaredFields())
                .filter(field -> Modifier.isStatic(field.getModifiers()) && ItemLike.class.isAssignableFrom(field.getType()))
                .map(CroptopiaAdvancementProvider::itemLike)
                .filter(item -> item instanceof ItemConvertibleWithPlural && !(item instanceof Jam) && item.asItem() instanceof Drink)
                .map(ItemConvertibleWithPlural.class::cast)
                .collect(Collectors.toMap(item -> "consumes_" + item.name(), ConsumeItemTrigger.TriggerInstance::usedItem));

        // getdrinks advancement
        final String drinkAnyStr = "getdrinks";
        final Advancement.Builder drinkAnyBuilder = Advancement.Builder.advancement()
                .parent(saplingAny)
                .display(
                        Content.APPLE_JUICE,
                        Component.translatable(title(drinkAnyStr)),
                        Component.translatable(desc(drinkAnyStr)),
                        null,
                        AdvancementType.TASK,
                        true, // show toast
                        false, // announce to chat
                        false); // hide
        drinkMap.forEach(drinkAnyBuilder::addCriterion);
        drinkAnyBuilder.requirements(AdvancementRequirements.anyOf(drinkMap.keySet()));
        final AdvancementHolder drinkAny =  drinkAnyBuilder.build(CroptopiaMod.createIdentifier(drinkAnyStr));
        consumer.accept(drinkAny);

        // gather drinks advancement
        final AdvancementHolder drinkAll = collectorAdvancement("gather_drinks", Content.BEER, drinkMap, drinkAny);
        consumer.accept(drinkAll);

        // collect all crafted foods
        final List<ItemConvertibleWithPlural> allFoodList = Arrays.stream(Content.class.getDeclaredFields())
                .filter(field -> Modifier.isStatic(field.getModifiers()) && ItemLike.class.isAssignableFrom(field.getType()))
                .map(CroptopiaAdvancementProvider::itemLike)
                .filter(item ->
                        item instanceof ItemConvertibleWithPlural &&
                                item.asItem().components().has(DataComponents.FOOD) &&
                                ((item instanceof Jam) || (!(item.asItem() instanceof Drink)))
                )
                .map(ItemConvertibleWithPlural.class::cast)
                .toList();
        final Map<String, Criterion<?>> craftedFoodMap = allFoodList.stream()
                .filter(item -> !(item instanceof FarmlandCrop) && !(item instanceof TreeCrop) && !(item instanceof Seafood) && item != Content.SEA_LETTUCE)
                .collect(Collectors.toMap(item -> "consumes_" + item.name(), ConsumeItemTrigger.TriggerInstance::usedItem));

        // eatcrafted advancement
        final String eatCraftedStr = "eatcrafted";
        final Advancement.Builder eatCraftedBuilder = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        Content.TOFUBURGER,
                        Component.translatable(title(eatCraftedStr)),
                        Component.translatable(desc(eatCraftedStr)),
                        null,
                        AdvancementType.TASK,
                        true, // show toast
                        false, // announce to chat
                        false); // hide
        craftedFoodMap.forEach(eatCraftedBuilder::addCriterion);
        eatCraftedBuilder.requirements(AdvancementRequirements.anyOf(craftedFoodMap.keySet()));
        final AdvancementHolder eatCrafted =  eatCraftedBuilder.build(CroptopiaMod.createIdentifier(eatCraftedStr));
        consumer.accept(eatCrafted);

        // collect all big foods
        final List<String> bigFoodList = List.of(
                ItemNamesV2.SALSA,
                ItemNamesV2.ONION_RINGS,
                ItemNamesV2.CAESAR_SALAD,
                ItemNamesV2.FRUIT_SALAD,
                ItemNamesV2.TRAIL_MIX,
                ItemNamesV2.PROTEIN_BAR,
                ItemNamesV2.NOUGAT,
                ItemNamesV2.TOFUBURGER,
                ItemNamesV2.SUPREME_PIZZA,
                ItemNamesV2.CHEESE_PIZZA,
                ItemNamesV2.PINEAPPLE_PEPPERONI_PIZZA,
                ItemNamesV2.LEMON_CHICKEN,
                ItemNamesV2.FRIED_CHICKEN,
                ItemNamesV2.CHICKEN_AND_NOODLES,
                ItemNamesV2.TACO,
                ItemNamesV2.CASHEW_CHICKEN,
                ItemNamesV2.APPLE_PIE,
                ItemNamesV2.BANANA_CREAM_PIE,
                ItemNamesV2.VANILLA_ICE_CREAM,
                ItemNamesV2.MANGO_ICE_CREAM,
                ItemNamesV2.RUM_RAISIN_ICE_CREAM,
                ItemNamesV2.PECAN_ICE_CREAM,
                ItemNamesV2.CHERRY_PIE,
                ItemNamesV2.CHEESE_CAKE,
                ItemNamesV2.BROWNIES,
                ItemNamesV2.BANANA_NUT_BREAD,
                ItemNamesV2.PECAN_PIE,
                ItemNamesV2.TOSTADA,
                ItemNamesV2.CARNITAS,
                ItemNamesV2.FAJITAS,
                ItemNamesV2.TAMALES,
                ItemNamesV2.TRES_LECHE_CAKE,
                ItemNamesV2.STUFFED_POBLANOS,
                ItemNamesV2.CHILI_RELLENO,
                ItemNamesV2.REFRIED_BEANS,
                ItemNamesV2.QUESADILLA,
                ItemNamesV2.SHEPHERDS_PIE,
                ItemNamesV2.BEEF_WELLINGTON,
                ItemNamesV2.FISH_AND_CHIPS,
                ItemNamesV2.ETON_MESS,
                ItemNamesV2.CORNISH_PASTY,
                ItemNamesV2.SCONES,
                ItemNamesV2.FIGGY_PUDDING,
                ItemNamesV2.TREACLE_TART,
                ItemNamesV2.STICKY_TOFFEE_PUDDING,
                ItemNamesV2.TRIFLE,
                ItemNamesV2.AJVAR,
                ItemNamesV2.AJVAR_TOAST,
                ItemNamesV2.BEEF_STEW,
                ItemNamesV2.BEEF_STIR_FRY,
                ItemNamesV2.BUTTERED_GREEN_BEANS,
                ItemNamesV2.CHOCOLATE_ICE_CREAM,
                ItemNamesV2.EGGPLANT_PARMESAN,
                ItemNamesV2.FRUIT_CAKE,
                ItemNamesV2.GRILLED_EGGPLANT,
                ItemNamesV2.LEMON_COCONUT_BAR,
                ItemNamesV2.NETHER_WART_STEW,
                ItemNamesV2.PEANUT_BUTTER,
                ItemNamesV2.PEANUT_BUTTER_W_CELERY,
                ItemNamesV2.POTATO_SOUP,
                ItemNamesV2.RATATOUILLE,
                ItemNamesV2.ROASTED_ASPARAGUS,
                ItemNamesV2.ROASTED_SQUASH,
                ItemNamesV2.ROASTED_TURNIPS,
                ItemNamesV2.STEAMED_BROCCOLI,
                ItemNamesV2.STIR_FRY,
                ItemNamesV2.STUFFED_ARTICHOKE,
                ItemNamesV2.TOAST_SANDWICH,
                ItemNamesV2.PUMPKIN_BARS,
                ItemNamesV2.PUMPKIN_SOUP,
                ItemNamesV2.CABBAGE_ROLL,
                ItemNamesV2.BORSCHT,
                ItemNamesV2.GOULASH,
                ItemNamesV2.CANDIED_KUMQUATS,
                ItemNamesV2.DEEP_FRIED_SHRIMP,
                ItemNamesV2.CRAB_LEGS,
                ItemNamesV2.STEAMED_CLAMS,
                ItemNamesV2.GRILLED_OYSTERS,
                ItemNamesV2.ANCHOVY_PIZZA
        );
        final Map<String, Criterion<?>> eatBigMap = allFoodList.stream()
                .filter(item -> bigFoodList.contains(item.name()))
                .collect(Collectors.toMap(item -> "consumes_" + item.name(), ConsumeItemTrigger.TriggerInstance::usedItem));

        // eatbig advancement
        final String eatBigStr = "eatbig";
        final Advancement.Builder eatBigBuilder = Advancement.Builder.advancement()
                .parent(eatCrafted)
                .display(
                        Content.TOFUBURGER,
                        Component.translatable(title(eatBigStr)),
                        Component.translatable(desc(eatBigStr)),
                        null,
                        AdvancementType.GOAL,
                        true, // show toast
                        false, // announce to chat
                        false); // hide
        eatBigMap.forEach(eatBigBuilder::addCriterion);
        eatBigBuilder.requirements(AdvancementRequirements.anyOf(eatBigMap.keySet()));
        final AdvancementHolder eatBig =  eatBigBuilder.build(CroptopiaMod.createIdentifier(eatBigStr));
        consumer.accept(eatBig);

        // gather food advancement
        final Map<String, Criterion<?>> gatherFoodMap = allFoodList.stream()
                .collect(Collectors.toMap(item -> "consumes_" + item.name(), ConsumeItemTrigger.TriggerInstance::usedItem));
        final String gatherFoodStr = "gather_food";
        final Advancement.Builder gatherFoodBuilder = Advancement.Builder.advancement()
                .parent(eatBig)
                .display(
                        Content.SUPREME_PIZZA,
                        Component.translatable(title(gatherFoodStr)),
                        Component.translatable(desc(gatherFoodStr)),
                        null,
                        AdvancementType.CHALLENGE,
                        true, // show toast
                        false, // announce to chat
                        false)
                .rewards(AdvancementRewards.Builder.experience(500)); // hide
        gatherFoodMap.forEach(gatherFoodBuilder::addCriterion);
        gatherFoodBuilder.requirements(AdvancementRequirements.allOf(gatherFoodMap.keySet()));
        final AdvancementHolder gatherFood = gatherFoodBuilder.build(CroptopiaMod.createIdentifier(gatherFoodStr));
        consumer.accept(gatherFood);
    }

    private static AdvancementHolder simpleAdvancement(final String advName, final ItemLike display, final String hasName, final Criterion<?> criterion, final AdvancementHolder parent) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(
                        display,
                        Component.translatable(title(advName)),
                        Component.translatable(desc(advName)),
                        null,
                        AdvancementType.TASK,
                        true, // show toast
                        false, // announce to chat
                        false) // hide
                .addCriterion(hasName, criterion)
                .requirements(AdvancementRequirements.anyOf(List.of(hasName)))
                .build(CroptopiaMod.createIdentifier(advName));
    }

    private static AdvancementHolder collectorAdvancement(final String advName, final ItemLike display, final Map<String, Criterion<?>> criteria, final AdvancementHolder parent) {
        final Advancement.Builder builder = Advancement.Builder.advancement()
                .parent(parent)
                .display(
                        display,
                        Component.translatable(title(advName)),
                        Component.translatable(desc(advName)),
                        null,
                        AdvancementType.TASK,
                        true, // show toast
                        false, // announce to chat
                        false); // hide
        criteria.forEach(builder::addCriterion);
        builder.requirements(AdvancementRequirements.allOf(criteria.keySet()));
        return builder.build(CroptopiaMod.createIdentifier(advName));
    }

    private static String title(final String name) {
        return String.format("advancements.%s.%s.title", MiscNames.MOD_ID, name);
    }

    private static String desc(final String name) {
        return String.format("advancements.%s.%s.description", MiscNames.MOD_ID, name);
    }

    private Map<String, Criterion<?>> createTriggerMapForBiome(Collection<FarmlandCrop> allCrops, Collection<CroptopiaBiomeTagProvider.BiomeTagPair> biomeTagPairs, TagKey<Biome> target) {
        return allCrops.stream()
                .filter(crop -> categoriesOf(crop.biomes(), biomeTagPairs).contains(target))
                .collect(Collectors.toMap(
                        crop -> HAS + crop.name() + "_seed",
                        crop -> InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(crop.getSeedItem()))
                ));
    }

    // see which categories were originally associated with a crop's biome
    private List<TagKey<Biome>> categoriesOf(TagKey<Biome> source, Collection<CroptopiaBiomeTagProvider.BiomeTagPair> searchPile) {
        // maybe a foreach loop is faster here, but it is datagen, so who cares?
        Optional<CroptopiaBiomeTagProvider.BiomeTagPair> result = searchPile.stream()
                .filter(pair -> pair.biome() == source)
                .findFirst();
        return result.map(biomeTagPair -> Arrays.asList(biomeTagPair.categories())).orElseGet(List::of);
    }

    // simple cast that takes care of the exception
    private static FarmlandCrop farmlandCrop(final Field field) {
        try {
            return (FarmlandCrop)field.get(null);
        }
        catch (IllegalAccessException ex) {
            return null;
        }
    }

    // simple cast that takes care of the exception
    private static ItemLike itemLike(final Field field) {
        try {
            return (ItemLike)field.get(null);
        }
        catch (IllegalAccessException ex) {
            return null;
        }
    }
}
