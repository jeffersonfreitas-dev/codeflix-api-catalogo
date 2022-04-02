package com.fullcycle.CatalogoVideo.domain;

public class NotBlankDomainException extends DomainException{

    public NotBlankDomainException(){super();};

    public NotBlankDomainException(String message){
        super(message);
    }
}
