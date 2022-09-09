package com.nttdata.ut.services;
import com.nttdata.entities.InformationPersonal;
import com.nttdata.exception.InformationException;
import com.nttdata.mapper.InformationPersonalMapper;
import com.nttdata.mapper.InformationPersonalMapperImpl;
import com.nttdata.models.reponse.InformationPersonalResponse;
import com.nttdata.repository.InformationPersonalRepository;
import com.nttdata.service.InformationPersonalImpl;
import com.nttdata.service.InformationPersonalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class InformationPersonalTest {
    @Mock
    InformationPersonalRepository personalRepository;
    InformationPersonalMapper personalMapper;
    InformationPersonalService personalService;

    List<InformationPersonalResponse> responses;
    List<InformationPersonal> personals;

    public static final Integer ID = 23445322;
    public static final String ID_TYPE = "C";

    @Before
    public void initialLoad() {
        personalMapper = new InformationPersonalMapperImpl();
        personalService = new InformationPersonalImpl(personalRepository, personalMapper);

        personals = new ArrayList<>();
        personals.add(new InformationPersonal(
                1,23445322,"C","Pepito","Emilio","Perez","Rodriguez",123456789,"Calle falsa 123","Bogotá"
        ));
        responses = personals.stream()
                .map(hs -> new InformationPersonalResponse(hs.getFirstName(),
                        hs.getMiddleName(),hs.getFirstSurname(),hs.getSecondSurname(),
                        hs.getPhone(),hs.getAddress(),hs.getCityResidence())).collect(Collectors.toList());
    }

    @Test
    public void shouldfindByIdNumberAndTypeNumberWhenSuccessResult() throws InformationException {

        when(personalRepository.findByIdNumberAndTypeNumber(ID,ID_TYPE)).thenReturn((personals));
        List<InformationPersonalResponse> result = personalService.findByIdNumberAndTypeNumber(ID,ID_TYPE);
        assertEquals(responses, result);
    }
}