package hu.hgn.tfc_currency.handlers;

import hu.hgn.tfc_currency.CurrencyConfig;
import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import hu.hgn.tfc_currency.init.ModItems;
import hu.hgn.tfc_currency.utils.IHasModel;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.types.DefaultMetals;
import net.dries007.tfc.util.forge.ForgeRule;
import net.dries007.tfc.util.skills.SmithingSkill;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(RegistryEvent.Register<Item> event) {
        for(Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
    }

    @SubscribeEvent
    public static void registerAnvilRecipes(RegistryEvent.Register<AnvilRecipe> event) {
        IForgeRegistry<AnvilRecipe> registry = event.getRegistry();
        ForgeRule[] coinRules = new ForgeRule[] {ForgeRule.BEND_LAST, ForgeRule.DRAW_SECOND_LAST, ForgeRule.DRAW_THIRD_LAST};

        if (CurrencyConfig.METALS.Copper) addAnvil(registry, DefaultMetals.COPPER, ModItems.COPPER_COIN, coinRules);
        if (CurrencyConfig.METALS.Silver) addAnvil(registry, DefaultMetals.SILVER, ModItems.SILVER_COIN, coinRules);
        if (CurrencyConfig.METALS.Gold) addAnvil(registry, DefaultMetals.GOLD, ModItems.GOLD_COIN, coinRules);
    }

    private static void addAnvil(IForgeRegistry<AnvilRecipe> registry, ResourceLocation material, ItemTFC item, ForgeRule[] forgeRules) {
        IIngredient<ItemStack> ingredient = IIngredient.of(new ItemStack(ItemMetal.get(Objects.requireNonNull(TFCRegistries.METALS.getValue(material)), Metal.ItemType.SHEET)));
        ItemStack output = new ItemStack(item, CurrencyConfig.YIELD.AnvilYieldRate * 2);

        registry.register(new AnvilRecipe(
                Objects.requireNonNull(item.getRegistryName()),
                ingredient,
                output,
                Objects.requireNonNull(TFCRegistries.METALS.getValue(material)).getTier(),
                SmithingSkill.Type.GENERAL,
                forgeRules
        ));
    }
}
