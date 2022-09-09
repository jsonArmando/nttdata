package com.nttdata.controller;

import com.google.gson.Gson;
import com.nttdata.NttdataApplication;
import com.nttdata.models.reponse.InformationPersonalResponse;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockserver.integration.ClientAndServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NttdataApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureEmbeddedDatabase
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PersonalInformationTest {
    @Autowired
    MockMvc mvc;
    private static final String ENDPOINT = "/v1/information/data";

    ClientAndServer mockServer = ClientAndServer.startClientAndServer(8090); //to mock rest server if needed

    @Autowired
    protected Flyway flyway;

    Gson gson = new Gson();

    @BeforeAll
    public static void initAllTests() {
    }

    @AfterAll
    public static void endAllTests() {
    }

    @Before
    public void setupTest() {
        flyway.clean();
        flyway.migrate();
    }

    @After
    public void cleanupTest() {
        mockServer.reset();
    }

    @Test
    public void findInformationWhenSuccessResult() throws Exception{
        List<InformationPersonalResponse> lsResponses = List.of(new InformationPersonalResponse(
                "Pepito","Emilio","Perez","Rodriguez",123456789,"Calle falsa 123","Bogotá"
        ));
        var json = gson.toJson(lsResponses);
        mvc.perform(get(ENDPOINT)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().json(json));
    }
}
