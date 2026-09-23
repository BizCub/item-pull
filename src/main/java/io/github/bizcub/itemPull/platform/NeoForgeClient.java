//? neoforge {
/*package io.github.bizcub.itemPull.platform;

import io.github.bizcub.itemPull.ItemPull;
import io.github.bizcub.itemPull.config.ConfigHelperClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = ItemPull.MOD_ID, dist = Dist.CLIENT)
public class NeoForgeClient {

    public NeoForgeClient() {
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (container, parent) -> ConfigHelperClient.getScreen(parent));
    }
}*///?}
