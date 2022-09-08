package com.nttdata.service;

import com.nttdata.entities.InformationPersonal;
import com.nttdata.exception.InformationException;
import com.nttdata.mapper.InformationPersonalMapper;
import com.nttdata.models.reponse.InformationPersonalResponse;
import com.nttdata.repository.InformationPersonalRepository;
import com.nttdata.utils.InformationStatusError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InformationPersonalImpl implements InformationPersonalService{
    private final InformationPersonalRepository informationPersonalRepository;
    private final InformationPersonalMapper informationPersonalMapper;

    @Override
    public List<InformationPersonalResponse> findByIdNumberAndTypeNumber(Integer id, String typeNumber) throws InformationException {
        log.debug("InformationPersonalImpl.findByIdNumberAndTypeNumber for code {}", id);
        var listResponse = informationPersonalRepository.findByIdNumberAndTypeNumber(id, typeNumber);
        if(listResponse.isEmpty()){
            throw new InformationException(InformationStatusError.UNEXPECTED_ERROR);
        }
        var response = listResponse.stream().map(informationPersonalMapper::toResponse).collect(Collectors.toList());
        log.debug("InformationPersonalImpl.findByIdNumberAndTypeNumber result {}", response);
        return response;
    }
}
