package com.epherical.croptopia.datagen;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.common.Tags;
import com.epherical.croptopia.mixin.datagen.ObjectBuilderAccessor;
import com.epherical.croptopia.mixin.datagen.TagProviderAccessor;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.CroptopiaItem;
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
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.impl.datagen.ForcedTagEntry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class CroptopiaIndependentItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public CroptopiaIndependentItemTagProvider(final FabricDataOutput output, final CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, null);
        ((TagProviderAccessor) this).setPathProvider(
                new DependentPathProvider(output,
                        PackOutput.Target.DATA_PACK,
                        Registries.tagsDirPath(Registries.ITEM)));
    }

    @Override
    public String getName() {
        return "Croptopia Independent Tags";
    }

    @Override
    protected void addTags(final HolderLookup.Provider arg) {
        generateCrops();
        generateSeedsSaplings();
        generateOtherEnums();
        generateMisc();
    }

    protected void generateCrops() {
        for (final FarmlandCrop crop : FarmlandCrop.INSTANCES) {
            createSelfTag(crop);
            createCategoryTag(crop.getTagCategory(), crop);
            if (crop.getTagCategory() != Tags.CROPS) { // don't double only-crops
                createCategoryTag(Tags.CROPS, crop);
            }
        }
        for (final TreeCrop crop : TreeCrop.INSTANCES) {
            createSelfTag(crop);
            createCategoryTag(crop.getTagCategory(), crop);
            if (crop.getTagCategory() != Tags.CROPS) { // don't double only-crops
                createCategoryTag(Tags.CROPS, crop);
            }
            if (crop.getTagCategory() == Tags.NUTS) { // nuts are fruits
                createCategoryTag(Tags.FRUITS, crop);
            }
        }
        for (final Tree crop : Tree.INSTANCES) {
            createSelfTag(crop);
            createCategoryTag(crop.getTagCategory(), crop);
            if (crop.getTagCategory() != Tags.CROPS) { // don't double only-crops
                createCategoryTag(Tags.CROPS, crop);
            }
        }
        // the following four are all done above with a category tag of crops I believe
        /*createGeneralTag("saguaros", Content.saguaro);
        createGeneralTag("turmeric", Content.turmeric);
        createGeneralTag("tea_leaves", Content.teaLeaves);
        createGeneralTag("cinnamon", Content.cinnamon);*/
    }

    protected void generateSeedsSaplings() {
        // these should be singular, they are pluralized in the method, this is because forge seed tags don't include the "seed" portion.
        for (final FarmlandCrop crop : FarmlandCrop.INSTANCES) {
            if (crop == Content.CHILE_PEPPER) {
                createSeedSaplingTag("seeds", "chilepepper", crop.getSeedItem());
            } else {
                createSeedSaplingTag("seeds", crop.getLowercaseName(), crop.getSeedItem());
            }
        }
        for (final TreeCrop crop : TreeCrop.INSTANCES) {
            createSeedSaplingTag("saplings", crop.getLowercaseName(), crop.getSaplingItem());
        }
        for (final Tree crop : Tree.INSTANCES) {
            createSeedSaplingTag("saplings", crop.getLowercaseName(), crop.getSapling());
        }
    }

    protected void generateOtherEnums() {
        for (Seafood seafood : Seafood.INSTANCES) {
            createSelfTag(seafood);
        }
        for (Furnace furnace : Furnace.INSTANCES) {
            createSelfTag(furnace);
        }
        for (Juice juice : Juice.INSTANCES) {
            createSelfTag(juice);
            createCategoryTag(Tags.JUICES, juice);
        }
        for (Jam jam : Jam.INSTANCES) {
            createSelfTag(jam);
            createCategoryTag(Tags.JAMS, jam);
        }
        for (Smoothie smoothie : Smoothie.INSTANCES) {
            createSelfTag(smoothie);
        }
        for (IceCream iceCream : IceCream.INSTANCES) {
            createSelfTag(iceCream);
        }
        for (Pie pie : Pie.INSTANCES) {
            createSelfTag(pie);
        }
        for (Utensil utensil : Utensil.INSTANCES) {
            createSelfTag(utensil);
        }
        for (SimpleItemWrapper wrapper : SimpleItemWrapper.INSTANCES) {
            createSelfTag(wrapper);
        }
    }

    protected void generateMisc() {
        getOrCreateTagBuilder(register("salt_ores")).add(Content.SALT_ORE);
        this.tag(register("water_bottles")).add(reverseLookup(Content.WATER_BOTTLE.asItem())).add(reverseLookup(Items.WATER_BUCKET)).addOptional(ResourceLocation.parse("early_buckets:wooden_water_bucket"));
        this.tag(register("milks")).add(reverseLookup(Content.MILK_BOTTLE.asItem())).add(reverseLookup(Content.SOY_MILK.asItem())).add(reverseLookup(Items.MILK_BUCKET)).addOptionalTag(independentTag("milk_buckets"));
        this.tag(register("potatoes")).add(reverseLookup(Items.POTATO)).add(reverseLookup(Content.SWEETPOTATO.asItem()));
    }

    private static TagKey<Item> register(String id) {
        return TagKey.create(Registries.ITEM, CroptopiaMod.createIdentifier(id));
    }

    private void createSelfTag(final CroptopiaItem item) {
        tag(item.asTag()).add(reverseLookup(item.asItem()));
    }

    private void createCategoryTag(final TagKey<Item> category, final CroptopiaItem item) {
        final ResourceKey<Item> key = reverseLookup(item.asItem());
        final String path = key.location().getPath();
        final String categoryPath = category.location().getPath();

        final TagKey<Item> categoryTag = TagKey.create(Registries.ITEM, CroptopiaMod.createCommonIdentifier(categoryPath + "/" + path));
        tag(category).addTag(item.asTag());
        tag(categoryTag).add(key);
        tag(item.asTag()).addTag(categoryTag);
    }

    /**
     * Special method for forge/fabric differentiations.
     * Forge conventions are sapling:"saplingName" without "sapling" appended ex: forge:saplings/apple
     * In fabric we would just do c:apple_saplings
     * This method creates the appropriate tags for both platforms
     * Forge: forge:saplings/apple
     * Fabric: c:apple_saplings
     * Saplings.json -> references Fabric -> references forge
     */
    private void createSeedSaplingTag(String category, String name, Item item) {
        String pluralSeedName;
        if (item == Content.VANILLA.getSeedItem()) {
            pluralSeedName = reverseLookup(item).location().getPath();
        } else {
            pluralSeedName = reverseLookup(item).location().getPath() + "s";
        }

        // Forge tags use seed/cropname, but not including seed name. artichoke good artichoke_seed bad.
        TagKey<Item> forgeFriendlyTag = register(category + "/" + name);
        ResourceLocation independentEntry = independentTag(category + "/" + name);

        this.tag(forgeFriendlyTag).add(reverseLookup(item));
        ObjectBuilderAccessor<?> group = (ObjectBuilderAccessor<?>) this.tag(register(category));
        group.getBuilder().add(new ForcedTagEntry(TagEntry.tag(independentEntry)));

        ObjectBuilderAccessor<?> fabricGeneralTag = (ObjectBuilderAccessor<?>) this.tag(register(pluralSeedName)).add(reverseLookup(item));
        fabricGeneralTag.getBuilder().add(new ForcedTagEntry(TagEntry.tag(independentEntry)));
    }

    private ResourceLocation independentTag(String name) {
        return CroptopiaMod.createCommonIdentifier(name);
    }
}
