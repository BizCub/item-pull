package io.github.bizcub.itemPull.config;

import io.github.bizcub.itemPull.ItemPull;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.*;

@AutoConfig(name = ItemPull.MOD_ID, snakeCaseKeys = true, translate = true)
public class SimpleConfig implements Config {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class);
    }

    @Tooltip
    public double radius = Config.super.radius();

    @Tooltip
    public boolean matchNbt = Config.super.matchNbt();

    @Override
    public double radius() { return this.radius; }

    @Override
    public boolean matchNbt() { return this.matchNbt; }
}
