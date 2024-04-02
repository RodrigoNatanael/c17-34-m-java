package com.c174.dto;

import com.c174.models.Ticket.Ticket;

public record TicketResponse(String event,
                             Long id,
                             String qr) {


    public TicketResponse(Ticket ticket){
        this(ticket.getEvent(), ticket.getId(), ticket.getQr());
    }
}
