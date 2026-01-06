package io.github.cottonmc.cotton.gui.impl.fabric;

import io.github.cottonmc.cotton.gui.impl.LibGuiCommon;
import net.fabricmc.api.ModInitializer;

public final class LibguiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        LibGuiCommon.init();
    }
}
