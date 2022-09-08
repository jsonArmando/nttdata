package com.nttdata.service;

import com.nttdata.entities.InformationPersonal;
import com.nttdata.exception.InformationException;

public interface InformationPersonalService {
    InformationPersonal findByIdNumberAndTypeNumber(Integer id, String typeNumber) throws InformationException;

}
