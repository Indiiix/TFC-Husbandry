package net.indiactive.tfch.common;

import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.indiactive.tfch.TFCHusbandry;
import net.indiactive.tfch.common.blocks.TFCHBlocks;

public class TFCHCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TFCHusbandry.MODID);
    public static final RegistryObject<CreativeModeTab> TFC_HUSBANDRY = register("tfch", () -> new ItemStack(TFCHBlocks.BUTCHERY.get()), TFCHCreativeTabs::TFCHpopulate);

    private static void TFCHpopulate(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output out)
    {
        out.accept(TFCHBlocks.BUTCHERY.get());
    }
    private static RegistryObject<CreativeModeTab> register(String name, Supplier<ItemStack> icon, CreativeModeTab.DisplayItemsGenerator displayItems)
    {
        return CREATIVE_TABS.register(name, () -> CreativeModeTab.builder()
            .icon(icon)
            .title(Component.translatable("tfch.creative_tab." + name))
            .displayItems(displayItems)
            .build());
    }
}
