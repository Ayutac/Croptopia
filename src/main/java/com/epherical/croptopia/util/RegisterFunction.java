package com.epherical.croptopia.util;


import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

@FunctionalInterface
public interface RegisterFunction<T> {
    T register(final ResourceLocation id, final Supplier<T> object);
}
