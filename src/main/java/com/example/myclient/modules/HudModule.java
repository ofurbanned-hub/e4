package com.example.myclient.modules;

import com.example.myclient.core.Category;
import com.example.myclient.core.Module;
import com.example.myclient.core.ModuleManager;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public final class HudModule extends Module {
    public HudModule() { super("HUD", Category.RENDER, 0, true); }
    public void register() {
        HudRenderCallback.EVENT.register((ctx, tickDelta) -> {
            if (!enabled()) return;
            int y = 5;
            MinecraftClient client = MinecraftClient.getInstance();
            for (Module m : ModuleManager.all()) {
                if (!m.enabled() || m == this) continue;
                ctx.drawTextWithShadow(client.textRenderer, Text.literal(m.name()), 5, y, 0xFF66CCFF);
                y += 10;
            }
        });
    }
}
