package com.example.myclient.core;
public abstract class Setting<T> {
    private final String name; private T value;
    protected Setting(String name, T value) { this.name=name; this.value=value; }
    public String name(){return name;} public T get(){return value;} public void set(T v){value=v;}
}
