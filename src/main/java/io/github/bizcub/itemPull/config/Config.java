package io.github.bizcub.itemPull.config;

public interface Config {
    static Config get() {
        return Holder.INSTANCE;
    }

    static void set(final Config config) {
        if (config != null) Holder.INSTANCE = config;
    }

    class Holder {
        private static Config INSTANCE = new Config() { };
    }

    default double radius() {
        return 4.0;
    }

    default boolean matchNbt() {
        return true;
    }
}
