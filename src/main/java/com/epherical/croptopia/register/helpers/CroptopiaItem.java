package com.epherical.croptopia.register.helpers;

import com.epherical.croptopia.common.Tags;
import com.epherical.croptopia.util.ItemConvertibleWithPlural;
import com.epherical.croptopia.util.TagConvertible;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.Objects;

public abstract class CroptopiaItem implements ItemConvertibleWithPlural, TagConvertible<Item> {

    protected final String name;
    protected final boolean plural;
    protected final TagKey<Item> tag;

    protected CroptopiaItem(final String name, final boolean plural) {
        this.name = Objects.requireNonNull(name);
        this.plural = plural;
        tag = Tags.createCropTag(getPlural());
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
    public TagKey<Item> asTag() {
        return tag;
    }

}
