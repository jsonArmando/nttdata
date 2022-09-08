package com.nttdata.service;

import com.nttdata.exception.InformationException;
import com.nttdata.models.reponse.InformationPersonalResponse;

import java.util.List;

public interface InformationPersonalService {
    List<InformationPersonalResponse> findByIdNumberAndTypeNumber(Integer id, String typeNumber) throws InformationException;

}
