package com.aarhankhan.userportal.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException{
    public UserNotFoundException() {
        super("User with given email already exists!", HttpStatus.BAD_REQUEST);
    }
}
