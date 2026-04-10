package com.natamus.bouncierbeds.forge.events;

import com.natamus.bouncierbeds.events.BouncyBedEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeBouncyBedEvent {
	public static void registerEventsInBus() {
		BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeBouncyBedEvent.class);
	}

	@SubscribeEvent
	public static void onLivingJump(LivingJumpEvent e) {
		LivingEntity livingEntity = e.getEntity();
		BouncyBedEvent.onLivingJump(livingEntity.level(), livingEntity);
	}
	
	@SubscribeEvent
	public static boolean onFall(LivingFallEvent e) {
		Entity entity = e.getEntity();
		if (BouncyBedEvent.onFall(entity.level(), entity, 0, 0) == 0) {
			return true;
		}
		return false;
	}
}
