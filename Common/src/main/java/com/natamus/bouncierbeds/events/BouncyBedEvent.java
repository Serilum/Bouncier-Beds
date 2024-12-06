package com.natamus.bouncierbeds.events;

import com.natamus.bouncierbeds.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;

public class BouncyBedEvent {
	public static void onLivingJump(Level world, Entity entity) {
		if (!(entity instanceof Player)) {
			return;
		}
		
		Player player = (Player)entity;
		BlockPos ppos = player.blockPosition();
		
		Block blockfeet = world.getBlockState(ppos).getBlock();
		Block blockbelowfeet = world.getBlockState(ppos.below()).getBlock();
		if ((!(blockfeet instanceof BedBlock)) && (!(blockbelowfeet instanceof BedBlock))) {
			return;
		}
		
		player.setDeltaMovement(player.getDeltaMovement().add(0.0f, (float)ConfigHandler.bedBounciness, 0.0f));
		player.hurtMarked = true;
	}
	
	public static int onFall(Level world, Entity entity, float f, float g) {
		if (!ConfigHandler.bedsPreventFallDamage) {
			return 1;
		}
		
		if (world.isClientSide) {
			return 1;
		}
		
		if (!(entity instanceof Player)) {
			return 1;
		}
		
		BlockPos ppos = entity.blockPosition();
		Block blockfeet = world.getBlockState(ppos).getBlock();
		Block blockbelowfeet = world.getBlockState(ppos.below()).getBlock();
		if (blockfeet instanceof BedBlock || blockbelowfeet instanceof BedBlock) {
			return 0;
		}
		
		return 1;
	}
}
