package com.c174.models.ticket;

import com.c174.models.category.CategoryRequest;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TicketRequest {
    private Long id;
    private String meta;
    private List<CategoryRequest> categories;
    public TicketRequest(Long id,String meta) {
        this.id = id;
        this.meta = meta;
    }
    public TicketRequest(Long id) {
        this.id = id;
    }

}
