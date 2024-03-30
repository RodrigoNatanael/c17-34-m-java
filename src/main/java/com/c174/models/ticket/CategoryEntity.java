package com.c174.models.ticket;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="categorias")
@Data
@NoArgsConstructor
public class CategoryEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToMany
    private List<TicketEntity> tickets;

    public CategoryEntity(String name) {
        this.name = name;
    }

    public CategoryEntity(CategoryRequest categoryRequest) {
        this.name = categoryRequest.getName();
    }
}
