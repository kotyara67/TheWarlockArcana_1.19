package net.kotyara67.the_warlock_arcana.event;

import net.kotyara67.the_warlock_arcana.TWA_main;
import net.kotyara67.the_warlock_arcana.networking.ModNetworking;
import net.kotyara67.the_warlock_arcana.networking.packet.ExampleC2SPacket;
import net.kotyara67.the_warlock_arcana.util.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TWA_main.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.ELEMENT_SLOT1.consumeClick()){
                ModNetworking.sendToServer(new ExampleC2SPacket());
            }
        }

    }

    @Mod.EventBusSubscriber(modid = TWA_main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.ELEMENT_SLOT1);
        }
    }

}
