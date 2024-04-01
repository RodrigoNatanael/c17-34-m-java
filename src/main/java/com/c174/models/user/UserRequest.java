package com.c174.models.user;

import lombok.Data;

@Data
public class UserRequest {

        private String mail;
        private String password;

        public UserRequest(String mail, String password) {
            this.mail = mail;
            this.password = password;
        }
}
