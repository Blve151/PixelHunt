package com.xpgaming.pixelhunt;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.xpgaming.pixelhunt.commands.HuntCMD;
import com.xpgaming.pixelhunt.listeners.CaptureListener;
import com.xpgaming.pixelhunt.listeners.PixelmonSpawnListener;
import com.xpgaming.pixelhunt.utils.Utils;
import info.pixelmon.repack.ninja.leaping.configurate.commented.CommentedConfigurationNode;
import info.pixelmon.repack.ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import info.pixelmon.repack.ninja.leaping.configurate.loader.ConfigurationLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Mod(
        modid = PixelHuntForge.MOD_ID,
        name = PixelHuntForge.MOD_NAME,
        version = PixelHuntForge.VERSION,
        acceptableRemoteVersions = "*",
        dependencies = "required-after:pixelmon;required-after:gooeylibs2"
)
public class PixelHuntForge {

    public static final String MOD_ID = "pixelhuntforge";
    public static final String MOD_NAME = "PixelHuntForge";
    public static final String VERSION = "2.0.1";

    private static final String separator = FileSystems.getDefault().getSeparator();
    public static String primaryPath = "config" + separator;
    public static String commandConfigPath = "config" + separator + "PixelHunt" + separator;
    public static Path configPath = Paths.get(primaryPath, "PixelHunt.conf");

    public static ConfigurationLoader<CommentedConfigurationNode> primaryConfigLoader =
            HoconConfigurationLoader.builder().setPath(configPath).build();

    String path = "config" + File.separator + "PixelHunt";

    File configFile = new File(path, "PixelHunt.conf");
    ConfigurationLoader<CommentedConfigurationNode> configLoader = HoconConfigurationLoader.builder().setFile(configFile).build();

    public static String pokemon1 = "", nature1 = "", nature1b = "", nature1c = "";
    public static String pokemon2 = "", nature2 = "", nature2b = "", nature2c = "";
    public static String pokemon3 = "", nature3 = "", nature3b = "", nature3c = "";
    public static String pokemon4 = "", nature4 = "", nature4b = "", nature4c = "";
    public static LocalDateTime pokemon1expiry, pokemon2expiry, pokemon3expiry, pokemon4expiry;
    public static String pokemon1ballName, pokemon2ballName, pokemon3ballName, pokemon4ballName;
    public static ItemStack pokemon1ballReward, pokemon2ballReward, pokemon3ballReward, pokemon4ballReward;
    public static ItemStack pokemon1rc, pokemon2rc, pokemon3rc, pokemon4rc;
    public static String pokemon1msg, pokemon2msg, pokemon3msg, pokemon4msg;
    public static int pokemon1moneyReward;
    public static int pokemon2moneyReward;
    public static int pokemon3moneyReward;
    public static int pokemon4moneyReward;
    public static MinecraftServer server;


    @Mod.Instance(MOD_ID)
    public static PixelHuntForge INSTANCE;

    public static PixelHuntForge getInstance() {
        return INSTANCE;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Pixelmon.EVENT_BUS.register(new CaptureListener());
        Pixelmon.EVENT_BUS.register(new PixelmonSpawnListener());
        MinecraftForge.EVENT_BUS.register(new PixelmonSpawnListener());
        Config.getInstance().setup(configFile, configLoader);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        server = FMLServerHandler.instance().getServer();
        System.out.println("§f[§6xP//§f] §ePixelHunt - Loaded v" + VERSION);
        System.out.println("§f[§6xP//§f] §eBy Xenoyia with help from happyzlife, FrostEffects and XpanD!");
        System.out.println("§f[§6xP//§f] §ePorted to Forge by Blue.");
    }

    @Mod.EventHandler
    public void init(FMLServerStartingEvent event) {
        Utils.getInstance().initialisePokemon();
        Utils.reloadAnnouncementTask();
        event.registerServerCommand(new HuntCMD());
    }

}

