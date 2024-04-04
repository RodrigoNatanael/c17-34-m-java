package com.c174.models.profile;

import com.c174.models.user.UserResponse;
import lombok.Data;

@Data
public class ProfileResponse {

    private Long id;
    private String lastname;
    private String name;
    private String document;
    private boolean isPresent;
    private UserResponse user;

    public ProfileResponse(ProfileEntity profileEntity) {
        this.id = profileEntity.getId();
        this.lastname = profileEntity.getLastname();
        this.name = profileEntity.getName();
        this.document = profileEntity.getDocument();
        this.isPresent = profileEntity.isPresent();
        this.user = new UserResponse(profileEntity.getUser().getId(), profileEntity.getUser().getEmail(),null);
    }
}
