package com.fullcycle.CatalogoVideo.domain;

public class NotNullDomainException extends DomainException{

    public NotNullDomainException(){super();};

    public NotNullDomainException(String message){
        super(message);
    }
}
