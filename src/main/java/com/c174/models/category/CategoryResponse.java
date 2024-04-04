package com.c174.models.category;

import com.c174.models.ticket.TicketResponse;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private List<TicketResponse> tickets;

    public CategoryResponse(CategoryEntity category) {
        this.id = category.getId();
        this.name = category.getName();
        this.tickets = (category.getTickets() != null) ? category.getTickets().stream()
                .map(TicketResponse::new).collect(Collectors.toList()) : null;
    }
}
