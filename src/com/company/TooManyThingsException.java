package com.company;

public class TooManyThingsException extends IllegalArgumentException{
    TooManyThingsException(String message) {
        super(message);
    }
}
