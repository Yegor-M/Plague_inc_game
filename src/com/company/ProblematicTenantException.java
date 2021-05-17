package com.company;

public class ProblematicTenantException extends IllegalArgumentException{
    ProblematicTenantException(String message) {
        super(message);
    }
}
