package com.company;
import java.util.UUID;

public class TenantLetter {
    public UUID apartment_tenant_uuid;
    public Person person;

    public TenantLetter(UUID apartment_tenant_uuid, Person person) {
        this.apartment_tenant_uuid = apartment_tenant_uuid;
        this.person = person;
    }
}
