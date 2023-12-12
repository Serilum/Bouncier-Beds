package com.natamus.bouncierbeds.neoforge.events;

import com.natamus.bouncierbeds.events.BouncyBedEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeBouncyBedEvent {
	@SubscribeEvent
	public static void onLivingJump(LivingJumpEvent e) {
		LivingEntity livingEntity = e.getEntity();
		BouncyBedEvent.onLivingJump(livingEntity.level(), livingEntity);
	}
	
	@SubscribeEvent
	public static void onFall(LivingFallEvent e) {
		Entity entity = e.getEntity();
		if (BouncyBedEvent.onFall(entity.level(), entity, 0, 0) == 0) {
			e.setCanceled(true);
		}
	}
}
