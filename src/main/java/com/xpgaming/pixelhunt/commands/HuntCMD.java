package com.xpgaming.pixelhunt.commands;

import ca.landonjw.gooeylibs2.api.UIManager;
import com.xpgaming.pixelhunt.Config;
import com.xpgaming.pixelhunt.ui.HuntUI;
import com.xpgaming.pixelhunt.utils.Utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.xpgaming.pixelhunt.utils.Utils.regex;

public class HuntCMD extends CommandBase {
    @Override
    public String getName() {
        return "hunt";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return sender.canUseCommand(0, "pixelhunt.command.admin") ? "/hunt (reload)/(newhunt (slot))" : "/hunt";
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> possibleArgs = new ArrayList<>();
        if(args.length == 1){
            if(sender.canUseCommand(0, "pixelhunt.command.admin")){
                possibleArgs.add("reload");
            }
            if(sender.canUseCommand(0, "pixelhunt.command.admin")){
                possibleArgs.add("newhunt");
            }
        }

        if(args.length == 2){
            if(sender.canUseCommand(0, "pixelhunt.command.admin")){
                possibleArgs.add("1");
                possibleArgs.add("2");
                possibleArgs.add("3");
                possibleArgs.add("4");
            }
        }

        return possibleArgs;

    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(args.length < 1){
            if(!(sender instanceof EntityPlayerMP)){
                sender.sendMessage(new TextComponentString(regex(Utils.lang("only-players"))));
                return;
            }
            EntityPlayerMP player = (EntityPlayerMP) sender;
            UIManager.openUIForcefully(player, HuntUI.menu(player));
        }else{
            if(!sender.canUseCommand(0, "pixelhunt.command.admin")){
                sender.sendMessage(new TextComponentString(regex(Utils.lang("invalid-usage"))));
                sender.sendMessage(new TextComponentString(getUsage(sender)));
                return;
            }
            switch (args[0]){
                case "reload":
                    Config.getInstance().configLoad();
                    Utils.reloadAnnouncementTask();
                    sender.sendMessage(new TextComponentString(regex(Utils.prefix() +  regex(Config.getInstance().getConfig().getNode("pixelhunt","lang","reload-message").getString()))));
                    break;
                case "newhunt":
                    if(args.length < 2){
                        Utils.getInstance().initialisePokemon();
                        sender.sendMessage(new TextComponentString(regex(Utils.prefix() + Utils.lang("all-random"))));
                        return;
                    }

                    int slot;
                    boolean valid = true;

                    try{
                        slot = Integer.parseInt(args[1]);
                        if(slot > 0 && slot < 5) {
                            Utils.getInstance().randomisePokemon(slot);
                            sender.sendMessage(new TextComponentString(regex(Utils.prefix() + Utils.lang("selected-random"))));
                        }else{
                            valid = false;
                        }
                    }catch (Exception ex){
                        valid = false;
                    }

                    if(!valid){
                        sender.sendMessage(new TextComponentString(regex(Utils.prefix() + Utils.lang("invalid-select"))));
                    }
                    break;
                default:
                    sender.sendMessage(new TextComponentString(regex(Utils.lang("invalid-usage"))));
                    sender.sendMessage(new TextComponentString(getUsage(sender)));
                    break;
            }
        }

    }
}
