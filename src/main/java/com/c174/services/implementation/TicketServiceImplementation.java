package com.c174.services.implementation;

import com.c174.dto.TicketDTO;
import com.c174.dto.TicketResponse;
import com.c174.models.Ticket.Ticket;
import com.c174.repositories.TicketRepository;
import com.c174.services.abstraction.TicketService;
import com.c174.tools.QrGeneration;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TicketServiceImplementation implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<TicketDTO> list() {

        List<Ticket> tickets = ticketRepository.findAll();

        tickets.stream().map(TicketResponse::new).toList();

        return null;
    }

    @Override
    public List<TicketResponse> findAllLocktickets(Boolean lock){
        return ticketRepository.findAllTicketLock(lock).stream().map(TicketResponse::new).toList();
    }

    @Override
    public TicketResponse checkInTicket(File file) throws IOException {
        String data = QrGeneration.returnBase64(file);
        Optional<Ticket> ticketResponse = ticketRepository.checkInTicket(data);
        if (ticketResponse.isPresent()) return new TicketResponse(ticketResponse.get());
        return null;
    }

    @Override
    public TicketDTO create(TicketDTO ticket) {

        Ticket ticketToPersist = new Ticket();

        ticketToPersist.setEvent(ticket.getEventName());
        ticketToPersist.setIsPresent(true);
        ticketToPersist.setItsLock(false);
        ticketToPersist.setQr(null);

        Ticket ticketReturned = ticketRepository.save(ticketToPersist);

        return !ticketReturned.getEvent().isEmpty();
    }

    @Transactional
    @Override
    public TicketDTO update(String id, TicketDTO ticket) {
        Optional<Ticket> ticketSerch = ticketRepository.updateTicket(ticket.getEventName(),ticket.getAvailable(),false,Long.valueOf(ticket.getId()));

        if (ticketSerch.isPresent()) return true;

        return false;
    }

    @Transactional
    @Override
    public TicketDTO delete(String id) {

        ticketRepository.deleteById(Long.valueOf(id));

        Optional<Ticket> ticketOptional = ticketRepository.findById(Long.valueOf(id));

        if (ticketOptional.isPresent()) return true;

        return false;
    }
}
