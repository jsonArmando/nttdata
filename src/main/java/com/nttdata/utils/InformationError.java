package com.nttdata.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@ToString
public enum InformationError {
    UNEXPECTED_ERROR(0, "Error inesperado."),
    BAD_REQUEST_INVALID_ARGUMENTS(1,"Error de Validacion. Detalle en el campo 'errors'."),
    BAD_REQUEST_INVALID_PARAMETERS(2, "Falta parametro requerido."),
    ENDPOINT_NOT_FOUND(3, "Endpoint no encontrado."),
    RESOURCE_INFORMATION_NOT_FOUND(100, "Recurso Información Personal no encontrado."),
    RESOURCE_ERROR_TYPE_ID(1, "No corresponde un tipo de identificación valido: ");


    private final Integer code;
    private final String message;

    public HttpStatus getStatus() {
        switch (this) {
            case BAD_REQUEST_INVALID_ARGUMENTS:
            case BAD_REQUEST_INVALID_PARAMETERS:
                return HttpStatus.BAD_REQUEST;
            case ENDPOINT_NOT_FOUND:
            case RESOURCE_INFORMATION_NOT_FOUND:
                return HttpStatus.NOT_FOUND;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
