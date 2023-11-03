package net.indiactive.tfch.common.blocks;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.util.registry.RegistrationHelpers;

import net.indiactive.tfch.TFCHusbandry;
import net.indiactive.tfch.common.items.ButcheryBlock;
import net.indiactive.tfch.common.items.TFCHItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

public class TFCHBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TFCHusbandry.MODID);

    // Stations
    public static final RegistryObject<Block> BUTCHERY = registerBlockItem("butchery", () -> new ButcheryBlock(ExtendedProperties.of().strength(2.0f).sound(SoundType.WOOD).flammable(40, 20)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier)
    {
        return register(name, blockSupplier, (Function<T, ? extends BlockItem>) null);
    }

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> blockSupplier)
    {
        return register(name, blockSupplier, block -> new BlockItem(block, new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> blockSupplier, Item.Properties blockItemProperties)
    {
        return register(name, blockSupplier, block -> new BlockItem(block, blockItemProperties));
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, @Nullable Function<T, ? extends BlockItem> blockItemFactory)
    {
        return RegistrationHelpers.registerBlock(BLOCKS, TFCHItems.ITEMS, name, blockSupplier, blockItemFactory);
    }
}

