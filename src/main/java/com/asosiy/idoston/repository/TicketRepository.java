package com.asosiy.idoston.repository;

import com.asosiy.idoston.model.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    int countAllByPassed(String passed);

    @Transactional
    @Modifying
    @Query("update Ticket t set t.description = ?2 where t.idticket = ?1")
    int updateDescriptionByIdticket(int idticket, String description);

}
