package com.uol.api.exceptions;

public class CodinomeJáExistenteException extends Exception {

    //https://www.baeldung.com/java-new-custom-exception
    //https://www.devmedia.com.br/diferenca-entre-checked-e-unchecked-exceptions-em-java/28908
    public CodinomeJáExistenteException(String message, Throwable cause){
        super(message, cause);
    }

}
