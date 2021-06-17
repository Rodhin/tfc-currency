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

    public static class YieldCFG {
        @Config.Comment("Yield rate per 100 units of metal when crafting on the anvil (from metal sheet, 1 sheet contains 200 units of metal). Default: 5")
        @Config.LangKey("config." + Main.MOD_ID + ".yield_rate.anvil")
        public int AnvilYieldRate = 5;
    }
}
