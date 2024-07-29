package me.mixces.legarity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

public class Legarity implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Legarity");

	@Override
	public void init() {
		LOGGER.info("initializing example mod!");
	}
}
