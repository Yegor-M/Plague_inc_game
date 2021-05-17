package com.company;

import java.util.UUID;

public class Apartment extends Room {
    public Item[] items;
    public Apartment(float volume, UUID uuid) {
        super(volume,uuid);
        items = new Item[3];
    }

    public void add_item(Apartment apartment,Item item) {
        for (int i = 0; i < apartment.items.length; i++) {
            if (apartment.items[i] == null) {
                apartment.items[i] = item;
                break;
            }
        }
    }

    public void delete_item(Apartment apartment,Item item) {
        for (int i = 0; i < apartment.items.length; i++) {
            if (apartment.items[i] == item) {
                apartment.items[i] = null;
                break;
            }
        }
    }

    public String show_items(Apartment apartment) {
        String output = "";
        for (int i = 0;i < apartment.items.length;i++) {
            output += apartment.items[i].name + " and size is " + apartment.items[i].volume + "; ";
        }
        return output;
    }
}
