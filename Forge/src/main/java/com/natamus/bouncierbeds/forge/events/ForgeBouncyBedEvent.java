package com.natamus.bouncierbeds.forge.events;

import com.natamus.bouncierbeds.events.BouncyBedEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeBouncyBedEvent {
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent e) {
		LivingEntity livingEntity = e.getEntity();
		BouncyBedEvent.onLivingJump(livingEntity.level, livingEntity);
	}
	
	@SubscribeEvent
	public void onFall(LivingFallEvent e) {
		Entity entity = e.getEntity();
		if (BouncyBedEvent.onFall(entity.level, entity, 0, 0) == 0) {
			e.setCanceled(true);
		}
	}
}
