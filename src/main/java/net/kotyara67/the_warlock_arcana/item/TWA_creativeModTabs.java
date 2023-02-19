package net.kotyara67.the_warlock_arcana.item;

import net.kotyara67.the_warlock_arcana.block.TWA_blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TWA_creativeModTabs {

    public class Tabs {

        public static final CreativeModeTab TWA_items_tab = new CreativeModeTab("TWA_items_tab") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(TWA_items.EMPTY_SPELL_SCROLL.get());
            }
        };

        public static final CreativeModeTab TWA_blocks_tab = new CreativeModeTab("TWA_blocks_tab") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(TWA_blocks.CRYOLITE_ORE.get());
            }
        };
    }

}
