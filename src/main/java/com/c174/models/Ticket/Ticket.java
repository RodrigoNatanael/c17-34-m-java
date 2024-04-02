package com.c174.models.Ticket;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "qr")
    private String qr;
    @Column(name = "is_present")
    private Boolean isPresent;
    @Column(name = "its_lock")
    private Boolean itsLock;
    @Column(name = "event")
    private String event;

}
