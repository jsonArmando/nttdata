package com.nttdata.mapper;

import com.nttdata.controller.PersonalInformation;
import com.nttdata.models.reponse.InformationPersonalResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InformationPersonalMapper {
    @Mapping(target = "code", source = "code")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "firstSurname", source = "firstSurname")
    @Mapping(target = "secondSurname", source = "secondSurname")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "cityResidence", source = "cityResidence")
    InformationPersonalResponse toResponse(PersonalInformation personalInformation);
}