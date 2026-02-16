package com.dev.healthcare.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String resource, String field, String value) {
        super(resource + " not found with " + field + " : " + value);
    }



}
