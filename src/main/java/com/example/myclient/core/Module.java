package com.example.myclient.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    private final String name;
    private final Category category;
    private boolean enabled;
    private int key;
    private final boolean implemented;
    protected final List<Setting<?>> settings = new ArrayList<>();

    protected Module(String name, Category category, int key, boolean implemented) {
        this.name = name;
        this.category = category;
        this.key = key;
        this.implemented = implemented;
    }

    protected Module(String name, Category category, int key) { this(name, category, key, true); }
    protected Module(String name, Category category) { this(name, category, 0, false); }

    public String name() { return name; }
    public Category category() { return category; }
    public boolean enabled() { return enabled; }
    public int key() { return key; }
    public void key(int key) { this.key = key; }
    public boolean implemented() { return implemented; }
    public List<Setting<?>> settings() { return settings; }

    public final void toggle() { setEnabled(!enabled); }
    public final void setEnabled(boolean value) {
        if (!implemented && value) return;
        if (enabled == value) return;
        enabled = value;
        if (value) onEnable(); else onDisable();
    }
    public void onEnable() {}
    public void onDisable() {}
    public void tick() {}
}
