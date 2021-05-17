package com.company;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.Date;

public class Tenant {
    public String name;
    public UUID apartment_id;

    public Tenant(String name,UUID apartment_id) {
        this.name = name;
        this.apartment_id = apartment_id;
    }

    public void check(Apartment apartment,Person person) throws ProblematicTenantException {
        int busy = 0;
        if (check_for_letters(person)) {
            for (int i = 0; i < person.apartments.length; i++) {
                if (person.apartments[i] == null) {
                    person.apartments[i] = apartment;
                    set_date(apartment);
                    break;
                }
                else busy += 1;
            }
            if (busy > 2)
                throw new ProblematicTenantException("ALL APARTMENTS ARE BUSY");
        }
        else
            throw new ProblematicTenantException("Person " + person.name + "had already renting rooms:" + person.rooms());
    }

    public boolean check_for_letters(Person person) {
        int allow = 0;
        for (int i = 0; i < person.letters.length;i++) {
            if (person.letters[i] == null)
                allow += 1;
        }
        if (allow > 0)
            return true;
        else
            return false;
    }

    public void set_date(Apartment apartment) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        apartment.start_date = sdf.format(c.getTime());
        c.add(Calendar.DATE, 7);
        apartment.end_date = sdf.format(c.getTime());
    }

    public void uncheck(Apartment apartment,Person person) {
        for(int i = 0; i < person.apartments.length; i++) {
            if (person.apartments[i] == apartment) {
                person.apartments[i] = null;
                break;
            }
        }
    }

    public void insert_item(Item item,Apartment apartment) throws TooManyThingsException {
        if (apartment.volume - item.volume > 0 ) {
            apartment.add_item(apartment, item);
        }
        else
            throw new TooManyThingsException("Remove some old items to insert a new item");
    }

    public void insert_vehicle(Vehicle vehicle,ParkingPlace parkingPlace) throws TooManyThingsException {
        if (parkingPlace.volume - vehicle.volume > 0 )
            parkingPlace.volume -= vehicle.volume;
        else
            throw new TooManyThingsException("Remove some old items to insert a new item");
    }

    public void take_out_item(Item item,Apartment apartment) {
        apartment.delete_item(apartment,item);
    }

    public void take_out_vehicle(Vehicle vehicle,ParkingPlace parkingPlace) {
        parkingPlace.volume += vehicle.volume;
    }

    public void check_for_expiration(String current_time, Apartment apartment,Person person) {
        TenantLetter letter = null;
        if (apartment.end_date == current_time)
            letter = new TenantLetter(apartment_id,person);
            for(int i = 0; i < person.letters.length; i++) {
                if (person.letters[i] == null) {
                    person.letters[i] = letter;
                    break;
                }
            }
    }
}
