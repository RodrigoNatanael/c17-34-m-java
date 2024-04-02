package com.c174.models.user;

import com.c174.models.market.TransactionEntity;
import com.c174.models.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name="profiles")
@Data
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String lastname;
    private String name;
    private String document;
    private boolean isPresent;
    @OneToOne
    private UserEntity user;

//    @OneToMany
//    private List<Transaction> purchases;
//    @ManyToOne
//    private List<Transaction> sales;
//    @OneToMany
//    private List<TicketEntity> tickets;

    public ProfileEntity() {
    }
    public ProfileEntity(String lastname, String name, String document, Boolean isPresent, UserEntity user) {
        this.lastname = lastname;
        this.name = name;
        this.document = document;
        this.isPresent = isPresent;
        this.user = user;
    }
}
