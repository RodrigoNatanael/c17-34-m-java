package com.c174.repositories;

import com.c174.models.Ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


    @Modifying
    @Query("UPDATE Ticket t SET t.event = :event, t.isPresent = :isPresent t.isLock = :isLock WHERE id = :id")
    Optional<Ticket> updateTicket(@Param("event")String event, @Param("isPresent")Boolean isPresent,@Param("isLock")Boolean isLock, @Param("id")Long id);

    @Query("SELECT t FROM Ticket t WHERE t.event = :event")
    List<Ticket> findTicketsByEvent(@Param("event")String event);

    @Query("SELECT t FROM Ticket t WHERE t.isPresent = true AND isLock = false")
    List<Ticket> findAllTicketAvailable();

    @Query("SELECT t FROM Ticket t WHERE t.isPresent = true")
    List<Ticket> findAllTicketPresents();

    @Query("SELECT t FROM Ticket t WHERE t.isPresent = true AND isLock = :isLock")
    List<Ticket> findAllTicketLock(@Param("isLock")Boolean isLock);
}
