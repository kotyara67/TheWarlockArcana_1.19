package net.kotyara67.the_warlock_arcana.item.customs;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class FireballScrollItem extends Item {
    public FireballScrollItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {

        if(!level.isClientSide()) {

            Vec3 vec = player.getViewVector(0);

            level.playSound(player,player.getX(),player.getY(),player.getZ(), SoundEvents.EVOKER_CAST_SPELL, SoundSource.PLAYERS,2.0F,1.0F);

            for(int i = 0; i < 5; i++) {
                SmallFireball smallFireball = new SmallFireball(level, player, vec.x(), vec.y(), vec.z());

                smallFireball.setOwner(player);

                smallFireball.setPos(player.getX(),player.getY() + 1.5D, player.getZ());

                smallFireball.shootFromRotation(player,player.getXRot(),player.getYRot(),0F,0.2F,15F);

                level.addFreshEntity(smallFireball);
            }

            player.getCooldowns().addCooldown(this,120);
        }

        else {
            level.playLocalSound(player.getX(),player.getY(),player.getZ(),SoundEvents.EVOKER_CAST_SPELL,SoundSource.PLAYERS,2.0F,1.0F,false);
        }

        return super.use(level, player, hand);
    }

}
