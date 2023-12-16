package com.teampotato.blueskiescustomization;

import com.teampotato.blueskiescustomization.common.config.PotatoCommonConfig;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.ModLoadingStage;
import net.minecraftforge.fml.ModLoadingWarning;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BlueSkiesCustomization.ID)
public class BlueSkiesCustomization {
    public static final String ID = "blueskiescustomization";

    public static final Logger LOGGER = LogManager.getLogger(ID);

    public BlueSkiesCustomization() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PotatoCommonConfig.COMMON_CONFIG);
        FMLLoader.getLoadingModList().getModFiles().forEach(modInfo -> LOGGER.info("Opotato: Mod " + modInfo.getFile().getFileName() + " loaded!"));
    }

    public static boolean isLoaded(String modID) {
        return FMLLoader.getLoadingModList().getModFileById(modID) != null;
    }

    public static void addIncompatibleWarn(FMLCommonSetupEvent event, String translationKey) {
        event.enqueueWork(() -> ModLoader.get().addWarning(new ModLoadingWarning(ModLoadingContext.get().getActiveContainer().getModInfo(), ModLoadingStage.COMMON_SETUP, translationKey)));
    }
}
