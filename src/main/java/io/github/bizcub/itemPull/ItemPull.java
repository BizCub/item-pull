package io.github.bizcub.itemPull;

import io.github.bizcub.itemPull.config.Config;
import io.github.bizcub.itemPull.config.ConfigHelperCommon;
import io.github.bizcub.itemPull.config.SimpleConfig;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public final class ItemPull {
    public static final String MOD_ID = /*$ mod_id*/ "item_pull";
    private static final double REACH = 12.0;

    public static void init() {
        if (ConfigHelperCommon.isConfigLoaded()) {
            Config.set(SimpleConfig.getInstance().get());
        }
    }

    public static boolean tryPull(ServerPlayer player) {
        HitResult hit = ProjectileUtil.getHitResultOnViewVector(
                player, e -> e instanceof ItemEntity, REACH);
        if (!(hit instanceof EntityHitResult ehr) || !(ehr.getEntity() instanceof ItemEntity target)) {
            return false;
        }

        //~ if >=1.21.6 'serverLevel()' -> 'level()'
        ServerLevel level = player.level();
        ItemStack ref = target.getItem();
        boolean matchNbt = Config.get().matchNbt();

        for (ItemEntity other : level.getEntitiesOfClass(ItemEntity.class, target.getBoundingBox().inflate(Config.get().radius()),
                e -> e != target && e.isAlive() && (matchNbt
                        //~ if >=1.20.5 'isSameItemSameTags' -> 'isSameItemSameComponents'
                        ? ItemStack.isSameItemSameComponents(e.getItem(), ref)
                        : ItemStack.isSameItem(e.getItem(), ref)))) {
            other.teleportTo(target.getX(), target.getY(), target.getZ());
            other.setDeltaMovement(Vec3.ZERO);
        }
        return true;
    }
}
