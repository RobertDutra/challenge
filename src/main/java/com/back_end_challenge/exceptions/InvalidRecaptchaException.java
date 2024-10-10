package com.back_end_challenge.exceptions;

public class InvalidRecaptchaException extends Exception{
    String msg;

    public InvalidRecaptchaException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
