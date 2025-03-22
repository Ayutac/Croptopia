package com.epherical.croptopia.register.helpers;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleItemWrapper extends CroptopiaItem {

    public static final List<SimpleItemWrapper> INSTANCES = new ArrayList<>();

    private final Item item;

    public SimpleItemWrapper(final String name, final boolean plural, final Item item) {
        super(name, plural);
        this.item = Objects.requireNonNull(item);
        INSTANCES.add(this);
    }

    @NotNull
    @Override
    public Item asItem() {
        return item;
    }
}
