package com.c174.models.market;

import com.c174.models.ticket.TicketEntity;
import com.c174.models.user.ProfileEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="Transaccion")
public class Transaction {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    @OneToMany
    private ProfileEntity profileSeller;
    @OneToOne
    private TicketEntity ticket;
    @OneToMany
    private ProfileEntity profileBuyer;
}
