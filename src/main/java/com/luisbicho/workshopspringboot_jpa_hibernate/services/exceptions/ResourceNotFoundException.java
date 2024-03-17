package com.luisbicho.workshopspringboot_jpa_hibernate.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id "+id);
    }
}
