package com.nttdata.service;

import com.nttdata.entities.InformationPersonal;
import com.nttdata.exception.InformationException;
import com.nttdata.mapper.InformationPersonalMapper;
import com.nttdata.repository.InformationPersonalRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InformationPersonalImpl implements InformationPersonalService{
    private InformationPersonalRepository informationPersonalRepository;
    private InformationPersonalMapper informationPersonalMapper;

    @Override
    public InformationPersonal findByIdNumberAndTypeNumber(Integer id, String typeNumber) throws InformationException {
        return null;
    }
}
