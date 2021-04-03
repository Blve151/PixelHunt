package com.xpgaming.pixelhunt.ui;

import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.button.PlaceholderButton;
import ca.landonjw.gooeylibs2.api.helpers.PaginationHelper;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.LinkedPage;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;

import com.xpgaming.pixelhunt.Config;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Collections;

import static com.xpgaming.pixelhunt.utils.ButtonUtils.getHuntButtons;
import static com.xpgaming.pixelhunt.utils.Utils.*;

public class HuntUI {


    public static GooeyPage menu (EntityPlayerMP player){

        PlaceholderButton placeholder = new PlaceholderButton();

        Button book = GooeyButton.builder()
                .display(new ItemStack(Items.BOOK))
                .title(regex(Config.getInstance().getConfig().getNode("pixelhunt","gui","gui-book-display").getString()))
                .lore(Collections.singletonList(regex(Config.getInstance().getConfig().getNode("pixelhunt","gui","gui-book-text").getString())))
                .build();

        ChestTemplate template = ChestTemplate.builder(3)
                .checker(0, 0, 3, 9, colouredPane(getButtonPos("gui-glass-pane", 1)), colouredPane(getButtonPos("gui-glass-pane", 2)))
                .rectangle(1, 2, 1, 4, placeholder)
                .set(1, 6, book)
                .build();

        LinkedPage.Builder pageBuilder = LinkedPage.builder()
                .title(regex(Config.getInstance().getConfig().getNode("pixelhunt","gui","gui-title").getString()));

        return PaginationHelper.createPagesFromPlaceholders(template, getHuntButtons(player), pageBuilder);
    }

}
