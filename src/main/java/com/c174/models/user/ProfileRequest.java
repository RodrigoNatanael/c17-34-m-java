package com.c174.models.user;

import lombok.Data;

@Data
public class ProfileRequest {

    private String name;
    private String lastname;
    private String document;
    private boolean isPresent;
    private UserRequest user;

    public ProfileRequest(String name, String lastname, String document, boolean isPresent, UserRequest user) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.isPresent = isPresent;
        this.user = user;
    }
}
