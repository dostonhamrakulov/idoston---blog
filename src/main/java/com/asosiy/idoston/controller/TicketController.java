package com.asosiy.idoston.controller;

import com.asosiy.idoston.model.Ticket;
import com.asosiy.idoston.repository.TicketRepository;
import com.asosiy.idoston.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.asosiy.idoston.store.Common.getCurrentDate;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    Ticket main_ticket;

    @PostMapping(path = "/add", consumes = "application/json")
    public @ResponseBody ResponseEntity<String> addTicket(@RequestBody Ticket ticket){


        main_ticket = ticketService.addTicket(ticket);
        if (main_ticket != null){
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Not created", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<List<Ticket>> getAllTickets(){

        List<Ticket> ticketList = ticketService.getAllTickets();

        if(ticketList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ticketList, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/number-of-tickets")
    public @ResponseBody ResponseEntity<Integer> numFeed(){

        List<Ticket> ticketList = ticketService.getAllTickets();
        if(ticketList.size() > 0){
            return new ResponseEntity<>(ticketList.size(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/upcoming")
    public @ResponseBody ResponseEntity<Integer> upcoming(@RequestParam("passed") String passed){

        int num_passed = ticketService.getUpcoming(passed);

        if (num_passed > 0) {
            return new ResponseEntity<>(num_passed, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/update-by-description")
    public @ResponseBody ResponseEntity<Integer> updateDescription(@RequestParam("idticket") int idticket,
                                                                   @RequestParam("description") String description){

        int num_updated = ticketService.updateDescription(idticket, description);

        if (num_updated > 0) {
            return new ResponseEntity<>(num_updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
    }
}
