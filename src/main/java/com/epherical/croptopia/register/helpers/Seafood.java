package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.FoodConstructor;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaMod.createGroup;

public class Seafood extends CroptopiaItem {
    public static final List<Seafood> INSTANCES = new ArrayList<>();

    private Item item;

    public Seafood(final String name, final boolean plural, final FoodConstructor foodConstructor) {
        super(name, plural);
        Content.ITEM_REGISTER.reg(registerFunction -> this.registerItem(registerFunction, foodConstructor));
        INSTANCES.add(this);
    }

    @Override
    public Item asItem() {
        return item;
    }

    public void registerItem(final RegisterFunction<Item> register, final FoodConstructor foodConstructor) {
        item = register.register(CroptopiaMod.createIdentifier(name), () -> {
            if (name.contains("GLOWING")) {
                return new Item(createGroup().food(FoodConstructor.createBuilder(foodConstructor)
                        .effect(new MobEffectInstance(MobEffects.GLOWING, 4000, 1), 1.0F).build()));
            } else {
                return new Item(createGroup().food(FoodConstructor.createFood(foodConstructor)));
            }
        });
    }
}
