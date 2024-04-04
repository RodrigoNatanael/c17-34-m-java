package com.c174.models.user;

import com.c174.models.profile.ProfileRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRequest{
        private Long id;
        private String mail;
        private String password;
        private ProfileRequest profile;

        public UserRequest(String mail, String password, ProfileRequest profile) {
            this.mail = mail;
            this.password = password;
            this.profile = profile;
        }
        public UserRequest(String mail, String password) {
            this.mail = mail;
            this.password = password;
        }
        public UserRequest(String mail) {
            this.mail = mail;
            this.password = password;
        }

        public UserRequest(Long id){
            this.id = id;
        }
}
