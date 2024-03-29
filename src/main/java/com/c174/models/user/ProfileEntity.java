package com.c174.models.user;

import com.c174.models.market.Transaction;
import com.c174.models.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="Profiles")
public class ProfileEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;
    private String lastname;
    private String name;
    private String document;
    private boolean isPresent;
    private String documents;
    @ManyToOne
    private List<Transaction> purchases;
    @ManyToOne
    private List<Transaction> sales;
    @OneToMany
    private List<TicketEntity> tickets;


}
