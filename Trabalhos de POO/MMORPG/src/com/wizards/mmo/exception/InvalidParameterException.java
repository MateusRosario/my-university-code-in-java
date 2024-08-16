package com.wizards.mmo.exception;

public class InvalidParameterException extends Exception{
    public InvalidParameterException(String parametro){
        super(String.format("Parametro invalido: %s" , parametro));
    }
}
