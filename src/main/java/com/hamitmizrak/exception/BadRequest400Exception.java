package com.hamitmizrak.exception;

// Bad request : 400
public class BadRequest400Exception extends RuntimeException{
    public BadRequest400Exception(String message) {
        super(message);
    }
}
