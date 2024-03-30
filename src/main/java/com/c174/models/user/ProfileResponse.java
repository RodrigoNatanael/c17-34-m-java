package com.c174.models.user;

import lombok.Data;

@Data
public class ProfileResponse {

    private Long id;
    private String lastname;
    private String name;
    private String document;
    private boolean isPresent;
    private UserResponse user;

    public ProfileResponse(Long id, String lastname, String name, String document, boolean isPresent, UserResponse user) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.document = document;
        this.isPresent = isPresent;
        this.user = user;
    }
}
