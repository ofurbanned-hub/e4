package com.example.myclient.core;

import com.example.myclient.modules.BasicModule;
import com.example.myclient.modules.FullbrightModule;
import com.example.myclient.modules.HudModule;
import com.example.myclient.modules.SprintModule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ModuleManager {
    private static final List<Module> MODULES = new ArrayList<>();
    private ModuleManager() {}

    public static void init() {
        MODULES.clear();
        add(new SprintModule());
        add(new FullbrightModule());
        add(new HudModule());

        String[][] modules = {
            // PLAYER
            {"NoEntityInteract","PLAYER"},{"AutoRespawn","PLAYER"},{"ChestStealer","PLAYER"},{"GhostHand","PLAYER"},{"AntiHunger","PLAYER"},{"NoRotate","PLAYER"},{"NoSwing","PLAYER"},{"AutoTool","PLAYER"},{"Freecam","PLAYER"},{"AutoFish","PLAYER"},{"Scaffold","PLAYER"},{"XCarry","PLAYER"},{"Sneak","PLAYER"},{"Timer","PLAYER"},{"Blink","PLAYER"},
            // MOVEMENT
            {"MoveClickBypass","MOVEMENT"},{"InventoryMove","MOVEMENT"},{"NoJumpDelay","MOVEMENT"},{"NoSlowDown","MOVEMENT"},{"EntityControl","MOVEMENT"},{"StairsSpeed","MOVEMENT"},{"WaterWalk","MOVEMENT"},{"FastAccel","MOVEMENT"},{"SafeWalk","MOVEMENT"},{"FastStop","MOVEMENT"},{"NoPush","MOVEMENT"},{"Spider","MOVEMENT"},{"NoFall","MOVEMENT"},{"Strafe","MOVEMENT"},{"Step","MOVEMENT"},{"Fly","MOVEMENT"},
            // COMBAT
            {"Aim Assist","COMBAT"},{"Anchor Macro","COMBAT"},{"Auto Double Hand","COMBAT"},{"Auto Crystal","COMBAT"},{"Auto Hit Crystal","COMBAT"},{"Auto Inv Totem","COMBAT"},{"Auto Jump Reset","COMBAT"},{"Auto Totem","COMBAT"},{"Crystal Optimizer","COMBAT"},{"Double Anchor","COMBAT"},{"Elytra Swap","COMBAT"},{"Hitbox","COMBAT"},{"Hover Totem","COMBAT"},{"Totem Offhand","COMBAT"},{"Mace Swap","COMBAT"},{"Spear Swap","COMBAT"},{"No Hit Delay","COMBAT"},{"Shield Breaker","COMBAT"},{"Static Hitboxes","COMBAT"},{"Trigger Bot","COMBAT"},{"Mace Bomber","COMBAT"},{"ClickAimAssist","COMBAT"},{"CobwebPlacer","COMBAT"},{"AntiMisclick","COMBAT"},{"AutoClicker","COMBAT"},{"AutoArmor","COMBAT"},{"AutoShoot","COMBAT"},{"Misplace","COMBAT"},{"Velocity","COMBAT"},{"Teams","COMBAT"},{"Reach","COMBAT"},{"WTap","COMBAT"},
            // MISC
            {"Auto Walk","MISC"},{"Auto Eat","MISC"},{"Auto Firework","MISC"},{"Auto Log","MISC"},{"Auto Loot","MISC"},{"Auto Mine","MISC"},{"Auto TPA","MISC"},{"Cord Snapper","MISC"},{"Elytra Glide","MISC"},{"Fast Place","MISC"},{"Freecam","MISC"},{"Key Pearl","MISC"},{"Key Wind Charge","MISC"},{"Skin Protect","MISC"},{"Auto Reconnect","MISC"},{"Weather Notifier","MISC"},{"NoFriendDamage","MISC"},{"NoChangeHotbar","MISC"},{"CooldownSync","MISC"},{"KeybindFriend","MISC"},{"LegitCrosshair","MISC"},{"ClientSpoofer","MISC"},{"KeybindPearl","MISC"},{"ItemScroller","MISC"},{"AutoLeave","MISC"},{"PingSpoof","MISC"},{"StaticFOV","MISC"},{"PortalFix","MISC"},
            // DONUT
            {"Anti Trap","DONUT"},{"Auction Sniper","DONUT"},{"Auto Sell","DONUT"},{"Auto Spawner Sell","DONUT"},{"Fake Pay","DONUT"},{"Item Dropper","DONUT"},{"Netherite Finder","DONUT"},{"RTP Base Finder","DONUT"},{"Auto Shulker Buy","DONUT"},{"Auto Shop","DONUT"},{"Tunnel Base Finder","DONUT"},{"Fake Stats","DONUT"},{"Spawner Protect","DONUT"},{"Chunk Finder","DONUT"},{"Prime Chunk Finder","DONUT"},{"Block Entity Debug","DONUT"},{"Player Chunks","DONUT"},
            // BASEFINDING
            {"Seed Chunk Finder","BASEFINDING"},{"Hole ESP","BASEFINDING"},{"Light Finder","BASEFINDING"},{"S16 Chunk Finder","BASEFINDING"},{"Sus Suspicious ESP","BASEFINDING"},
            // RENDER
            {"Name Tags","RENDER"},{"Ore Sim","RENDER"},{"Player ESP","RENDER"},{"Storage ESP","RENDER"},{"Block ESP","RENDER"},{"Target HUD","RENDER"},{"RealHitbox","RENDER"},{"Free Look","RENDER"},{"Spotify HUD","RENDER"},{"Pearl Trajectory","RENDER"},{"Mob ESP","RENDER"},{"NoBadEffects","RENDER"},{"NameProtect","RENDER"},{"LogoutSpots","RENDER"},{"NoHurtCam","RENDER"},{"NoOverlay","RENDER"},{"ItemESP","RENDER"},{"Terminal","RENDER"},{"AntiInvis","RENDER"},{"Tracers","RENDER"},{"Chams","RENDER"},{"Xray","RENDER"},{"ESP","RENDER"},{"GUI","RENDER"},
            // WORLD
            {"SaverBreakBlock","WORLD"},{"NoGlitchBlock","WORLD"},{"PacketBreak","WORLD"},{"WorldTime","WORLD"},{"BlockFixer","WORLD"},{"FastBreak","WORLD"},{"FastPlace","WORLD"},{"AutoMine","WORLD"},{"Weather","WORLD"},{"Nuker","WORLD"},
            // CLIENT
            {"Krypton+","CLIENT"},{"Chat Macro","CLIENT"},{"Radio","CLIENT"},{"Friends","CLIENT"},{"Discord Presence","CLIENT"},{"Proxy","CLIENT"}
        };
        for (String[] m : modules) {
            if (find(m[0]) == null) add(new BasicModule(m[0], Category.valueOf(m[1])));
        }
    }

    private static void add(Module m) { MODULES.add(m); }
    public static List<Module> all() { return MODULES; }
    public static List<Module> category(Category c) { return MODULES.stream().filter(m -> m.category() == c).collect(Collectors.toList()); }
    public static Module find(String name) { return MODULES.stream().filter(m -> m.name().equalsIgnoreCase(name)).findFirst().orElse(null); }
    public static void tick() { for (Module m : MODULES) if (m.enabled()) m.tick(); }
    public static void handleKey(int key) { for (Module m : MODULES) if (m.key() != 0 && m.key() == key) m.toggle(); }
}
