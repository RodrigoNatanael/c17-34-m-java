package com.c174.services.abstraction;

import com.c174.dto.TicketDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface TicketService {
    List<TicketDTO> list();
    Boolean create(TicketDTO ticket);
    Boolean update(String id,TicketDTO ticket);
    Boolean delete(String id);
}
