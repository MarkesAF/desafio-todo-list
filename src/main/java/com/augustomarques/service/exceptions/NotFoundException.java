package com.augustomarques.service.exceptions;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NotFoundException(String msg, Object id){
        super("Not Found. Id: "+id);
    }

}
