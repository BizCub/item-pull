package io.github.bizcub.itemPull.config;

import io.github.bizcub.itemPull.ItemPull;
import io.github.bizcub.simpleConfigLib.autoconfig.gui.ConfigScreens;
import net.minecraft.client.gui.screens.Screen;

public class ConfigHelperClient {

    public static Screen getScreen(Screen parent) {
        return ConfigHelperCommon.isConfigLoaded()
                ? ConfigScreens.open(ItemPull.MOD_ID, parent)
                : parent;
    }
}
