package com.c174.models.user;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String mail;
    private String password;
    private ProfileResponse profile;

    public UserResponse(Long id, String mail, String password, ProfileResponse profile) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.profile = profile;
    }

}
