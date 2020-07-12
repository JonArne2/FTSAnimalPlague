package de.jonarne.ftsanimalplague.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.Chunk;
import org.bukkit.entity.EntityType;

public class MobTameListener implements Listener {
	
	@EventHandler
	public void mobTame(EntityBreedEvent event) {
		EntityType entityTarget = event.getEntityType();
		if(entityTarget==EntityType.SHEEP) {
			Chunk chunk = event.getMother().getLocation().getChunk();
			int entitySize = chunk.getWorld().getEntities().size();
			if(entitySize>6) {
				chunk.getWorld().getEntities().
			}
		}
		
	}

}
