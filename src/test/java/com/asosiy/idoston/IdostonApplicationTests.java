package com.asosiy.idoston;

import com.asosiy.idoston.model.Ticket;
import com.asosiy.idoston.repository.TicketRepository;
import com.asosiy.idoston.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class IdostonApplicationTests {


//	@Autowired
//	private TicketRepository ticketRepository;

	@Mock
	TicketService ticketService;

//	@InjectMocks
//	TicketService ticketService;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllTickets(){

		List<Ticket> ticketList = new ArrayList<>();
		Ticket ticket = new Ticket(10, "Berlin", "desc", "date", "some url", "a location", "True", 1);
		ticketList.add(ticket);
		when(ticketService.getAllTickets()).thenReturn(ticketList);

		assertEquals(1, ticketService.getAllTickets().size());

		assertEquals("Berlin", ticketService.getAllTickets().get(0).getName());
		assertEquals("date", ticketService.getAllTickets().get(0).getPubdate());

	}

	@Test
	public void testUpcoming(){

		when(ticketService.getUpcoming("False")).thenReturn(1);
		assertEquals(1, ticketService.getUpcoming("False"));
		assertEquals(0, ticketService.getUpcoming("True"));

	}

	@Test
	public void testUpdateDescription(){
		when(ticketService.updateDescription(10, "New Description")).thenReturn(2);
		assertEquals(2, ticketService.updateDescription(10, "New Description"));
		assertEquals(0, ticketService.updateDescription(10, "Some Description"));
	}

}
