package com.example.myclient.modules;

import com.example.myclient.core.Category;
import com.example.myclient.core.Module;
import net.minecraft.client.MinecraftClient;

public final class FullbrightModule extends Module {
    private double old = 1.0;
    public FullbrightModule() { super("Fullbright", Category.RENDER, 0, true); }
    @Override public void onEnable() {
        MinecraftClient c = MinecraftClient.getInstance();
        if (c.options != null) { old = c.options.getGamma().getValue(); c.options.getGamma().setValue(16.0); }
    }
    @Override public void onDisable() {
        MinecraftClient c = MinecraftClient.getInstance();
        if (c.options != null) c.options.getGamma().setValue(old);
    }
}
