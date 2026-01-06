package io.github.cottonmc.cotton.gui.impl.forge;

import io.github.cottonmc.cotton.gui.impl.LibGuiCommon;
import dev.architectury.platform.forge.EventBuses;
import io.github.cottonmc.cotton.gui.impl.client.LibGuiClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LibGuiCommon.MOD_ID)
public final class LibguiForge {
    public LibguiForge(FMLJavaModLoadingContext context) {
        // Submit our event bus to let Architectury API register our content on the right time.
        IEventBus modEventBus = context.getModEventBus();
        EventBuses.registerModEventBus(LibGuiCommon.MOD_ID, modEventBus);

        // Run our common setup.
        LibGuiCommon.init();
    }

    @Mod.EventBusSubscriber(modid = LibGuiCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    static class ClientModEvents {
        @SubscribeEvent
        static void onClientSetup(FMLClientSetupEvent event) {
            LibGuiClient.initClient();
        }
    }
}
