package com.c174.models.user;

import com.c174.models.profile.ProfileResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

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
