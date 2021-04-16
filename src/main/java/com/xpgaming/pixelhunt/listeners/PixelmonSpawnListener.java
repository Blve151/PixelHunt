package com.xpgaming.pixelhunt.listeners;


import ca.landonjw.gooeylibs2.implementation.tasks.Task;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.xpgaming.pixelhunt.utils.Utils;
import net.minecraft.entity.Entity;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

public class PixelmonSpawnListener {

    @SubscribeEvent
    public void onPixelmonSpawn(EntityJoinWorldEvent event) {
        final Entity entity = event.getEntity();
        if (!(entity instanceof EntityPixelmon)) {
            return;
        }

        EntityPixelmon pixelmon = (EntityPixelmon) entity;

        if (pixelmon.hasOwner()) {
            return;
        }

        int isInHunt = Utils.getInstance().isInHunt(pixelmon.getPokemonData());
        if (isInHunt != 0) {
            Task.builder()
                    .execute(task -> {
                        if (pixelmon.isEntityAlive() && !pixelmon.hasOwner() && pixelmon.getPokemonData().getPixelmonIfExists() != null && Utils.getInstance().isInHunt(pixelmon.getPokemonData()) != 0) {
                            WorldServer worldServer = FMLServerHandler.instance().getServer().getWorld(entity.dimension);
                            worldServer.spawnParticle(EnumParticleTypes.FLAME, false, entity.posX, entity.posY, entity.posZ, 2, -1, -1, -1, 1.0);
                        } else {
                            task.setExpired();
                        }
                    })
                    .interval(10)
                    .infinite()
                    .build();
        }
    }
}
