package com.c174.models.ticket;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Tickets")
public class TicketEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;

    private String meta;
    @OneToMany
    private List<CategoryEntity> category;
    private Date createDate;


}
