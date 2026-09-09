package com.example.myclient.core;
public final class BooleanSetting extends Setting<Boolean> { public BooleanSetting(String n, boolean v){super(n,v);} public void toggle(){set(!get());} }
