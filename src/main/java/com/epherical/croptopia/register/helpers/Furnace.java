package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.FoodConstructor;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaMod.createGroup;

public class Furnace implements ItemConvertibleWithPlural {
    public static final List<Furnace> INSTANCES = new ArrayList<>();

    private final String name;
    private final boolean plural;
    private Item item;


    public Furnace(final String name, final boolean plural, final FoodConstructor foodConstructor) {
        Content.ITEM_REGISTER.reg(registerFunction -> registerItem(registerFunction, foodConstructor));
        this.name = name;
        this.plural = plural;

        INSTANCES.add(this);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean hasPlural() {
        return plural;
    }

    @Override
    public Item asItem() {
        return item;
    }

    public void registerItem(final RegisterFunction<Item> register, final FoodConstructor foodConstructor) {
        this.item = register.register(CroptopiaMod.createIdentifier(name), () -> {
            if (foodConstructor == null) {
                return new Item(createGroup());
            } else {
                return new Item(createGroup().food(FoodConstructor.createFood(foodConstructor)));
            }
        });
    }
}
