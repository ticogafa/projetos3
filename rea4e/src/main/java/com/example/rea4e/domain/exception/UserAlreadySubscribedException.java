package com.example.rea4e.domain.exception;

public class UserAlreadySubscribedException extends RuntimeException {

    public UserAlreadySubscribedException(String string){
        super(string);
    }

}
