package com.nttdata.service;

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
}
