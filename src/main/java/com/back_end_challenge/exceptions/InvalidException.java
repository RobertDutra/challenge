package com.back_end_challenge.exceptions;

public class InvalidException extends Exception{
    String msg;

    public InvalidException(String msg) {
        super(msg);
        this.msg = msg;
    }
}