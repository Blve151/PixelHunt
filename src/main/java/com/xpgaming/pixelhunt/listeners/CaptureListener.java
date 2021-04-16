package com.xpgaming.pixelhunt.listeners;


import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Stats;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.xpgaming.pixelhunt.Config;
import com.xpgaming.pixelhunt.PixelHuntForge;
import com.xpgaming.pixelhunt.utils.Utils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

import static com.xpgaming.pixelhunt.utils.Utils.*;


public class CaptureListener {
    @SubscribeEvent
    public void onPokemonCapture(CaptureEvent.SuccessfulCapture event) {
        EntityPlayerMP p = event.player;
        EntityPixelmon e = event.getPokemon();
        Pokemon pokemon = event.getPokemon().getPokemonData();

        Pokemon pokemon1 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon1));
        Pokemon pokemon2 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon2));
        Pokemon pokemon3 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon3));
        Pokemon pokemon4 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon4));


        Stats stats = pokemon.getStats();
        int oldIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
        if (pokemon.getSpecies() == pokemon1.getSpecies()) {
            if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature1)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon1ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon1rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon1), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon1moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon1moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(1);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon1);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature1b)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon1ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon1rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon1), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon1moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon1moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(1);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon1);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature1c)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon1ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon1rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon1), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon1moneyReward);
                    sendPlayer(p,Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon1moneyReward + " coins\u00A76!" );
                }
                Utils.getInstance().randomisePokemon(1);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon1);
            } else {
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "increase-ivs").getBoolean())
                    increaseWildIVs(e, p);
                sendPlayer(p, Utils.prefix() + " \u00A7fThis one isn't right.. keep hunting!");
            }
        } else if (pokemon.getSpecies() == pokemon2.getSpecies()) {
            if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature2)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon2ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon2rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon2), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon2moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon2moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(2);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon2);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature2b)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon2ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon2rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon2), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon2moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon2moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(2);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon2);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature2c)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon2ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon2rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon2), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon2moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon2moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(2);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon2);
            } else {
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "increase-ivs").getBoolean())
                    increaseWildIVs(e, p);
                sendPlayer(p, Utils.prefix() + " \u00A7fThis one isn't right.. keep hunting!");
            }
        } else if (pokemon.getSpecies() == pokemon3.getSpecies()) {
            if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature3)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon3ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon3rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon3), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon3moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon3moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(3);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon3);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature3b)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon3ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon3rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon3), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon3moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon3moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(3);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon3);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature3c)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon3ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon3rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon3), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon3moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon3moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(3);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon3);
            } else {
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "increase-ivs").getBoolean())
                    increaseWildIVs(e, p);
                sendPlayer(p, Utils.prefix() + " \u00A7fThis one isn't right.. keep hunting!");
            }
        } else if (pokemon.getSpecies() == pokemon4.getSpecies()) {
            if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature4)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon4ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon4rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon4), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon4moneyReward);
                    sendPlayer(p,Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon4moneyReward + " coins\u00A76!" );
                }
                Utils.getInstance().randomisePokemon(4);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon4);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature4b)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon4ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon4rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon4), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon4moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon4moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(4);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon4);
            } else if (pokemon.getNature().toString().equalsIgnoreCase(PixelHuntForge.nature4c)) {
                sendServer(Utils.prefix() + " \u00A7a" + p.getName() + " \u00A7fcaught a \u00A7a/hunt\u00A7f Pok\u00E9mon! " + "\u00A7f(\u00A7a" + pokemon.getNature() + " " + e.getName() + "\u00A7f)");
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "max-ivs").getBoolean()) {
                    increaseIVs(e, p);
                    int newIVs = stats.ivs.specialAttack + stats.ivs.hp + stats.ivs.specialDefence + stats.ivs.defence + stats.ivs.speed + stats.ivs.attack;
                    sendPlayer(p, Utils.prefix() + " \u00A7fIVs changed from \u00A7a" + oldIVs + " \u00A7fto \u00A7a" + newIVs + "\u00A7f!");
                }
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-balls").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon4ballReward, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-candy").getBoolean())
                    Utils.giveItemStack(PixelHuntForge.pokemon4rc, p);
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "custom-toggle").getBoolean())
                    Utils.getInstance().executeCommand(Utils.getInstance().getRarity(PixelHuntForge.pokemon4), p.getName());
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "give-money").getBoolean()) {
                    Utils.addMoney(p, PixelHuntForge.pokemon4moneyReward);
                    sendPlayer(p, Utils.prefix() + " \u00A76You have been given \u00A7e" + PixelHuntForge.pokemon4moneyReward + " coins\u00A76!");
                }
                Utils.getInstance().randomisePokemon(4);
                sendServer(Utils.prefix() + " \u00A7fNew hunted Pok\u00E9mon is: \u00A7a" + PixelHuntForge.pokemon4);
            } else {
                if (Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "increase-ivs").getBoolean())
                    increaseWildIVs(e, p);
                sendPlayer(p, Utils.prefix() + " \u00A7fThis one isn't right.. keep hunting!");
            }
        }
    }

    public void increaseWildIVs(EntityPixelmon e, EntityPlayerMP p) {
        Pokemon pokemon = e.getPokemonData();
        Stats stats = pokemon.getStats();
        double multiplier = Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "iv-multiplier").getDouble();
        if (Utils.getUncommonPokemon().contains(e.getName()) || Utils.getRarePokemon().contains(e.getName()))
            multiplier = Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "rare-iv-multiplier").getDouble();
        stats.ivs.hp = (int) Math.ceil(stats.ivs.hp * multiplier);
        if (stats.ivs.hp > 31) stats.ivs.hp = 31;
        stats.ivs.attack = (int) Math.ceil(stats.ivs.attack * multiplier);
        if (stats.ivs.attack > 31) stats.ivs.attack = 31;
        stats.ivs.defence = (int) Math.ceil(stats.ivs.defence * multiplier);
        if (stats.ivs.defence > 31) stats.ivs.defence = 31;
        stats.ivs.specialAttack = (int) Math.ceil(stats.ivs.specialAttack * multiplier);
        if (stats.ivs.specialAttack > 31) stats.ivs.specialAttack = 31;
        stats.ivs.specialDefence = (int) Math.ceil(stats.ivs.specialDefence * multiplier);
        if (stats.ivs.specialDefence > 31)
            stats.ivs.specialDefence = 31;
        stats.ivs.speed = (int) Math.ceil(stats.ivs.speed * multiplier);
        if (stats.ivs.speed > 31) stats.ivs.speed = 31;
        e.updateStats();
        if (Utils.getUncommonPokemon().contains(e.getName()) || Utils.getRarePokemon().contains(e.getName()))
            sendPlayer(p, Utils.prefix() + " \u00A7fThis rare \u00A7a" + e.getName() + "\u00A7f received an increase in IVs\u00A7f!");
        else
            sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received an increase in IVs\u00A7f!");
    }

    public void increaseIVs(EntityPixelmon e, EntityPlayerMP p) {
        Pokemon pokemon = e.getPokemonData();
        Stats stats = pokemon.getStats();
        int natureNum = pokemon.getNature().index;
        switch (natureNum) {
            case 5:
                stats.ivs.attack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed attack IVs\u00A7f!");
                break;
            case 6:
                stats.ivs.attack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed attack IVs\u00A7f!");
                break;
            case 7:
                stats.ivs.attack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed attack IVs\u00A7f!");
                break;
            case 8:
                stats.ivs.attack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed attack IVs\u00A7f!");
                break;
            case 9:
                stats.ivs.defence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed defence IVs\u00A7f!");
                break;
            case 10:
                stats.ivs.defence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed defence IVs\u00A7f!");
                break;
            case 11:
                stats.ivs.defence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed defence IVs\u00A7f!");
                break;
            case 12:
                stats.ivs.defence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed defence IVs\u00A7f!");
                break;
            case 13:
                stats.ivs.speed = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed speed IVs\u00A7f!");
                break;
            case 14:
                stats.ivs.speed = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed speed IVs\u00A7f!");
                break;
            case 15:
                stats.ivs.speed = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed speed IVs\u00A7f!");
                break;
            case 16:
                stats.ivs.speed = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed speed IVs\u00A7f!");
                break;
            case 17:
                stats.ivs.specialAttack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. attack IVs\u00A7f!");
                break;
            case 18:
                stats.ivs.specialAttack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. attack IVs\u00A7f!");
                break;
            case 19:
                stats.ivs.specialAttack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. attack IVs\u00A7f!");
                break;
            case 20:
                stats.ivs.specialAttack = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. attack IVs\u00A7f!");
                break;
            case 21:
                stats.ivs.specialDefence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. defence IVs\u00A7f!");
                break;
            case 22:
                stats.ivs.specialDefence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. defence IVs\u00A7f!");
                break;
            case 23:
                stats.ivs.specialDefence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. defence IVs\u00A7f!");
                break;
            case 24:
                stats.ivs.specialDefence = 31;
                e.updateStats();
                sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received \u00A7amaxed sp. defence IVs\u00A7f!");
                break;
            default:
                double multiplier = Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "rare-iv-multiplier").getDouble();
                if (Utils.getUncommonPokemon().contains(e.getName()) || Utils.getRarePokemon().contains(e.getName()))
                    multiplier = Config.getInstance().getConfig().getNode("pixelhunt", "rewards", "rare-correct-iv-multiplier").getDouble();
                stats.ivs.hp = (int) Math.ceil(stats.ivs.hp * multiplier);
                if (stats.ivs.hp > 31) stats.ivs.hp = 31;
                stats.ivs.attack = (int) Math.ceil(stats.ivs.attack * multiplier);
                if (stats.ivs.attack > 31) stats.ivs.attack = 31;
                stats.ivs.defence = (int) Math.ceil(stats.ivs.defence * multiplier);
                if (stats.ivs.defence > 31) stats.ivs.defence = 31;
                stats.ivs.specialAttack = (int) Math.ceil(stats.ivs.specialAttack * multiplier);
                if (stats.ivs.specialAttack > 31)
                    stats.ivs.specialAttack = 31;
                stats.ivs.specialDefence = (int) Math.ceil(stats.ivs.specialDefence * multiplier);
                if (stats.ivs.specialDefence > 31)
                    stats.ivs.specialDefence = 31;
                stats.ivs.speed = (int) Math.ceil(stats.ivs.speed * multiplier);
                if (stats.ivs.speed > 31) stats.ivs.speed = 31;
                e.updateStats();
                if (Utils.getUncommonPokemon().contains(e.getName()) || Utils.getRarePokemon().contains(e.getName()))
                    sendPlayer(p, Utils.prefix() + " \u00A7fThis rare \u00A7a" + e.getName() + "\u00A7f received an increase in IVs\u00A7f!");
                else
                    sendPlayer(p, Utils.prefix() + " \u00A7fThis \u00A7a" + e.getName() + "\u00A7f received an increase in IVs\u00A7f!");
                break;
        }

    }
}
