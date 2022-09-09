package com.nttdata.exception;

import com.nttdata.utils.InformationError;
import lombok.Getter;

@Getter
public class InformationException extends Exception{
    private final InformationError informationError;
    public InformationException(InformationError informationError){
        super(informationError == null ? null : informationError.getMessage());
        this.informationError = informationError;
    }
    public InformationException(InformationError informationError, Exception exception){
        super(exception);
        this.informationError = informationError;
    }
}
