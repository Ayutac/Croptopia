package com.epherical.croptopia.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReferenceItem extends Item {

    private final Component component;

    public ReferenceItem(final Properties properties, final Component component) {
        super(properties);
        this.component = component;
    }

    @Override
    public void appendHoverText(final @NotNull ItemStack item, final @NotNull TooltipContext level, final @NotNull List<Component> tooltip, final @NotNull TooltipFlag flag) {
        super.appendHoverText(item, level, tooltip, flag);
        tooltip.add(component);
    }
}
