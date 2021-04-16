package com.xpgaming.pixelhunt.utils;

import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.xpgaming.pixelhunt.PixelHuntForge;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.ArrayList;
import java.util.List;

import static com.xpgaming.pixelhunt.utils.Utils.*;

public class ButtonUtils {

    public static List<Button> getHuntButtons(EntityPlayerMP player) {
        List<Button> huntList = new ArrayList<>();


        Pokemon pokemon1 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon1));
        Pokemon pokemon2 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon2));
        Pokemon pokemon3 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon3));
        Pokemon pokemon4 = Pixelmon.pokemonFactory.create(EnumSpecies.getFromNameAnyCase(PixelHuntForge.pokemon4));


        Button pokeButton1 = GooeyButton.builder()
                .display(getPokemonPhoto(pokemon1))
                .title((regex("&6#1 &e" + sanitisePokemon(pokemon1.getSpecies().name))))
                .lore(getHuntInfo("nature1", "reward1", "expiry1"))
                .build();

        Button pokeButton2 = GooeyButton.builder()
                .display(getPokemonPhoto(pokemon2))
                .title((regex("&6#2 &e" + sanitisePokemon(pokemon2.getSpecies().name))))
                .lore(getHuntInfo("nature2", "reward2", "expiry2"))
                .build();

        Button pokeButton3 = GooeyButton.builder()
                .display(getPokemonPhoto(pokemon3))
                .title((regex("&6#3 &e" + sanitisePokemon(pokemon3.getSpecies().name))))
                .lore(getHuntInfo("nature3", "reward3", "expiry3"))
                .build();

        Button pokeButton4 = GooeyButton.builder()
                .display(getPokemonPhoto(pokemon4))
                .title((regex("&6#4 &e" + sanitisePokemon(pokemon4.getSpecies().name))))
                .lore(getHuntInfo("nature4", "reward4", "expiry4"))
                .build();

        huntList.add(pokeButton1);
        huntList.add(pokeButton2);
        huntList.add(pokeButton3);
        huntList.add(pokeButton4);

        return huntList;

    }
}
