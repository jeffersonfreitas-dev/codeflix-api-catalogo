package com.fullcycle.CatalogoVideo.domain.exception;

public class NotBlankDomainException extends DomainException{

    public NotBlankDomainException(){super();};

    public NotBlankDomainException(String message){
        super(message);
    }
}
