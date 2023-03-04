package net.kotyara67.the_warlock_arcana.block;

import net.kotyara67.the_warlock_arcana.TWA_main;
import net.kotyara67.the_warlock_arcana.block.custom.DamnumBlock;
import net.kotyara67.the_warlock_arcana.item.TWA_creativeModTabs;
import net.kotyara67.the_warlock_arcana.item.TWA_items;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TWA_blocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TWA_main.MOD_ID);


    ///////////////////BLOCKS
    public static final RegistryObject<Block> CRYOLITE_BLOCK = registerBlock("cryolite_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), TWA_creativeModTabs.Tabs.TWA_blocks_tab);
    public static final RegistryObject<Block> CRYOLITE_ORE = registerBlock("cryolite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(5,9)), TWA_creativeModTabs.Tabs.TWA_blocks_tab);
    public static final RegistryObject<Block> DEEPSLATE_CRYOLITE_ORE = registerBlock("deepslate_cryolite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(5,9)), TWA_creativeModTabs.Tabs.TWA_blocks_tab);
    ///////////////////CUSTOM BLOCKS
    public static final RegistryObject<Block> DAMNUM_BLOCK = registerBlock("damnum_block", () -> new DamnumBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), TWA_creativeModTabs.Tabs.TWA_blocks_tab);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return TWA_items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
