package com.hybrid.hybridhavenapi;

import com.hybrid.hybridhavenapi.Entity.Events;
import com.hybrid.hybridhavenapi.Repository.EventsRepository;
import com.hybrid.hybridhavenapi.Service.EventsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class HybridHavenApiApplicationTests {

	@MockBean
	EventsRepository eventsRepository;

	@Autowired
	EventsService eventsService;

	@Test
	void contextLoads() {
	}
	@Test
	public void deleteEvent(){
		Events event = new Events(1,"cricket","kinn dnjkd jd", Date.valueOf("2024-03-20"));
		Mockito.when(eventsRepository.findById(1)).thenReturn(Optional.of(event));

		eventsService.deleteEvent(1);

	}



}
