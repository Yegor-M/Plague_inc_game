package com.company;

public class Vehicle {
    public float volume;
    public String type;
    public int engine_capacity;
    public String engine_type;

    public Vehicle(float volume,String type, int engine_capacity, String engine_type) {
        this.volume = volume;
        this.type = type;
        this.engine_capacity = engine_capacity;
        this.engine_type = engine_type;
    }
}
