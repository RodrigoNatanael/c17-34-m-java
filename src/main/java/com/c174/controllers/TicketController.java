package com.c174.controllers;


import com.c174.dto.TicketResponse;
import com.c174.services.abstraction.TicketService;
import com.c174.services.implementation.TicketServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final TicketServiceImplementation ticketServiceImplementationPostgreSql;

    @GetMapping("find_locks")
    public ResponseEntity<?> findTicketsLocks(@RequestParam Boolean lock){
        List<TicketResponse> tickets = ticketServiceImplementationPostgreSql.findAllLocktickets(lock);
        if (tickets.isEmpty()) return new ResponseEntity<>("NO tickets available", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
