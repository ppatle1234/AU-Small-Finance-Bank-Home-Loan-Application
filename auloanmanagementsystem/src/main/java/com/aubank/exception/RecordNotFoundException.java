package com.aubank.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String msg){
        super(msg);
    }
}
