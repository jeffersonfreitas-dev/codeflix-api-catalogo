package com.fullcycle.CatalogoVideo.domain.exception;

public class NotNullDomainException extends DomainException{

    public NotNullDomainException(){super();};

    public NotNullDomainException(String message){
        super(message);
    }
}
