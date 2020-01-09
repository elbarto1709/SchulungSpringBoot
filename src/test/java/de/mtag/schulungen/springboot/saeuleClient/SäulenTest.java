package de.mtag.schulungen.springboot.saeuleClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SäulenTest {

        JacksonTester<Tankvorgang> tankvorgang;

        @Autowired
        MockMvc mockMvc;

        @BeforeEach
        void init(){
                JacksonTester.initFields(this, new ObjectMapper());
        }

        @Test
        void testBezahlenAbgeschlossen() throws Exception{
                MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/bezahlenAbgeschlossen")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tankvorgang.write(new Tankvorgang(UUID.randomUUID())).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        }

}
