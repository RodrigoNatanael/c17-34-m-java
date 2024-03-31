package com.c174.controllers;


import com.c174.dto.TicketDTO;
import com.c174.services.abstraction.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
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
}
