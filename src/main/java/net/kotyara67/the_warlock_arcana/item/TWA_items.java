package net.kotyara67.the_warlock_arcana.item;

import net.kotyara67.the_warlock_arcana.TWA_main;
import net.kotyara67.the_warlock_arcana.item.customs.FangScrollItem;
import net.kotyara67.the_warlock_arcana.item.customs.FireballScrollItem;
import net.kotyara67.the_warlock_arcana.item.customs.SpectralRing;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWA_items {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TWA_main.MOD_ID);

    public static final RegistryObject<Item> EMPTY_SPELL_SCROLL = ITEMS.register("empty_spell_scroll",
            () -> new Item(new Item.Properties().tab(TWA_creativeModTabs.Tabs.TWA_items_tab)));

    public static final RegistryObject<Item> FIREBALL_SPELL_SCROLL = ITEMS.register("fireball_spell_scroll",
            () -> new FireballScrollItem(new Item.Properties().tab(TWA_creativeModTabs.Tabs.TWA_items_tab).stacksTo(1)));

    public static final RegistryObject<Item> FANG_SPELL_SCROLL = ITEMS.register("fang_spell_scroll",
            () -> new FangScrollItem(new Item.Properties().tab(TWA_creativeModTabs.Tabs.TWA_items_tab).stacksTo(1)));

    public static final RegistryObject<Item> SPECTRAL_RING = ITEMS.register("spectral_ring",
            () -> new SpectralRing(new Item.Properties().tab(TWA_creativeModTabs.Tabs.TWA_items_tab).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
