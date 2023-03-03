package net.kotyara67.the_warlock_arcana.item.customs;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SpectralRing extends Item {
    public SpectralRing(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean b) {

        if(entity instanceof LivingEntity livingEntity){
            if(livingEntity.getLastHurtByMob() != null) {
                livingEntity.getLastHurtByMob().addEffect(new MobEffectInstance(MobEffects.GLOWING, 600));
            }
        }

        super.inventoryTick(stack, level, entity, i, b);
    }
}
