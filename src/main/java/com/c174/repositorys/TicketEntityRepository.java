package com.c174.repositorys;

import com.c174.models.ticket.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long> {

}
