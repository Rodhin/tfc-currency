package hu.hgn.tfc_currency.items;

import hu.hgn.tfc_currency.Main;
import hu.hgn.tfc_currency.init.ModItems;
import hu.hgn.tfc_currency.utils.IHasModel;
import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.objects.CreativeTabsTFC;
import net.dries007.tfc.objects.items.ItemTFC;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBase extends ItemTFC implements IHasModel {
    public ItemBase(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabsTFC.CT_METAL);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Nonnull
    @Override
    public Size getSize(@Nonnull ItemStack itemStack) {
        return Size.TINY;
    }

    @Nonnull
    @Override
    public Weight getWeight(@Nonnull ItemStack itemStack) {
        return Weight.VERY_LIGHT;
    }
}
