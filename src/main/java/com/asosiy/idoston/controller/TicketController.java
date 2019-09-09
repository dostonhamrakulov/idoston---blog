package com.asosiy.idoston.controller;

import com.asosiy.idoston.entity.Ticket;
import com.asosiy.idoston.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping(path = "/add", consumes = "application/json")
    public @ResponseBody ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){

        ticketRepository.save(ticket);
        return new ResponseEntity<>(new Ticket(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<List<Ticket>> getAllTickets(){

        Iterable<Ticket> iterable = ticketRepository.findAll();
        List<Ticket> ticketList = new ArrayList<>();

        iterable.forEach(ticketList::add);
        if(ticketList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ticketList, HttpStatus.OK);
        }
    }
}
