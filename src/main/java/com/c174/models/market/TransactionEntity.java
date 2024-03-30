package com.c174.models.market;

import com.c174.models.ticket.TicketEntity;
import com.c174.models.user.ProfileEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="Transaccion")
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    private ProfileEntity profileSeller;
    @OneToOne
    private TicketEntity ticket;
    @OneToOne
    private ProfileEntity profileBuyer;
}
