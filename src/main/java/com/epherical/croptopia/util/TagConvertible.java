package com.epherical.croptopia.util;

import net.minecraft.tags.TagKey;

public interface TagConvertible<T> {

    TagKey<T> asTag();

}
