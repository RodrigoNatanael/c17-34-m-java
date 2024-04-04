package com.c174.models.user;

import com.c174.models.embed.Audit;
import com.c174.models.profile.ProfileEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProfileEntity profile;
    @Embedded
    private Audit audit = new Audit();

    public void setProfile(ProfileEntity profile) {
        if (profile == null) {
            if (this.profile != null) {
                this.profile.setUser(null);
            }
        } else {
            profile.setUser(this);
        }
        this.profile = profile;
    }

}


