package hu.hgn.tfc_currency.init;

import hu.hgn.tfc_currency.CurrencyConfig;
import hu.hgn.tfc_currency.items.ItemBase;
import net.dries007.tfc.objects.items.ItemTFC;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ItemTFC> ITEMS = new ArrayList<ItemTFC>();

    public static final ItemTFC COPPER_COIN = CurrencyConfig.METALS.Copper ? new ItemBase("coin_copper") : null;
    public static final ItemTFC SILVER_COIN = CurrencyConfig.METALS.Silver ? new ItemBase("coin_silver") : null;
    public static final ItemTFC GOLD_COIN = CurrencyConfig.METALS.Gold ? new ItemBase("coin_gold") : null;
}
