package net.kotyara67.the_warlock_arcana.item.customs;

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
        if(!level.isClientSide()){

            Vec3 vec = player.getViewVector(0);

            SmallFireball smallFireball = new SmallFireball(level, player,
                    vec.x(),
                    vec.y(),
                    vec.z());

            smallFireball.setPos(player.getX(),player.getY()+1.5D,player.getZ());

            level.addFreshEntity(smallFireball);

            player.getCooldowns().addCooldown(this,10);
        }
        return super.use(level, player, hand);
    }
}
