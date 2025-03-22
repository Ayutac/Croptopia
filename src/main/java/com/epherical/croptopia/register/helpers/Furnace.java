package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.FoodConstructor;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaMod.createGroup;

public class Furnace extends CroptopiaItem {
    public static final List<Furnace> INSTANCES = new ArrayList<>();

    private Item item;


    public Furnace(final String name, final boolean plural, final FoodConstructor foodConstructor) {
        super(name, plural);
        Content.ITEM_REGISTER.reg(registerFunction -> registerItem(registerFunction, foodConstructor));

        INSTANCES.add(this);
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
