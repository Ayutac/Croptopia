package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.items.Drink;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaMod.createGroup;
import static com.epherical.croptopia.util.FoodConstructor.*;

public class Smoothie extends CroptopiaItem {
    public static final List<Smoothie> INSTANCES = new ArrayList<>();

    private final ItemConvertibleWithPlural crop;
    private final boolean sweet;
    private Item item;

    public Smoothie(final String name, final ItemConvertibleWithPlural cropItemName, final boolean sweet) {
        super(name, true);
        this.sweet = sweet; // property not yet used, will be used in upcoming saturation overhaul
        this.crop = cropItemName;
        Content.ITEM_REGISTER.reg(this::registerItems);

        INSTANCES.add(this);
    }

    public Smoothie(final String name, final ItemConvertibleWithPlural cropItemName) {
        this(name, cropItemName, true);
    }

    public ItemConvertibleWithPlural getCrop() {
        return crop;
    }

    @Override
    public Item asItem() {
        return item;
    }

    public void registerItems(final RegisterFunction<Item> register) {
        item = register.register(CroptopiaMod.createIdentifier(name),  () -> new Drink(createGroup().food(createBuilder(JUICE_5).alwaysEdible().build()).craftRemainder(Items.GLASS_BOTTLE)));
    }
}
