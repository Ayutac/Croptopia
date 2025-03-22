package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaMod.createGroup;
import static com.epherical.croptopia.util.FoodConstructor.*;

public class IceCream extends CroptopiaItem {
    public static final List<IceCream> INSTANCES = new ArrayList<>();

    private final ItemConvertibleWithPlural crop;
    private Item item;

    public IceCream(final String name, final ItemConvertibleWithPlural crop) {
        super(name, true);
        Content.ITEM_REGISTER.reg(this::registerItem);
        this.crop = crop;
        INSTANCES.add(this);
    }

    @Override
    public Item asItem() {
        return item;
    }

    public ItemConvertibleWithPlural getCrop() {
        return crop;
    }

    public void registerItem(final RegisterFunction<Item> register) {
        this.item = register.register(CroptopiaMod.createIdentifier(name), () -> new Item(createGroup().food(createFood(ICE_CREAM_7))));
    }

}
