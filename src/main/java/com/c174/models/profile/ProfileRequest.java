package com.c174.models.profile;

import com.c174.models.user.UserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileRequest {
    private Long id;
    private String name;
    private String lastname;
    private String document;
    private boolean isPresent;
    private UserRequest user;

    public ProfileRequest(Long id, String name, String lastname, String document, boolean isPresent, UserRequest user) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.isPresent = isPresent;
        this.user = user;
    }

    public ProfileRequest(Long id, String name, String lastname, String document, boolean isPresent) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.isPresent = isPresent;
    }
    public ProfileRequest(Long id) {
        this.id = id;
    }
}
