package com.c174.models.ticket;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TicketRequest {
    private String meta;
    private List<CategoryRequest> categories;
    private Date createDate;

    public TicketRequest(String meta, List<CategoryRequest> categories) {
        this.meta = meta;
        this.categories = categories;
        // date is set to current date in service
    }

}
