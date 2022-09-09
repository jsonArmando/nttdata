package com.nttdata.models.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InformationPersonalResponse implements Serializable {
    private String firstName;
    private String middleName;
    private String firstSurname;
    private String secondSurname;
    private Integer phone;
    private String address;
    private String cityResidence;
}
