package com.c174.controllers;


import com.c174.dto.TicketDTO;
import com.c174.dto.TicketResponse;
import com.c174.models.Ticket.Ticket;
import com.c174.services.abstraction.TicketService;
import com.c174.services.implementation.TicketServiceImplementationPostgreSql;
import com.google.api.Http;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final TicketServiceImplementationPostgreSql ticketServiceImplementationPostgreSql;
    public TicketController(TicketService ticketService, TicketServiceImplementationPostgreSql ticketServiceSql) {
        this.ticketService = ticketService;
        this.ticketServiceImplementationPostgreSql = ticketServiceSql;
    }
    @GetMapping("/list")
    public ResponseEntity list(){
        return new ResponseEntity(ticketService.list(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody TicketDTO ticket){
        return new ResponseEntity(ticketService.create(ticket), HttpStatus.OK);
    }
    @PutMapping("{id}/update")
    public ResponseEntity update(@PathVariable String id, @RequestBody TicketDTO ticket){
        return new ResponseEntity(ticketService.update(id,ticket), HttpStatus.OK);
    }
    @DeleteMapping("{id}/delete")
    public ResponseEntity delete(@PathVariable String id){
        return new ResponseEntity(ticketService.delete(id), HttpStatus.OK);
    }

    @GetMapping("find_locks")
    public ResponseEntity<?> findTicketsLocks(@RequestParam Boolean lock){
        List<TicketResponse> tickets = ticketServiceImplementationPostgreSql.findAllLocktickets(lock);
        if (tickets.isEmpty()) return new ResponseEntity<>("NO tickets available", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
