package hu.hgn.tfc_currency;

import hu.hgn.tfc_currency.proxy.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = Main.MOD_ID,
        name = Main.MOD_NAME,
        version = Main.VERSION
)
public class Main {

    public static final String MOD_ID = "tfc_currency";
    public static final String MOD_NAME = "TFC Currency";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "hu.hgn.tfc_currency.proxy.ClientProxy", serverSide = "hu.hgn.tfc_currency.proxy.CommonProxy")
    public static CommonProxy proxy;
}
