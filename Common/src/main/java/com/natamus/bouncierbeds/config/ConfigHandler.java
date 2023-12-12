package com.natamus.bouncierbeds.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.bouncierbeds.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean bedsPreventFallDamage = true;
	@Entry(min = 0.0, max = 100.0) public static double bedBounciness = 1.5;

	public static void initConfig() {
		configMetaData.put("bedsPreventFallDamage", Arrays.asList(
			"Whether beds should prevent fall damage when a player lands on them. It's recommended to keep this enabled if you have lots of bounciness."
		));
		configMetaData.put("bedBounciness", Arrays.asList(
			"The modifier of how much a bed bounces. A value of 2.0 makes the player jump around 30 blocks. A value of 100.0 makes the player jump around 4500 blocks."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}