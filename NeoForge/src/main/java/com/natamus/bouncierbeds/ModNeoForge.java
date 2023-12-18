package com.natamus.bouncierbeds;

import com.natamus.bouncierbeds.neoforge.config.IntegrateNeoForgeConfig;
import com.natamus.bouncierbeds.neoforge.events.NeoForgeBouncyBedEvent;
import com.natamus.bouncierbeds.util.Reference;
import com.natamus.collective.check.RegisterMod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge(IEventBus modEventBus) {
		modEventBus.addListener(this::loadComplete);

		setGlobalConstants();
		ModCommon.init();

		IntegrateNeoForgeConfig.registerScreen(ModLoadingContext.get());

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(NeoForgeBouncyBedEvent.class);
	}

	private static void setGlobalConstants() {

	}
}