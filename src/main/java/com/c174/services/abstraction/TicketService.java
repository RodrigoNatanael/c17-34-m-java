package com.c174.services.abstraction;

import com.c174.dto.TicketDTO;
import com.c174.dto.TicketResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface TicketService {
    List<TicketDTO> list();
    TicketDTO create(TicketDTO ticket);
    TicketDTO update(String id,TicketDTO ticket);
    TicketDTO delete(String id);
    List<TicketResponse> findAllLocktickets(Boolean lock);
    TicketResponse checkInTicket(File file) throws IOException;
}
