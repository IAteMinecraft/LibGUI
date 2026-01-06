package io.github.cottonmc.cotton.gui.impl.client;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public interface CottonScreenImpl {
	GuiDescription getDescription();

	@Nullable
	WWidget getLastResponder();

	void setLastResponder(@Nullable WWidget lastResponder);
}
