package com.nttdata.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Constants {
    TYPE_ID_CC("C", "Error inesperado el tipo de idebtificación no es una cédula"),
    TYPE_ID_PP("P", "Error inesperado el tipo de idebtificación no es un pasaporte");
    private final String code;
    private final String message;
}
