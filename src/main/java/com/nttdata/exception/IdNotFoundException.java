package com.nttdata.exception;
import com.nttdata.utils.InformationError;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(String id) {
        super(String.format(InformationError.RESOURCE_ERROR_TYPE_ID.getMessage() + id));
    }
}