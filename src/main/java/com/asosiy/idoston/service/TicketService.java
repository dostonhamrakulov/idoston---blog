package com.asosiy.idoston.service;

import com.asosiy.idoston.model.Ticket;
import com.asosiy.idoston.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.asosiy.idoston.store.Common.getCurrentDate;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private Ticket main_ticket;

    public Ticket addTicket(Ticket ticket){

        main_ticket = ticket;
        main_ticket.setPubdate(getCurrentDate());
        main_ticket = ticketRepository.save(ticket);
        return main_ticket;
    }

    public List<Ticket> getAllTickets(){

        Iterable<Ticket> iterable = ticketRepository.findAll();
        List<Ticket> ticketList = new ArrayList<>();
        iterable.forEach(ticketList::add);
        return ticketList;
    }

    public int getUpcoming(String passed){
        return ticketRepository.countAllByPassed(passed);
    }

    public int updateDescription(int idticket, String description){
        return ticketRepository.updateDescriptionByIdticket(idticket, description);
    }
}
