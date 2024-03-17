package com.luisbicho.workshopspringboot_jpa_hibernate.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}
