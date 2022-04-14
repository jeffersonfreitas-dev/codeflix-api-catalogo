package com.fullcycle.CatalogoVideo.application.exception;

public class NotFoundException extends ApplicationException{

    public NotFoundException(){
        super();
    }

    public NotFoundException(String msg){
        super(msg);
    }

    public NotFoundException(String msg, Object... args){
        super(String.format(msg, args));
    }
}
