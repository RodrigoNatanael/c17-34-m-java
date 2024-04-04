package com.c174.models.category;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequest {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,50}$", message = "Invalid category name")
    private String name;
    public CategoryRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
