package com.example.myclient.core;
public final class NumberSetting extends Setting<Double> { public final double min,max,step; public NumberSetting(String n,double v,double min,double max,double step){super(n,v);this.min=min;this.max=max;this.step=step;} }
