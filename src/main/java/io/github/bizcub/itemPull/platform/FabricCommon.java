//? fabric {
package io.github.bizcub.itemPull.platform;

import io.github.bizcub.itemPull.ItemPull;
import net.fabricmc.api.ModInitializer;

public class FabricCommon implements ModInitializer {

    @Override
    public void onInitialize() {
        ItemPull.init();
    }
}//?}
