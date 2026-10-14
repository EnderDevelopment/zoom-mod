package com.example.zoommod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "zoommod", value = Dist.CLIENT)
public class ZoomEventHandler {
    private static boolean isZoomed = false;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            if (event.getKey() == 46 && event.getAction() == 1) { // C key
                isZoomed = !isZoomed;
                if (isZoomed) {
                    mc.gameSettings.fov = 30.0F;
                } else {
                    mc.gameSettings.fov = 70.0F;
                }
            }
        }
    }
}