package com.hamitmizrak.exception;

// Bad request : 400
public class NotFound404Exception extends RuntimeException{
    public NotFound404Exception(String message) {
        super(message);
    }
}
