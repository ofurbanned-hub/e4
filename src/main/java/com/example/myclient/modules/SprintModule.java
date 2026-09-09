package com.example.myclient.modules;

import com.example.myclient.core.Category;
import com.example.myclient.core.Module;
import net.minecraft.client.MinecraftClient;

public final class SprintModule extends Module {
    public SprintModule() { super("Sprint", Category.MOVEMENT, 0, true); }
    @Override public void tick() {
        MinecraftClient c = MinecraftClient.getInstance();
        if (c.player != null && !c.player.isSneaking() && c.player.getHungerManager().getFoodLevel() > 6) c.player.setSprinting(true);
    }
}
