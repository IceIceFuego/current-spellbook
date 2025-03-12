package com.currentspellbook;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface CurrentSpellbookConfig extends Config
{
	@ConfigItem(
		keyName = "fontSize",
		name = "Font Size",
		description = "How big the overlay text should be"
	)
	default int fontSize()
	{
		return 16;
	}
}
