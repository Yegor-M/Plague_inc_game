package com.company;
import java.util.UUID;
import java.util.Date;


public class Room {
    public float volume;
    public UUID uuid;
    public boolean cleaned;
    public String  start_date;
    public String  end_date;

    public Room(float volume,UUID uuid) {
        this.uuid = uuid;
        this.volume = volume;
        cleaned = true;
    }
}
