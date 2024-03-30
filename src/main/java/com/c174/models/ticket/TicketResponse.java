package com.c174.models.ticket;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TicketResponse {
    private Long id;
    private String meta;
    private List<CategoryResponse> categories;
    private Date createDate;

    public TicketResponse(TicketEntity ticket) {
        this.id = ticket.getId();
        this.meta = ticket.getMeta();
        this.categories = ticket.getCategories().stream()
                .map(CategoryResponse::new).collect(Collectors.toList());
        this.createDate = ticket.getCreateDate();
    }
}
