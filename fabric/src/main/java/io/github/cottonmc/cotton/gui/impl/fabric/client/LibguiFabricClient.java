package io.github.cottonmc.cotton.gui.impl.fabric.client;

import io.github.cottonmc.cotton.gui.impl.client.LibGuiClient;
import net.fabricmc.api.ClientModInitializer;

public final class LibguiFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        LibGuiClient.initClient();
    }
}
