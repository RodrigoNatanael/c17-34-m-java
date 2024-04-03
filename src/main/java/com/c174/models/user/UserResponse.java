package com.c174.models.user;

import com.c174.models.ticket.TicketResponse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String mail;

    private ProfileResponse profile;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.mail = userEntity.getEmail();
        this.profile = new ProfileResponse(userEntity.getProfile());
    }

}
