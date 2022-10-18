package com.aarhankhan.userportal.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BaseException {

    public InvalidCredentialsException() {
        super("Invalid Credentials!", HttpStatus.UNAUTHORIZED);
    }

}
