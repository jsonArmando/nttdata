package com.nttdata.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INFORMATION_PERSONAL")
public class InformationPersonal {

    @Id
    @Column(name = "code")
    private Integer code;
    @Column(name = "id_number")
    private Integer idNumber;
    @Column(name = "type_number")
    private String typeNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "first_surname")
    private String firstSurname;
    @Column(name = "second_surname")
    private String secondSurname;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "address")
    private String address;
    @Column(name = "city_residence")
    private String cityResidence;
}