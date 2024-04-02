package com.c174.models.ticket;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequest {
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,50}$", message = "Invalid category name")
    private String name;
    public CategoryRequest(String name) {
        this.name = name;
    }

}
