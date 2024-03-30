package com.c174.models.ticket;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="tickets")
@Data
public class TicketEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String meta;
    @ManyToMany
    private List<CategoryEntity> categories;
    private Date createDate;


}
