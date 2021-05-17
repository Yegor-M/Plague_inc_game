package com.company;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GenerateUUID generate = new GenerateUUID();
        Apartment apartment1 = new Apartment(78,generate.generate());
        Apartment apartment2 = new Apartment(360,generate.generate());
        Apartment apartment3 = new Apartment(40,generate.generate());
        Apartment apartment4 = new Apartment(65,generate.generate());
        Apartment apartment5 = new Apartment(12,generate.generate());
        Apartment apartment6 = new Apartment(350,generate.generate());
        Apartment apartment7 = new Apartment(205,generate.generate());
        Apartment apartment8 = new Apartment(260,generate.generate());
        Apartment apartment9 = new Apartment(132,generate.generate());
        Apartment apartment10 = new Apartment(90,generate.generate());


        Apartment[] apartments = {apartment1,apartment2,apartment3,apartment4,apartment5,apartment6,apartment7,apartment8,apartment9,apartment10};

        Tenant tenant1 = new Tenant("John",apartment1.uuid);
        Tenant tenant2 = new Tenant("Fred",apartment2.uuid);
        Tenant tenant3 = new Tenant("Lion",apartment3.uuid);
        Tenant tenant4 = new Tenant("Patrick",apartment4.uuid);
        Tenant tenant5 = new Tenant("John",apartment5.uuid);
        Tenant tenant6 = new Tenant("Fred",apartment6.uuid);
        Tenant tenant7 = new Tenant("Lion",apartment7.uuid);
        Tenant tenant8 = new Tenant("Patrick",apartment8.uuid);
        Tenant tenant9 = new Tenant("John",apartment9.uuid);
        Tenant tenant10 = new Tenant("Fred",apartment10.uuid);

        Tenant[] tenants = {tenant1,tenant2,tenant3,tenant4,tenant5,tenant6,tenant7,tenant8,tenant9,tenant10};

        ParkingPlace parkingPlace1 = new ParkingPlace(43,generate.generate());

        Person person1 = new Person("Kendrick","Lamar",1452,"Stalowa 12");
        Person person2 = new Person("Anton","Poznika",4345,"Stalowa 58");
        Person person3 = new Person("Ostap","Kuzmenko",67869,"Chuprynki 16");
        Person person4 = new Person("Oleh","Kilina",67896,"Sadova 8");

        Person[] persons = {person1,person2,person3,person4};

        Item item1 = new Item(2,"Skateboard");
        Item item2 = new Item(10,"Shelf");
        Item item3 = new Item(8,"Gift");
        Item item4 = new Item(13,"Tent");
        Item item5 = new Item(10,"Shelf");
        Item item6 = new Item(1,"Bag");
        Item item7 = new Item(11,"Desk");
        Item item8 = new Item(17,"Tent");
        Item item9 = new Item(9,"Shelf");
        Item item10 = new Item(5,"Shelf");
        Item item11 = new Item(9,"Snowboard");
        Item item12 = new Item(5,"Skies");


        Item[] items = {item1,item2,item3,item4,item5,item6,item7,item8,item9,item10};

        Vehicle vehicle1 = new Vehicle(2,"motorcycle",49,"four-stroke");
        Vehicle vehicle2 = new Vehicle(50,"off-road car",400,"big");

        tenant1.check(apartment1,person1);
        tenant2.check(apartment2,person1);
        tenant3.check(apartment3,person1);
        tenant4.check(apartment4,person2);
        tenant4.check(apartment5,person2);
        tenant4.check(apartment6,person2);
        tenant4.check(apartment7,person3);
        tenant4.check(apartment8,person3);
        tenant4.check(apartment9,person3);
        tenant4.check(apartment10,person4);

        tenant1.insert_item(item1,apartment1);
        tenant1.insert_item(item2,apartment1);
        tenant1.insert_item(item3,apartment1);

        tenant1.insert_item(item4,apartment2);
        tenant1.insert_item(item5,apartment2);
        tenant1.insert_item(item6,apartment2);

        tenant1.insert_item(item7,apartment3);
        tenant1.insert_item(item8,apartment3);
        tenant1.insert_item(item9,apartment3);

        tenant1.insert_item(item10,apartment4);
        tenant1.insert_item(item11,apartment4);
        tenant1.insert_item(item12,apartment4);

        tenant1.insert_item(item10,apartment5);
        tenant1.insert_item(item11,apartment5);
        tenant1.insert_item(item12,apartment5);

        tenant1.insert_item(item10,apartment6);
        tenant1.insert_item(item11,apartment6);
        tenant1.insert_item(item12,apartment6);

        tenant1.insert_item(item10,apartment7);
        tenant1.insert_item(item11,apartment7);
        tenant1.insert_item(item12,apartment7);

        tenant1.insert_item(item10,apartment8);
        tenant1.insert_item(item11,apartment8);
        tenant1.insert_item(item12,apartment8);

        tenant1.insert_item(item10,apartment9);
        tenant1.insert_item(item11,apartment9);
        tenant1.insert_item(item12,apartment9);

        tenant1.insert_item(item10,apartment10);
        tenant1.insert_item(item11,apartment10);
        tenant1.insert_item(item12,apartment10);

        tenant1.insert_vehicle(vehicle1,parkingPlace1);

        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        int input;
        String menu = "1.Show apartments with items\n2.Save to the file\n3.Quit";
        while(exit) {
            System.out.println(menu);
            input = scanner.nextInt();
            if (input == 3)
                exit = false;
            else if (input == 2){
                save_info(apartments, items);
            }
            else if (input == 1)
                System.out.println(show_all_apartments(apartments));
        }
    }

    public static String show_all_apartments(Apartment[] apartments) {
        String output = "";
        for (int i = 0; i < apartments.length;i++) {
            output += "Apartment id:" + apartments[i].uuid + ", Apartment volume:" +
                    apartments[i].volume + ", Apartment items:" + apartments[i].show_items(apartments[i]) + "\n";
        }
        return output;
    }

    public static void save_info(Apartment[] apartments,Item[] items) {
        String output = "";
        apartments = filter_aparts(apartments);
        for (int i = 0; i < apartments.length;i++) {
            output += "Apartment id:" + apartments[i].uuid + ", Apartment volume:" +
                    apartments[i].volume + ", Apartment items:" + apartments[i].show_items(apartments[i]) + "\n";
        }
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(output);
            System.out.println("Successfully saved to the file!");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Apartment[] filter_aparts(Apartment[] apartments) {
        float[] values = new float[apartments.length];
        Apartment[] sorted_apartments = new Apartment[apartments.length];
        Item[] items;
        for (int j = 0; j < apartments.length;j++) {
            values[j] = apartments[j].volume;
            apartments[j].items = filter_items(apartments[j].items);
        }
        Arrays.sort(values);
        for (int i = 0; i < values.length;i++) {
            for (int j = 0; j < apartments.length;j++) {
                if(values[i] == apartments[j].volume)
                    sorted_apartments[i] = apartments[j];
            }
        }
        return sorted_apartments;
    }

    public static Item[] filter_items(Item[] items) {
        float[] values = new float[items.length];
        Item[] sorted_items = new Item[items.length];
        for (int j = 0; j < items.length;j++) {
            if (items[j] == null)
                continue;
            values[j] = items[j].volume;
        }
        Arrays.sort(values);
        for (int i = 0; i < values.length;i++) {
            for (int j = 0; j < items.length;j++) {
                if(values[i] == items[j].volume)
                    sorted_items[i] = items[j];
            }
        }
        return sorted_items;
    }
}
