package com.chatguionly;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.client.Minecraft;

@Mod(modid = "chatguionly", name = "ChatGUIOnly", version = "1.0", clientSideOnly = true)
public class ChatGUIOnly {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Tắt render thế giới (block, entity, etc.) - chỉ giữ chat và hotbar
    @SubscribeEvent
    public void onRenderWorld(RenderWorldLastEvent event) {
        // Hủy bỏ render thế giới để ẩn hoàn toàn
        event.setCanceled(true);
    }

    // Tùy chỉnh overlay: chỉ hiển thị chat và hotbar, ẩn phần còn lại
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
        // Chỉ cho phép render chat và hotbar
        if (event.getType() != RenderGameOverlayEvent.ElementType.CHAT && 
            event.getType() != RenderGameOverlayEvent.ElementType.HOTBAR) {
            event.setCanceled(true);
        }
    }
}