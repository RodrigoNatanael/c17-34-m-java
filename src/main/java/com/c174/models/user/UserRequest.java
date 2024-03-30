package com.c174.models.user;

import lombok.Data;

@Data
public class UserRequest {

        private String mail;
        private String password;
        private ProfileRequest profile;

        public UserRequest(String mail, String password, ProfileRequest profile) {
            this.mail = mail;
            this.password = password;
            this.profile = profile;
        }
}
