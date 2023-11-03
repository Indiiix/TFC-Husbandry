package net.indiactive.tfch.common.items;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.IForgeBlockExtension;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class ButcheryBlock extends Block implements IForgeBlockExtension
{
    private final ExtendedProperties properties;

    public ButcheryBlock(ExtendedProperties properties)
    {
        super(properties.properties());
        this.properties = properties;
    }

    @Override
    public @NotNull ExtendedProperties getExtendedProperties()
    {
        return properties;
    }
}
