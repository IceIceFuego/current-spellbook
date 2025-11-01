package com.currentspellbook;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.overlay.OverlayManager;

import java.util.Objects;

@Slf4j
@PluginDescriptor(
	name = "Current Spellbook"
)
public class CurrentSpellbookPlugin extends Plugin
{
	private static final int SPELLBOOK_VARBIT = 4070;

	@Inject
	private Client client;

	@Inject
	private CurrentSpellbookConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private CurrentSpellbookOverlay currentSpellbookOverlay;

	@Inject
	private PluginManager pluginManager;

	@Inject
	private ConfigManager configManager;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(currentSpellbookOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(currentSpellbookOverlay);
	}

	@Provides
	CurrentSpellbookConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CurrentSpellbookConfig.class);
	}

	int getCurrentSpellbook()
	{
		return client.getVarbitValue(SPELLBOOK_VARBIT);
	}

	void getSetupSpellbook()
	{
		Config config;
		for (Plugin p : pluginManager.getPlugins())
		{
			if (p.getName().equals("inventory-setups"))
			{
				config = pluginManager.getPluginConfigProxy(p);
				ConfigDescriptor configDescriptor = configManager.getConfigDescriptor(config);
			}
		}
	}
}
