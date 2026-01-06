package io.github.cottonmc.cotton.gui.impl.client;

import dev.architectury.event.events.client.ClientReloadShadersEvent;
import io.github.cottonmc.cotton.gui.impl.LibGuiCommon;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public final class LibGuiShaders {
	private static @Nullable ShaderProgram tiledRectangle;

	static void register() {
		ClientReloadShadersEvent.EVENT.register((provider, sink) -> {
			// Register our core shaders.
			// The tiled rectangle shader is used for performant tiled texture rendering.
            try {
                sink.registerShader(
                    new ShaderProgram(
                        provider,
                        "tiled_rectangle",
                        VertexFormats.POSITION
                    ), shader -> {
                        tiledRectangle = shader;
                    }
                );
				LoggerFactory.getLogger("LibGuiShaders").info("Successfully registered shader Program");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
	}

	private static ShaderProgram assertPresent(ShaderProgram program, String name) {
		if (program == null) {
			throw new NullPointerException("Shader libgui:" + name + " not initialised!");
		}

		return program;
	}

	public static ShaderProgram getTiledRectangle() {
		return assertPresent(tiledRectangle, "tiled_rectangle");
	}
}
