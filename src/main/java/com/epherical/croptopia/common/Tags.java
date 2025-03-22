package com.epherical.croptopia.common;

import com.epherical.croptopia.CroptopiaMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tags {

    private static final List<TagKey<Item>> CROPTOPIA_GROUP_TAGS = new ArrayList<>();
    private static final List<TagKey<Item>> CROPTOPIA_CROP_TAGS = new ArrayList<>();
    private static final List<TagKey<Biome>> CROPTOPIA_BIOME_TAGS = new ArrayList<>();

    public static final TagKey<Item> CROPS = createGroupTag(MiscNames.CROPS);
    public static final TagKey<Item> FRUITS = createGroupTag(MiscNames.FRUITS);
    public static final TagKey<Item> GRAIN = createGroupTag(MiscNames.GRAIN);
    public static final TagKey<Item> NUTS = createGroupTag(MiscNames.NUTS);
    public static final TagKey<Item> VEGETABLES = createGroupTag(MiscNames.VEGETABLES);
    public static final TagKey<Item> JAMS = createGroupTag(MiscNames.JAMS);
    public static final TagKey<Item> JUICES = createGroupTag(MiscNames.JUICES);

    private static final String HAS_CROP = "has_crop/";
    public static final TagKey<Biome> HAS_ARTICHOKE = createBiomeTag(HAS_CROP + ItemNamesV2.ARTICHOKE);
    public static final TagKey<Biome> HAS_ASPARAGUS = createBiomeTag(HAS_CROP + ItemNamesV2.ASPARAGUS);
    public static final TagKey<Biome> HAS_BARLEY = createBiomeTag(HAS_CROP + ItemNamesV2.BARLEY);
    public static final TagKey<Biome> HAS_BASIL = createBiomeTag(HAS_CROP + ItemNamesV2.BASIL);
    public static final TagKey<Biome> HAS_BELLPEPPER = createBiomeTag(HAS_CROP + ItemNamesV2.BELLPEPPER);
    public static final TagKey<Biome> HAS_BLACKBEAN = createBiomeTag(HAS_CROP + ItemNamesV2.BLACKBEAN);
    public static final TagKey<Biome> HAS_BLACKBERRY = createBiomeTag(HAS_CROP + ItemNamesV2.BLACKBERRY);
    public static final TagKey<Biome> HAS_BLUEBERRY = createBiomeTag(HAS_CROP + ItemNamesV2.BLUEBERRY);
    public static final TagKey<Biome> HAS_BROCCOLI = createBiomeTag(HAS_CROP + ItemNamesV2.BROCCOLI);
    public static final TagKey<Biome> HAS_CABBAGE = createBiomeTag(HAS_CROP + ItemNamesV2.CABBAGE);
    public static final TagKey<Biome> HAS_CANTALOUPE = createBiomeTag(HAS_CROP + ItemNamesV2.CANTALOUPE);
    public static final TagKey<Biome> HAS_CAULIFLOWER = createBiomeTag(HAS_CROP + ItemNamesV2.CAULIFLOWER);
    public static final TagKey<Biome> HAS_CELERY = createBiomeTag(HAS_CROP + ItemNamesV2.CELERY);
    public static final TagKey<Biome> HAS_CHILE_PEPPER = createBiomeTag(HAS_CROP + ItemNamesV2.CHILE_PEPPER);
    public static final TagKey<Biome> HAS_COFFEE_BEANS = createBiomeTag(HAS_CROP + ItemNamesV2.COFFEE_BEANS);
    public static final TagKey<Biome> HAS_CORN = createBiomeTag(HAS_CROP + ItemNamesV2.CORN);
    public static final TagKey<Biome> HAS_CRANBERRY = createBiomeTag(HAS_CROP + ItemNamesV2.CRANBERRY);
    public static final TagKey<Biome> HAS_CUCUMBER = createBiomeTag(HAS_CROP + ItemNamesV2.CUCUMBER);
    public static final TagKey<Biome> HAS_CURRANT = createBiomeTag(HAS_CROP + ItemNamesV2.CURRANT);
    public static final TagKey<Biome> HAS_EGGPLANT = createBiomeTag(HAS_CROP + ItemNamesV2.EGGPLANT);
    public static final TagKey<Biome> HAS_ELDERBERRY = createBiomeTag(HAS_CROP + ItemNamesV2.ELDERBERRY);
    public static final TagKey<Biome> HAS_GARLIC = createBiomeTag(HAS_CROP + ItemNamesV2.GARLIC);
    public static final TagKey<Biome> HAS_GINGER = createBiomeTag(HAS_CROP + ItemNamesV2.GINGER);
    public static final TagKey<Biome> HAS_GRAPE = createBiomeTag(HAS_CROP + ItemNamesV2.GRAPE);
    public static final TagKey<Biome> HAS_GREENBEAN = createBiomeTag(HAS_CROP + ItemNamesV2.GREENBEAN);
    public static final TagKey<Biome> HAS_GREENONION = createBiomeTag(HAS_CROP + ItemNamesV2.GREENONION);
    public static final TagKey<Biome> HAS_HONEYDEW = createBiomeTag(HAS_CROP + ItemNamesV2.HONEYDEW);
    public static final TagKey<Biome> HAS_HOPS = createBiomeTag(HAS_CROP + ItemNamesV2.HOPS);
    public static final TagKey<Biome> HAS_KALE = createBiomeTag(HAS_CROP + ItemNamesV2.KALE);
    public static final TagKey<Biome> HAS_KIWI = createBiomeTag(HAS_CROP + ItemNamesV2.KIWI);
    public static final TagKey<Biome> HAS_LEEK = createBiomeTag(HAS_CROP + ItemNamesV2.LEEK);
    public static final TagKey<Biome> HAS_LETTUCE = createBiomeTag(HAS_CROP + ItemNamesV2.LETTUCE);
    public static final TagKey<Biome> HAS_MUSTARD = createBiomeTag(HAS_CROP + ItemNamesV2.MUSTARD);
    public static final TagKey<Biome> HAS_OAT = createBiomeTag(HAS_CROP + ItemNamesV2.OAT);
    public static final TagKey<Biome> HAS_OLIVE = createBiomeTag(HAS_CROP + ItemNamesV2.OLIVE);
    public static final TagKey<Biome> HAS_ONION = createBiomeTag(HAS_CROP + ItemNamesV2.ONION);
    public static final TagKey<Biome> HAS_PEANUT = createBiomeTag(HAS_CROP + ItemNamesV2.PEANUT);
    public static final TagKey<Biome> HAS_PEPPER = createBiomeTag(HAS_CROP + ItemNamesV2.PEPPER);
    public static final TagKey<Biome> HAS_PINEAPPLE = createBiomeTag(HAS_CROP + ItemNamesV2.PINEAPPLE);
    public static final TagKey<Biome> HAS_RADISH = createBiomeTag(HAS_CROP + ItemNamesV2.RADISH);
    public static final TagKey<Biome> HAS_RASPBERRY = createBiomeTag(HAS_CROP + ItemNamesV2.RASPBERRY);
    public static final TagKey<Biome> HAS_RHUBARB = createBiomeTag(HAS_CROP + ItemNamesV2.RHUBARB);
    public static final TagKey<Biome> HAS_RICE = createBiomeTag(HAS_CROP + ItemNamesV2.RICE);
    public static final TagKey<Biome> HAS_RUTABAGA = createBiomeTag(HAS_CROP + ItemNamesV2.RUTABAGA);
    public static final TagKey<Biome> HAS_SAGUARO = createBiomeTag(HAS_CROP + ItemNamesV2.SAGUARO);
    public static final TagKey<Biome> HAS_SOYBEAN = createBiomeTag(HAS_CROP + ItemNamesV2.SOYBEAN);
    public static final TagKey<Biome> HAS_SPINACH = createBiomeTag(HAS_CROP + ItemNamesV2.SPINACH);
    public static final TagKey<Biome> HAS_SQUASH = createBiomeTag(HAS_CROP + ItemNamesV2.SQUASH);
    public static final TagKey<Biome> HAS_STRAWBERRY = createBiomeTag(HAS_CROP + ItemNamesV2.STRAWBERRY);
    public static final TagKey<Biome> HAS_SWEETPOTATO = createBiomeTag(HAS_CROP + ItemNamesV2.SWEETPOTATO);
    public static final TagKey<Biome> HAS_TEA_LEAVES = createBiomeTag(HAS_CROP + ItemNamesV2.TEA_LEAVES);
    public static final TagKey<Biome> HAS_TOMATILLO = createBiomeTag(HAS_CROP + ItemNamesV2.TOMATILLO);
    public static final TagKey<Biome> HAS_TOMATO = createBiomeTag(HAS_CROP + ItemNamesV2.TOMATO);
    public static final TagKey<Biome> HAS_TURMERIC = createBiomeTag(HAS_CROP + ItemNamesV2.TURMERIC);
    public static final TagKey<Biome> HAS_TURNIP = createBiomeTag(HAS_CROP + ItemNamesV2.TURNIP);
    public static final TagKey<Biome> HAS_VANILLA = createBiomeTag(HAS_CROP + ItemNamesV2.VANILLA);
    public static final TagKey<Biome> HAS_YAM = createBiomeTag(HAS_CROP + ItemNamesV2.YAM);
    public static final TagKey<Biome> HAS_ZUCCHINI = createBiomeTag(HAS_CROP + ItemNamesV2.ZUCCHINI);

    private static TagKey<Item> createGroupTag(final String key) {
        return create(key, Registries.ITEM, CROPTOPIA_GROUP_TAGS, true);
    }
    private static TagKey<Item> createCropTag(final String key) {
        return create(key, Registries.ITEM, CROPTOPIA_CROP_TAGS, true);
    }

    private static TagKey<Biome> createBiomeTag(final String key) {
        return create(key, Registries.BIOME, CROPTOPIA_BIOME_TAGS, false);
    }
    
    private static <T> TagKey<T> create(final String key, final ResourceKey<Registry<T>> registry, final Collection<TagKey<T>> collection, final boolean common) {
        final TagKey<T> tagKey = TagKey.create(registry, common ? CroptopiaMod.createCommonIdentifier(key) : CroptopiaMod.createIdentifier(key));
        collection.add(tagKey);
        return tagKey;
    }
}
