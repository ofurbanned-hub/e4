package com.example.myclient.modules;

import com.example.myclient.core.Category;
import com.example.myclient.core.Module;

/** Registry entry for a feature whose full game hook has not been implemented yet. */
public final class BasicModule extends Module {
    public BasicModule(String name, Category category) { super(name, category, 0, false); }
}
