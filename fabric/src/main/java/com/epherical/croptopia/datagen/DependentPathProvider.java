package com.epherical.croptopia.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class DependentPathProvider extends PackOutput.PathProvider {

    private final Path root;
    private final String kindCopy;

    public DependentPathProvider(final FabricDataOutput dataGenerator, final PackOutput.Target target, final String string) {
        super(dataGenerator, target, string);
        this.root = dataGenerator.getOutputFolder().resolve("dependents/platform/");
        this.kindCopy = string;
    }

    @Override
    @NotNull
    public Path file(final ResourceLocation resourceLocation, final String string) {
        final Path type = this.root.resolve(this.kindCopy);
        final String path = resourceLocation.getPath();
        return type.resolve(path + "." + string);
    }

    @Override
    @NotNull
    public Path json(final ResourceLocation resourceLocation) {
        return this.root.resolve(this.kindCopy).resolve(resourceLocation.getPath() + ".json");
    }
}
