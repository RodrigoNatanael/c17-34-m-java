package com.c174.models.ticket;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequest {
    private String name;
    public CategoryRequest(String name) {
        this.name = name;
    }

}
