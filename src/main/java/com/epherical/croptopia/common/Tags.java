package com.epherical.croptopia.common;

import com.epherical.croptopia.CroptopiaMod;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import static com.epherical.croptopia.common.ItemNamesV2.*;

import java.util.ArrayList;
import java.util.List;

public class Tags {

    private static final List<TagKey<Biome>> CROPTOPIA_BIOME_TAGS = new ArrayList<>();

    private static final String HAS_CROP = "has_crop/";
    public static final TagKey<Biome> HAS_ARTICHOKE = create(HAS_CROP + ARTICHOKE);
    public static final TagKey<Biome> HAS_ASPARAGUS = create(HAS_CROP + ASPARAGUS);
    public static final TagKey<Biome> HAS_BARLEY = create(HAS_CROP + BARLEY);
    public static final TagKey<Biome> HAS_BASIL = create(HAS_CROP + BASIL);
    public static final TagKey<Biome> HAS_BELLPEPPER = create(HAS_CROP + BELLPEPPER);
    public static final TagKey<Biome> HAS_BLACKBEAN = create(HAS_CROP + BLACKBEAN);
    public static final TagKey<Biome> HAS_BLACKBERRY = create(HAS_CROP + BLACKBERRY);
    public static final TagKey<Biome> HAS_BLUEBERRY = create(HAS_CROP + BLUEBERRY);
    public static final TagKey<Biome> HAS_BROCCOLI = create(HAS_CROP + BROCCOLI);
    public static final TagKey<Biome> HAS_CABBAGE = create(HAS_CROP + CABBAGE);
    public static final TagKey<Biome> HAS_CANTALOUPE = create(HAS_CROP + CANTALOUPE);
    public static final TagKey<Biome> HAS_CAULIFLOWER = create(HAS_CROP + CAULIFLOWER);
    public static final TagKey<Biome> HAS_CELERY = create(HAS_CROP + CELERY);
    public static final TagKey<Biome> HAS_CHILE_PEPPER = create(HAS_CROP + CHILE_PEPPER);
    public static final TagKey<Biome> HAS_COFFEE_BEANS = create(HAS_CROP + COFFEE_BEANS);
    public static final TagKey<Biome> HAS_CORN = create(HAS_CROP + CORN);
    public static final TagKey<Biome> HAS_CRANBERRY = create(HAS_CROP + CRANBERRY);
    public static final TagKey<Biome> HAS_CUCUMBER = create(HAS_CROP + CUCUMBER);
    public static final TagKey<Biome> HAS_CURRANT = create(HAS_CROP + CURRANT);
    public static final TagKey<Biome> HAS_EGGPLANT = create(HAS_CROP + EGGPLANT);
    public static final TagKey<Biome> HAS_ELDERBERRY = create(HAS_CROP + ELDERBERRY);
    public static final TagKey<Biome> HAS_GARLIC = create(HAS_CROP + GARLIC);
    public static final TagKey<Biome> HAS_GINGER = create(HAS_CROP + GINGER);
    public static final TagKey<Biome> HAS_GRAPE = create(HAS_CROP + GRAPE);
    public static final TagKey<Biome> HAS_GREENBEAN = create(HAS_CROP + GREENBEAN);
    public static final TagKey<Biome> HAS_GREENONION = create(HAS_CROP + GREENONION);
    public static final TagKey<Biome> HAS_HONEYDEW = create(HAS_CROP + HONEYDEW);
    public static final TagKey<Biome> HAS_HOPS = create(HAS_CROP + HOPS);
    public static final TagKey<Biome> HAS_KALE = create(HAS_CROP + KALE);
    public static final TagKey<Biome> HAS_KIWI = create(HAS_CROP + KIWI);
    public static final TagKey<Biome> HAS_LEEK = create(HAS_CROP + LEEK);
    public static final TagKey<Biome> HAS_LETTUCE = create(HAS_CROP + LETTUCE);
    public static final TagKey<Biome> HAS_MUSTARD = create(HAS_CROP + MUSTARD);
    public static final TagKey<Biome> HAS_OAT = create(HAS_CROP + OAT);
    public static final TagKey<Biome> HAS_OLIVE = create(HAS_CROP + OLIVE);
    public static final TagKey<Biome> HAS_ONION = create(HAS_CROP + ONION);
    public static final TagKey<Biome> HAS_PEANUT = create(HAS_CROP + PEANUT);
    public static final TagKey<Biome> HAS_PEPPER = create(HAS_CROP + PEPPER);
    public static final TagKey<Biome> HAS_PINEAPPLE = create(HAS_CROP + PINEAPPLE);
    public static final TagKey<Biome> HAS_RADISH = create(HAS_CROP + RADISH);
    public static final TagKey<Biome> HAS_RASPBERRY = create(HAS_CROP + RASPBERRY);
    public static final TagKey<Biome> HAS_RHUBARB = create(HAS_CROP + RHUBARB);
    public static final TagKey<Biome> HAS_RICE = create(HAS_CROP + RICE);
    public static final TagKey<Biome> HAS_RUTABAGA = create(HAS_CROP + RUTABAGA);
    public static final TagKey<Biome> HAS_SAGUARO = create(HAS_CROP + SAGUARO);
    public static final TagKey<Biome> HAS_SOYBEAN = create(HAS_CROP + SOYBEAN);
    public static final TagKey<Biome> HAS_SPINACH = create(HAS_CROP + SPINACH);
    public static final TagKey<Biome> HAS_SQUASH = create(HAS_CROP + SQUASH);
    public static final TagKey<Biome> HAS_STRAWBERRY = create(HAS_CROP + STRAWBERRY);
    public static final TagKey<Biome> HAS_SWEETPOTATO = create(HAS_CROP + SWEETPOTATO);
    public static final TagKey<Biome> HAS_TEA_LEAVES = create(HAS_CROP + TEA_LEAVES);
    public static final TagKey<Biome> HAS_TOMATILLO = create(HAS_CROP + TOMATILLO);
    public static final TagKey<Biome> HAS_TOMATO = create(HAS_CROP + TOMATO);
    public static final TagKey<Biome> HAS_TURMERIC = create(HAS_CROP + TURMERIC);
    public static final TagKey<Biome> HAS_TURNIP = create(HAS_CROP + TURNIP);
    public static final TagKey<Biome> HAS_VANILLA = create(HAS_CROP + VANILLA);
    public static final TagKey<Biome> HAS_YAM = create(HAS_CROP + YAM);
    public static final TagKey<Biome> HAS_ZUCCHINI = create(HAS_CROP + ZUCCHINI);

    private static TagKey<Biome> create(String key) {
        TagKey<Biome> biomeKey = TagKey.create(Registries.BIOME, CroptopiaMod.createIdentifier(key));
        CROPTOPIA_BIOME_TAGS.add(biomeKey);
        return biomeKey;
    }

    public static List<TagKey<Biome>> getCroptopiaBiomeTags() {
        return ImmutableList.copyOf(CROPTOPIA_BIOME_TAGS);
    }
}
