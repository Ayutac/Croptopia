package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.CroptopiaMod;
import com.epherical.croptopia.items.CookingUtensil;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import com.epherical.croptopia.util.RegisterFunction;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.epherical.croptopia.CroptopiaMod.createGroup;

public class Utensil implements ItemConvertibleWithPlural {

    public static final List<Utensil> INSTANCES = new ArrayList<>();

    private final String name;
    private final boolean plural;
    private Item utensil;


    public Utensil(final String name, final boolean plural) {
        Content.ITEM_REGISTER.reg(this::registerItems);
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
        return utensil;
    }

    public void registerItems(final RegisterFunction<Item> register) {
        this.utensil = register.register(CroptopiaMod.createIdentifier(name), () -> new CookingUtensil(createGroup().stacksTo(1)));
    }
}
