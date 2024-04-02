package com.c174.services.implementation;

import com.c174.dto.TicketDTO;
import com.c174.dto.TicketResponse;
import com.c174.models.Ticket.Ticket;
import com.c174.repositories.TicketRepository;
import com.c174.services.abstraction.TicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImplementationPostgreSql implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<TicketDTO> list() {

        List<Ticket> tickets = ticketRepository.findAll();

        tickets.stream().map(TicketResponse::new).toList();

        return null;
    }

    public List<TicketResponse> findAllLocktickets(Boolean lock){
        return ticketRepository.findAllTicketLock(lock).stream().map(TicketResponse::new).toList();
    }
    @Override
    public Boolean create(TicketDTO ticket) {

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
    public Boolean update(String id, TicketDTO ticket) {
        Optional<Ticket> ticketSerch = ticketRepository.updateTicket(ticket.getEventName(),ticket.getAvailable(),false,Long.valueOf(ticket.getId()));

        if (ticketSerch.isPresent()) return true;

        return false;
    }

    @Transactional
    @Override
    public Boolean delete(String id) {

        ticketRepository.deleteById(Long.valueOf(id));

        Optional<Ticket> ticketOptional = ticketRepository.findById(Long.valueOf(id));

        if (ticketOptional.isPresent()) return true;

        return false;
    }
}
