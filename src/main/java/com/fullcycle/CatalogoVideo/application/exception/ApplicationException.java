package com.fullcycle.CatalogoVideo.application.exception;

public class ApplicationException extends RuntimeException{

    public ApplicationException (){
        super();
    }

    public ApplicationException(String msg){
        super(msg);
    }
}
