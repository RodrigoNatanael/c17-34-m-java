package com.c174.models.user;

import com.c174.models.ticket.TicketResponse;
import lombok.Data;

import java.util.stream.Collectors;

@Data
public class UserResponse {
    private Long id;
    private String mail;
    private ProfileResponse profile;

    public UserResponse(Long id, String mail, ProfileResponse profile) {
        this.id = id;
        this.mail = mail;
        this.profile = profile;
    }

}
