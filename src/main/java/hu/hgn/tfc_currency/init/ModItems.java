package hu.hgn.tfc_currency.init;

import hu.hgn.tfc_currency.items.ItemBase;
import net.dries007.tfc.objects.items.ItemTFC;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ItemTFC> ITEMS = new ArrayList<ItemTFC>();

    public static final ItemTFC COPPER_COIN = new ItemBase("coin_copper");
    public static final ItemTFC SILVER_COIN = new ItemBase("coin_silver");
    public static final ItemTFC GOLD_COIN = new ItemBase("coin_gold");
}
