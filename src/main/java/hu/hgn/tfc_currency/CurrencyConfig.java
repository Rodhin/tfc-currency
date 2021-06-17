package hu.hgn.tfc_currency;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
@Config(modid = Main.MOD_ID, category = "general")
@Config.LangKey("config." + Main.MOD_ID)
public final class CurrencyConfig {
    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Main.MOD_ID)) {
            ConfigManager.sync(Main.MOD_ID, Config.Type.INSTANCE);
        }
    }

    @Config.Comment("Yield rate settings")
    @Config.LangKey("config." + Main.MOD_ID + ".yield_rate")
    public static final YieldCFG YIELD = new YieldCFG();

    @Config.Comment("Enabled coin metals")
    @Config.LangKey("config." + Main.MOD_ID + ".coin_metals")
    public static final MetalsCFG METALS = new MetalsCFG();

    public static class YieldCFG {
        @Config.Comment("Yield rate per 100 units of metal when crafting on the anvil (from metal sheet, 1 sheet contains 200 units of metal). Default: 5")
        @Config.LangKey("config." + Main.MOD_ID + ".yield_rate.anvil")
        public int AnvilYieldRate = 5;
    }

    public static class MetalsCFG {
        @Config.Comment("Enable copper coins. Default: true")
        @Config.LangKey("config." + Main.MOD_ID + ".coin_metals.copper")
        public boolean Copper = true;

        @Config.Comment("Enable silver coins. Default: true")
        @Config.LangKey("config." + Main.MOD_ID + ".coin_metals.silver")
        public boolean Silver = true;

        @Config.Comment("Enable gold coins. Default: true")
        @Config.LangKey("config." + Main.MOD_ID + ".coin_metals.gold")
        public boolean Gold = true;
    }
}
