package com.asosiy.idoston.repository;

import com.asosiy.idoston.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
