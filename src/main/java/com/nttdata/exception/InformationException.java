package com.nttdata.exception;

import com.nttdata.utils.InformationStatusError;
import lombok.Getter;

@Getter
public class InformationException extends Exception{
    private final InformationStatusError informationStatusError;
    public InformationException(InformationStatusError informationStatusError){
        super(informationStatusError == null ? null : informationStatusError.getMessage());
        this.informationStatusError = informationStatusError;
    }
    public InformationException(InformationStatusError informationStatusError, Exception exception){
        super(exception);
        this.informationStatusError =informationStatusError;
    }
}
