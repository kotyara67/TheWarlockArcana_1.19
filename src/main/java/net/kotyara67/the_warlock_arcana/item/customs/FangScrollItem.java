package net.kotyara67.the_warlock_arcana.item.customs;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class FangScrollItem extends Item {
    public FangScrollItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(!level.isClientSide()){

            Vec3 vec = player.getViewVector(0);

            float f = (float) Mth.atan2(vec.z(),vec.x());

            for (int i = 0; i < 10; i++) {
                float f1 = f + (float)i * (float)Math.PI * 0.2F;

                EvokerFangs fang = new EvokerFangs(level,
                        player.getX() + (double)Mth.cos(f1) * 1.7D,
                        player.getY(),
                        player.getZ() + (double)Mth.sin(f1) * 1.7D,
                        f1, randInt(0,8), player);

                level.addFreshEntity(fang);
            }

            for(int k = 0; k < 16; ++k) {
                float f2 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + 1.2566371F;

                EvokerFangs fang = new EvokerFangs(level,
                        player.getX() + (double)Mth.cos(f2) * 3D,
                        player.getY(),
                        player.getZ() + (double)Mth.sin(f2) * 3D,
                        f2, randInt(0,8), player);

                level.addFreshEntity(fang);
            }

            player.getCooldowns().addCooldown(this,30);
        }
        return super.use(level, player, hand);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min)) + min;
    }
}
