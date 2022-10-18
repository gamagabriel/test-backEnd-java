package com.uol.api.exceptions;

public class CodinomeJáExistenteException extends Exception {

    public CodinomeJáExistenteException(String message){
        super(message);
    }

    public CodinomeJáExistenteException(){
        super("Codinome Já existe!");
    }
}
