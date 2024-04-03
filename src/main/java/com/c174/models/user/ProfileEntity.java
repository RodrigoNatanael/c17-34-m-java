package com.c174.models.user;

import com.c174.models.market.TransactionEntity;
import com.c174.models.ticket.TicketEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name="profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String lastname;
    private String name;
    private String document;
    private boolean isPresent;
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

//    @OneToMany
//    private List<Transaction> purchases;
//    @ManyToOne
//    private List<Transaction> sales;
//    @OneToMany
//    private List<TicketEntity> tickets;

}
