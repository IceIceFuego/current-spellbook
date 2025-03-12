package com.currentspellbook;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("com.currentspellbook")
public interface CurrentSpellbookConfig extends Config
{
	@ConfigItem(
		keyName = "fontSize",
		name = "Font size",
		description = "How big the overlay text should be"
	)
	default int fontSize()
	{
		return 32;
	}

	@ConfigItem(
			position = 2,
			keyName = "changeColors",
			name = "Change font colors",
			description = "Whether or not the font color should change according to the spellbook"
	)
	default boolean changeColors()
	{
		return true;
	}
}
