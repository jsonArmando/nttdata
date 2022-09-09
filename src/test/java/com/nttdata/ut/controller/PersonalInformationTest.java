package com.nttdata.ut.controller;

import com.google.gson.Gson;
import com.nttdata.controller.PersonalInformationController;
import com.nttdata.exception.ControllerExceptionHandler;
import com.nttdata.models.reponse.InformationPersonalResponse;
import com.nttdata.service.InformationPersonalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
public class PersonalInformationTest {

    @Mock
    InformationPersonalService personalService;
    PersonalInformationController informationController;

    private static final String ENDPOINT = "/v1/information/data/?id=23445322&idNumber=C";
    private static final String ENDPOINT_BAD_RQUEST = "/v1/information/data";

    private final String CHARACTER_ENCODING = "utf-8";

    private final Integer id=23445322;
    private final String idType ="C";

    private MockMvc mvc;
    List<InformationPersonalResponse> responses;

    @Before
    public void setupDataTest() {
        responses = new ArrayList<>();
        responses.add(new InformationPersonalResponse(
                "Pepito","Emilio","Perez","Rodriguez",123456789,"Calle falsa 123","Bogotá"
        ));

        this.informationController = new PersonalInformationController(personalService);
        this.mvc = MockMvcBuilders
                .standaloneSetup(informationController)
                .addDispatcherServletCustomizer(
                        dispatcherServlet -> dispatcherServlet
                                .setThrowExceptionIfNoHandlerFound(true))
                .setControllerAdvice(
                        ControllerExceptionHandler.class)
                .build();
    }


    @Test
    public void shouldfindByIdNumberAndTypeNumberOk() throws Exception {

        when(personalService.findByIdNumberAndTypeNumber(id,idType)).thenReturn(responses);
        mvc.perform(MockMvcRequestBuilders
                        .get(ENDPOINT)
                        .accept(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .characterEncoding(CHARACTER_ENCODING))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json(new Gson().toJson(responses)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
