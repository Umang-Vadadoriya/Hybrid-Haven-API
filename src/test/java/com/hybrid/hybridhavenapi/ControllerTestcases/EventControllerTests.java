package com.hybrid.hybridhavenapi.ControllerTestcases;

import com.hybrid.hybridhavenapi.Controller.EventsController;
import com.hybrid.hybridhavenapi.Entity.Events;
import com.hybrid.hybridhavenapi.Service.EventsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@WebMvcTest(EventsController.class)
@AutoConfigureMockMvc
public class EventControllerTests {

    @MockBean
    private EventsService eventsService;

    @Autowired
    private MockMvc mockMvc;

    String token = "ya29.a0Ad52N38xe3cEuKtpa9uoTceuiv9nNxVUlx6f19g913T2MaVfKXcrDmZIDFtTfmJaZZXH4v_AgmUIE4obL4wCrCK8dtVNeaMXlsJdmWT1YjxviZExRajOuL4qZcgKA1rJaAZI3vihERSyFv1bDPmkoGn2L7rACysozJxWPwaCgYKARoSARISFQHGX2Mis04pw7Fbs_BIeQFZ_fRy3A0173";
    // Test getEventById from Event service
    @Test
    void getEventById_returns_WhenEventExists() throws Exception {
        Events event = new Events(1,"Lunch","At Absolute Barbeque", Date.valueOf("2024-01-12"));


        Mockito.when(eventsService.getEventById(1)).thenReturn(Optional.of(event));

        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.get("/events/1")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .header("X-Requested-With", "XMLHttpRequest"))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.eventId").value(1))
                .andExpect(jsonPath("$.eventDate").value("2024-01-12"))
                .andDo(print()).andReturn();

        log.info(result.getResponse().getContentAsString());
    }

    @Test
    void getAllEvents_returns_WhenEventExists() throws Exception {

        Events event1 = new Events(1,"Cricket","LSBN Turf",Date.valueOf("2024-03-21"));
        Events event2 = new Events(2,"Tech-Away","Knowledge sharing",Date.valueOf("2024-03-20"));

        List<Events> events = Arrays.asList(event1,event2);

        Mockito.when(eventsService.getAllEvents()).thenReturn(events);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/events")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        .header("X-Requested-With", "XMLHttpRequest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn();

        log.info(result.getResponse().getContentAsString());
    }


}
