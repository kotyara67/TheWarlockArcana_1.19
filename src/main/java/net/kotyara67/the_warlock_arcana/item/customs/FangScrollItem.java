package net.kotyara67.the_warlock_arcana.item.customs;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

public class FangScrollItem extends Item {
    public FangScrollItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {

        if(!level.isClientSide()) {

            level.playSound(player,player.getX(),player.getY(),player.getZ(),SoundEvents.EVOKER_PREPARE_ATTACK, SoundSource.PLAYERS,2.0F,1.0F);

            Vec3 vec = player.getViewVector(0);

            float f = (float) Mth.atan2(vec.z(),vec.x());

            for (int i = 1; i < 10; i++) {
                float f1 = f + (float)i * (float)Math.PI * 0.2F;
                EvokerFangs fang = new EvokerFangs(level, player.getX() + (double)Mth.cos(f1) * 1.5D, player.getY(), player.getZ() + (double)Mth.sin(f1) * 1.5D, f1, i, player);
                level.addFreshEntity(fang);
            }

            for(int i = 0; i < 7; ++i) {
                double d2 = 1.25D * (double)(i + 1);
                EvokerFangs fang = new EvokerFangs(level, player.getX() + (double)Mth.cos(f) * d2, player.getY(), player.getZ() + (double)Mth.sin(f) * d2, f, i, player);
                level.addFreshEntity(fang);
            }

            player.getCooldowns().addCooldown(this,40);
        }
        else {
            level.playLocalSound(player.getX(),player.getY(),player.getZ(),SoundEvents.EVOKER_PREPARE_ATTACK,SoundSource.PLAYERS,2.0F,1.0F,false);
        }
        return super.use(level, player, hand);
    }

}
