package com.company;

public class Person {
    public String name;
    public String surname;
    public int pesel;
    public String adress;
    public Apartment[] apartments;
    public ParkingPlace[] parkingPlaces;
    public TenantLetter[] letters;

    public Person(String name,String surname, int pesel, String adress) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.adress = adress;
        apartments = new Apartment[3];
        parkingPlaces = new ParkingPlace[2];
        letters = new TenantLetter[3];
    }

    public String rooms() {
        String output = "";
        for (int i = 0; i < apartments.length; i++) {
            output += apartments[i].uuid +":" + apartments[i].volume +"\n";
        }
        return output;
    }

    public String show_all(Person[] all) {
        String output = "";
        for (int i = 0; i < all.length;i++) {
            output += all[i].name + all[i].surname;
        }
        return output;
    }
}
